package com.doBicho.backend.controller;

import com.doBicho.backend.dto.LoginRequest; // Certifique-se que este DTO existe
import com.doBicho.backend.model.User;
import com.doBicho.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> registrar(@RequestBody User user) {
        User novoUsuario = authService.cadastrarUsuario(user);
        return ResponseEntity.ok(novoUsuario);
    }

    // --- ADICIONE ESTE MÉTODO ABAIXO ---
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            User user = authService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            // Se a senha estiver errada ou e-mail não existir, retorna 401
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}