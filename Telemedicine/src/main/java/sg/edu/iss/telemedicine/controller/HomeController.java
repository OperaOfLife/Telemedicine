package sg.edu.iss.telemedicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/main")
public class HomeController 
{
	
	
	
	@GetMapping("/home")
	public String showHome(Model model)
	{
		return "home";
	}
	
	
	@GetMapping("/patient")
	public String showAdmin(Model model)
	{
		return "home-patient";
	}
	
	
	@GetMapping("/doctor")
	public String showStudent(Model model)
	{
		return "home-doctor";
	}
	
	
		
}


