package com.doBicho.backend.repository;

import com.doBicho.backend.model.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Long> {
    // Aqui poderemos buscar o último sorteio realizado futuramente
}