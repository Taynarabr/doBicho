package com.doBicho.backend.controller;

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
}