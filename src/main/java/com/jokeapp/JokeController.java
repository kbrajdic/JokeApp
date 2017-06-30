package com.jokeapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JokeController {

	@Autowired
	private JokeService jokeService;
	
    @GetMapping("/new")
    public String newJoke(Model model){
    	JokeForm jokeForm = new JokeForm();
    	model.addAttribute("jokeForm", jokeForm);
        return "new";
    }
    
	@PostMapping(value="/new")
	public String saveJoke(@ModelAttribute JokeForm jokeForm){
		jokeService.createJoke(jokeForm.content);
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/like/{id}")
	public String likeJoke(@PathVariable int id){
		jokeService.likeJoke(id);
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/dislike/{id}")
	public String dislikeJoke(@PathVariable int id){
		jokeService.dislikeJoke(id);
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String getAllJokes(Model model){
		List<Joke> jokes = jokeService.getAllJokes();
		model.addAttribute("jokes", jokes);
		return "jokes";
	}
	
}