package com.squad53.elatrampav4;

import java.util.stream.LongStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.squad53.elatrampav4.Candidato;
import com.squad53.elatrampav4.CandidatoRepository;

@SpringBootApplication
public class Elatrampav4Application {

	public static void main(String[] args) {
		SpringApplication.run(Elatrampav4Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(CandidatoRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
						.mapToObj(i -> {
							Candidato c = new Candidato();
							c.setNome("Candidato " + i);
							c.setCpf("12345678911");
							c.setEmail("Contact" +i+"@gmail.com");
							c.setTelefone("(21)98765-4569");
							return c;
						})
						.map(v -> repository.save(v))
						.forEach(System.out::println);
		};
	}

}
