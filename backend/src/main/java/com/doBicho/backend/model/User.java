package com.doBicho.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime; // Importante adicionar este import

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private BigDecimal balance = new BigDecimal("1000.00");

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    // NOVO CAMPO: Resolve o erro "Field 'created_at' doesn't have a default value"
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // MÉTODO AUTOMÁTICO: Preenche a data antes de salvar no banco
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public enum UserRole {
        USER, ADMIN
    }
}