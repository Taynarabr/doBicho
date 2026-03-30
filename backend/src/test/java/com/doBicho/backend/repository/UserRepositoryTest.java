package com.doBicho.backend.repository; 

import com.doBicho.backend.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles; // <-- Adicione este import
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // <-- Garante que o Spring configure o JPA para o teste
@ActiveProfiles("test") // <-- Diz para usar o H2 (memória) no GitHub
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void deveCriarUsuarioComSaldoInicialCorreto() {
        User user = new User();
        user.setName("Taynara");
        user.setEmail("taynara@teste.com");
        user.setPassword("123456");

        User salvo = userRepository.save(user);

        // RF03 - Valida saldo inicial de 1000.00
        assertThat(salvo.getId()).isNotNull();
        assertThat(salvo.getBalance()).isEqualByComparingTo(new BigDecimal("1000.00"));
    }
}