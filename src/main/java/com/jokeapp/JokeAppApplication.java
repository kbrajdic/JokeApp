package com.jokeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JokeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokeAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(JokeRepository jokeRepository) {
		return (args) -> {
			// save a couple of jokes
			jokeRepository.save(new Joke("Zašto je Chuck Norris najjači? Zato što vježba dva dana dnevno"));
			jokeRepository.save(new Joke("Pita nastavnica hrvatskog jezika mladog osnovnoškolca: Reci ti meni što su to prilozi? Prilozi su: ketchup, majoneza, luk, salata..."));
			jokeRepository.save(new Joke("Pričaju dvije gimnazijalke: Nema mi roditelja doma ovaj vikend! Bože, pa koja si ti sretnica! Možeš učiti naglas!"));
			jokeRepository.save(new Joke("Došao Mujo u pizzeriju i naručio pizzu. Konobar ga upita: Želite da vam izrežem pizzu na 6 ili 12 komada? Ma na 6 komada, nema šanse da pojedem 12."));
		};
	}
}
