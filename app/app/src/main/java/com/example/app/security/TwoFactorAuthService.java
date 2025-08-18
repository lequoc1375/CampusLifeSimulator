package com.example.app.security;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.app.entity.User;
import com.example.app.repository.UserRepo;
import com.warrenstrange.googleauth.GoogleAuthenticator;

@Service
public class TwoFactorAuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    @Qualifier("jasyptStringEncryptor")
    private StringEncryptor stringEncryptor;

    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    public boolean verifyCode(String username, int code) {
        User user = userRepo.findByUsername(username);
        if (user == null) return false;

    
        String decryptedSecret;
        try {
            decryptedSecret = stringEncryptor.decrypt(user.getSecret());
        } catch (Exception ex) {
            return false;
        }

        return gAuth.authorize(decryptedSecret, code);
    }
}
