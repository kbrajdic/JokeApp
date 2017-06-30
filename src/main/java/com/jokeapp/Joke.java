package com.jokeapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joke {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String content;
	public int likes;
	public int dislikes;
	
	public Joke(String content){
		this.content = content;
		this.likes = 0;
		this.dislikes= 0;
	}
	
	public Joke(){
		super();
	}
	
}
