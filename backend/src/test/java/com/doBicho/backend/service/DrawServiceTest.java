package com.doBicho.backend.service;

import com.doBicho.backend.model.Draw;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test") // Garante que o GitHub Actions use o H2
public class DrawServiceTest {

    @Autowired
    private DrawService drawService;

    @Test
    void deveGerarSorteioComCincoPremiosIndividuais() {
        // Executa a lógica de sorteio (RF07)
        Draw resultado = drawService.realizarSorteio("TESTE_UNITARIO");

        // Validações
        assertThat(resultado).isNotNull();
        
        // Verifica se cada campo de milhar foi preenchido corretamente com 4 dígitos
        validarMilhar(resultado.getMilhar1());
        validarMilhar(resultado.getMilhar2());
        validarMilhar(resultado.getMilhar3());
        validarMilhar(resultado.getMilhar4());
        validarMilhar(resultado.getMilhar5());
        
        // Verifica se o tipo foi salvo corretamente
        assertThat(resultado.getType()).isEqualTo("TESTE_UNITARIO");
    }

    // Método auxiliar para não repetir código
    private void validarMilhar(String milhar) {
        assertThat(milhar).isNotNull();
        assertThat(milhar).hasSize(4);
        assertThat(milhar).containsOnlyDigits();
    }
}