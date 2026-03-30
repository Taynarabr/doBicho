package com.doBicho.backend.service;

import com.doBicho.backend.model.Draw;
import com.doBicho.backend.repository.DrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class DrawService {

    @Autowired
    private DrawRepository drawRepository;

    // RF07 - Lógica para gerar os 5 prêmios individuais
    public Draw realizarSorteio(String tipo) {
        Random random = new Random();
        Draw novoSorteio = new Draw();

        // Gera cada milhar individualmente para salvar nas colunas do banco
        novoSorteio.setMilhar1(String.format("%04d", random.nextInt(10000)));
        novoSorteio.setMilhar2(String.format("%04d", random.nextInt(10000)));
        novoSorteio.setMilhar3(String.format("%04d", random.nextInt(10000)));
        novoSorteio.setMilhar4(String.format("%04d", random.nextInt(10000)));
        novoSorteio.setMilhar5(String.format("%04d", random.nextInt(10000)));

        novoSorteio.setType(tipo);
        novoSorteio.setDrawDate(LocalDateTime.now());

        System.out.println("--- NOVO SORTEIO REALIZADO: " + tipo + " ---");
        return drawRepository.save(novoSorteio);
    }

    // Sorteio automático (Exemplo: 14h)
    @Scheduled(cron = "0 0 14 * * *") 
    public void sorteioAutomaticoDiario() {
        realizarSorteio("PT-14H");
    }
}