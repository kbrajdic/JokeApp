package com.jokeapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeService {
	
	@Autowired
	private JokeRepository jokeRepository;
	
	public List<Joke> getAllJokes(){
		List<Joke> jokes = new ArrayList<>();
		jokeRepository.findAll().forEach(jokes::add);
		jokes.sort((joke1,joke2) -> -((joke1.likes - joke1.dislikes) - (joke2.likes - joke2.dislikes)));
		return jokes;
	}

	public void createJoke(String content) {
		Joke joke = new Joke(content);
		jokeRepository.save(joke);
	}

	public void likeJoke(int id) {
		Joke joke = jokeRepository.findOne(id);
		joke.likes += 1;
		jokeRepository.save(joke);
	}
	
	public void dislikeJoke(int id) {
		Joke joke = jokeRepository.findOne(id);
		joke.dislikes += 1;
		jokeRepository.save(joke);
	}
			
}
