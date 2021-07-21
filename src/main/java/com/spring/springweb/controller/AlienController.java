package com.spring.springweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springweb.dao.AlienRepo;
import com.spring.springweb.model.Alien;

@RestController
//@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="aliens", produces = {"application/xml", "application/json"})
	//@ResponseBody
	public List<Alien> getAliens() {
		System.out.println("aliens");
		
		List<Alien> aliens = repo.findAll();
		
		return aliens;		
	}
	
	@GetMapping("alien/{id}")
	//@ResponseBody
	public Alien getAlien(@PathVariable("id") int aid) {
		Alien alien = repo.findById(aid).orElse(new Alien(0,"noAlien"));	
		return alien;
	}
	
	@PostMapping(path="alien", consumes = "application/xml")
	public Alien addAlien(@RequestBody Alien alien) {
		
		System.out.println("addAlien");
		repo.save(alien);
		
		return alien;
	}
	
	@PostMapping(path="aliens", consumes = "application/xml")
	public List<Alien> addAliens(@RequestBody List<Alien> aliens) {
		
		System.out.println("addAliens");
		repo.saveAll(aliens);
				
		return aliens;
	}


}
