package com.doBicho.backend.controller;

import com.doBicho.backend.model.Draw;
import com.doBicho.backend.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // <-- ESSENCIAL
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private DrawService drawService;

    @PostMapping("/draw") // <-- PRECISA SER POST
    public ResponseEntity<Draw> realizarSorteioManual() {
        System.out.println(">>>> ROTA DE SORTEIO ACESSADA COM SUCESSO! <<<<");
        Draw novoSorteio = drawService.realizarSorteio("MANUAL_ADMIN");
        return ResponseEntity.ok(novoSorteio);
    }
}