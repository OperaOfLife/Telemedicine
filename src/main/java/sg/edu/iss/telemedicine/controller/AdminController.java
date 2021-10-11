package sg.edu.iss.telemedicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.iss.telemedicine.domain.Seminar;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	
	
	@Autowired
	AdminService aService;
	
	@GetMapping("/addSeminar")
	public String addSeminar(@ModelAttribute("seminar") Seminar semi, Model model )
	{
		aService.saveSeminar(semi);
		return "admin-seminar";
	}
	
	
	@GetMapping("/seminar")
	public String seminar( Model model )
	{
		model.addAttribute("seminar",new Seminar());
		return "admin-seminar";
	}
	
	
	
	
	
}
