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

import sg.edu.iss.telemedicine.domain.Seminar;
import sg.edu.iss.telemedicine.service.AdminService;



@Controller
@RequestMapping
public class HomeController 
{
	
	@Autowired
	AdminService aService;
	
	@GetMapping("/")
	public String showHome(Model model)
	{
       Seminar s=aService.findSeminars();
		
		String seminarName=s.getName();
		String seminarLink=s.getLink();
		
		model.addAttribute("name",seminarName);
		model.addAttribute("link", seminarLink);
		return "home";
	}
	
	
	
	@GetMapping("/main/home")
	public String showHome1(Model model)
	{
		Seminar s=aService.findSeminars();
		
		String seminarName=s.getName();
		String seminarLink=s.getLink();
		
		model.addAttribute("name",seminarName);
		model.addAttribute("link", seminarLink);
		return "home";
	}
	
	
	@GetMapping("/main/patient")
	public String showAdmin(Model model)
	{
		return "home-patient";
	}
	
	
	@GetMapping("/main/doctor")
	public String showStudent(Model model)
	{
		return "home-doctor";
	}
	
	@GetMapping("/main/about")
	public String showAbout(Model model)
	{
		return "about-us";
	}
	
	
		
}


