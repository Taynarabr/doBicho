package com.doBicho.backend.service;

import com.doBicho.backend.model.User;
import com.doBicho.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User cadastrarUsuario(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        user.setBalance(new BigDecimal("1000.00"));
        
        if (user.getRole() == null) {
            user.setRole(User.UserRole.USER);
        }

        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        // O passwordEncoder já deve estar injetado no seu AuthService
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Senha incorreta!");
        }
    }
}