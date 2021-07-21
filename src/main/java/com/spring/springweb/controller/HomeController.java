package com.spring.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.spring.springweb.dao.AlienRepo;
import com.spring.springweb.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Ram");
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Welcome home");
		return "index";
	}
	
//	@RequestMapping("/add")
//	public String add(HttpServletRequest req) {
//		System.out.println("Add a and b");
//		int a = Integer.parseInt(req.getParameter("num1"));
//		int b = Integer.parseInt(req.getParameter("num2"));
//		
//		int num3 = a+b;
//		
//		HttpSession session = req.getSession();
//		
//		session.setAttribute("num3", num3);
//		return "index.jsp";
//	}
	
//	public String add(@RequestParam("num1") int a, @RequestParam("num2") int b, HttpSession session) {
//		System.out.println("Add a and b with HttpSession");
//				
//		//int num3 = a+b;
//				
//		session.setAttribute("num3", a+b);
//		
//		return "index.jsp";
//	}
	
//	public ModelAndView add(@RequestParam("num1") int a, @RequestParam("num2") int b) {
//		System.out.println("Add a and b with ModelAndView");
//		
//		ModelAndView mv = new ModelAndView();					
//		mv.setViewName("index");
//				
//		mv.addObject("num3", a+b);
//		
//		return mv;			
//	}
	
//	public String add(@RequestParam("num1") int a, @RequestParam("num2") int b, Model m) {
//		System.out.println("Add a and b with Model");								
//						
//		m.addAttribute("num3", a+b);
//		
//		return "index";			
//	}
//
//
	
	@RequestMapping("/addAlien")
	public String add(@ModelAttribute("alien") Alien alien, Model m) {
		System.out.println("in add()......");								
						
		m.addAttribute("alien", alien);
		repo.save(alien);
	
		
		return "index";			
	}
	
//	@RequestMapping("/updateAlien")
//	public String update(@ModelAttribute("alien") Alien alien, Model m) {
//		System.out.println("in update().............");								
//						
//		m.addAttribute("alien", alien);
//		repo.save(alien);
//	
//		
//		return "index";			
//	}
	
	@RequestMapping("/deleteAlien")
	public String delete(int aid, Model m) {
		System.out.println("in delete().....");	
		
		m.addAttribute("alien", repo.getOne(aid));
						
		//m.addAttribute("alien", alien);
		repo.deleteById(aid);
	
		
		return "index";			
	}
	
	@GetMapping("getAlien")
	public String getAlien(@ModelAttribute("alien") Alien alien, @RequestParam int aid,Model m) {
				
		m.addAttribute("alien", alien);
		m.addAttribute("alien", repo.getOne(aid));
		return "index";		
	}
	
	@GetMapping("getAlienbyName")
	public String getAlienbyName(@RequestParam String aname,Model m) {
				
		//m.addAttribute("alien", alien);
		m.addAttribute("alien", repo.findByAname(aname));
		return "index";		
	}
	
	@GetMapping("orderByName")
	public String orderByName(@RequestParam String aname,Model m) {
				
		//m.addAttribute("alien", alien);
		//m.addAttribute("alien", repo.findByAnameOrderByAid(aname));
		m.addAttribute("alien", repo.find(aname));
		return "index";		
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		
		//m.addAttribute("alien", dao.getAliens());
		
		m.addAttribute("alien", repo.findAll());
		return "result";		
	}
	
	

}
