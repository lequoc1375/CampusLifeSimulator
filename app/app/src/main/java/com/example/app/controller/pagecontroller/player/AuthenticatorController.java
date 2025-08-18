package com.example.app.controller.pagecontroller.player;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.entity.User;
import com.example.app.repository.UserRepo;
import com.example.app.security.TwoFactorAuthService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthenticatorController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    @Qualifier("jasyptStringEncryptor")
    private StringEncryptor stringEncryptor;

    @GetMapping("/2fa/setup")
    public String twoFaSetup(@RequestParam String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            return "redirect:/register";
        }

        String decryptedSecret;
        try {
            decryptedSecret = stringEncryptor.decrypt(user.getSecret());
        } catch (Exception ex) {
            return "redirect:/register";
        }

        if (decryptedSecret == null || decryptedSecret.isEmpty()) {
            return "redirect:/register";
        }

        String issuer = "CampusLife";
        String label = issuer + ":" + user.getUsername();

        String encodedIssuer = urlEncode(issuer);
        String encodedLabel = urlEncode(label);

        String otpAuthUrl = "otpauth://totp/"
                + encodedLabel
                + "?secret=" + decryptedSecret
                + "&issuer=" + encodedIssuer
                + "&digits=6"
                + "&period=30";

        String qrBase64 = toBase64Png(otpAuthUrl, 240);

        model.addAttribute("username", user.getUsername());
        model.addAttribute("qrBase64", qrBase64);
        model.addAttribute("manualSecret", decryptedSecret);

        return "2fa-setup";
    }

    private String toBase64Png(String text, int size) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "PNG", pngOutputStream);

            byte[] pngData = pngOutputStream.toByteArray();
            return Base64.getEncoder().encodeToString(pngData);
        } catch (WriterException | IOException e) {
            throw new RuntimeException("Error generating QR code", e);
        }
    }

    private String urlEncode(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8).replace("+", "%20");
    }

    @Autowired
    private TwoFactorAuthService twoFactorAuthService;

    @GetMapping("/2fa/check")
    public String show2faPage() {
        return "2fa-check";
    }

    @PostMapping("/2fa/verify")
    public String verify2fa(@RequestParam String username,
            @RequestParam int code,
            HttpSession session) {
        boolean valid = twoFactorAuthService.verifyCode(username, code);

        if (valid) {
            session.setAttribute("2fa_verified", true);
            return "redirect:/Game/HomePage";
        } else {
            return "redirect:/2fa/check?error";
        }
    }
}
