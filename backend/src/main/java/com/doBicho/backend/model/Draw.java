package com.doBicho.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "draws")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Draw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sincronizado com o seu 'draw_date' no MySQL
    @Column(name = "draw_date", nullable = false)
    private LocalDateTime drawDate = LocalDateTime.now();

    // Sincronizado com suas colunas 'milhar_1' até 'milhar_5'
    @Column(name = "milhar_1", length = 4, nullable = false)
    private String milhar1;

    @Column(name = "milhar_2", length = 4, nullable = false)
    private String milhar2;

    @Column(name = "milhar_3", length = 4, nullable = false)
    private String milhar3;

    @Column(name = "milhar_4", length = 4, nullable = false)
    private String milhar4;

    @Column(name = "milhar_5", length = 4, nullable = false)
    private String milhar5;

    // O campo 'type' não estava no seu describe, o Hibernate vai criá-lo automaticamente
    private String type;
}