package com.example.app.controller.restcontroller.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.requestDTO.ChatMessageDTORequest;
import com.example.app.dto.responseDTO.ChatMessageDTOResponse;
import com.example.app.entity.Conversation;
import com.example.app.entity.Message;
import com.example.app.entity.User;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.ConversationService;
import com.example.app.service.serviceInterface.MessageService;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody ChatMessageDTORequest messageRequest) {
        int senderId = messageRequest.getSenderId();
        int receiverId = messageRequest.getReceiverId();
        String content = messageRequest.getContent();

        User sender = userRepo.findByUserId(senderId);
        User receiver = userRepo.findByUserId(receiverId);

        if (sender == null || receiver == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        Conversation conversation;
        try {
            conversation = conversationService.getConversationByTwoUser(senderId, receiverId);
        } catch (RuntimeException e) {
            conversation = conversationService.createConversation(sender, receiver);
        }

        Message message = messageService.sendMessage(conversation, senderId, content);

        ChatMessageDTOResponse response = new ChatMessageDTOResponse();
        response.setSenderId(senderId);
        response.setSenderUsername(sender.getUsername());
        response.setReceiverId(receiverId);
        response.setContent(content);
        response.setSendAt(message.getSendAt().toString());

        messagingTemplate.convertAndSend("/topic/chat/" + receiverId, response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/conversations/{userId}")
    public List<Map<String, Object>> getAllConversations(@PathVariable int userId) {
        User user = userRepo.findByUserId(userId);
        if (user == null) throw new RuntimeException("User not found");

        List<Conversation> convos = conversationService.findAllByUser(user);
        List<Map<String, Object>> result = new ArrayList<>();

        for (Conversation convo : convos) {
            Map<String, Object> map = new HashMap<>();
            map.put("conversationId", convo.getConversationId());

            List<Map<String, Object>> participants = new ArrayList<>();
            for (User u : Arrays.asList(convo.getUser1(), convo.getUser2())) {
                Map<String, Object> userInfo = new HashMap<>();
                userInfo.put("user", u);
                participants.add(userInfo);
            }

            map.put("participants", participants);
            result.add(map);
        }

        return result;
    }

    @GetMapping("/conversations/{conversationId}/messages")
    public List<ChatMessageDTOResponse> getMessages(
            @PathVariable Long conversationId,
            @RequestParam int receiverId
    ) {
        Conversation conversation = conversationService.findById(conversationId);
        List<Message> messages = messageService.getAllMessageByConversation(conversation);

        return messages.stream().map(msg -> {
            ChatMessageDTOResponse dto = new ChatMessageDTOResponse();
            dto.setSenderId(msg.getSender().getUser_id());
            dto.setSenderUsername(msg.getSender().getUsername());
            dto.setReceiverId(receiverId);
            dto.setContent(msg.getContent());
            dto.setSendAt(msg.getSendAt().toString());
            return dto;
        }).collect(Collectors.toList());
    }
}

