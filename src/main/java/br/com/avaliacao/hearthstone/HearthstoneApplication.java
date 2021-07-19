package br.com.avaliacao.hearthstone;

import br.com.avaliacao.hearthstone.carta.CartaEntity;
import br.com.avaliacao.hearthstone.carta.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HearthstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(HearthstoneApplication.class, args);
    }

}
