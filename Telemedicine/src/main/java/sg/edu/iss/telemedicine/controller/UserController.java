package sg.edu.iss.telemedicine.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Role;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.service.UserService;


@Controller
@RequestMapping("/login")
public class UserController 
{
	@Autowired
	UserService uservice;
	
	String errmsg="";
	String msg="NO SUCH EMAIL ID EXISTS.";
	String msg1="USER ALREADY EXISTS.";
	
	
	 
	 
	
	@Autowired
	public void setUserInterface(UserService us) {
		this.uservice = us;
	}
	
	@RequestMapping(path = "/home")
	public String login(Model model) 
	{
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}
	
	@RequestMapping(path = "/register")
	public String register(Model model) 
	{
		User u = new User();
		model.addAttribute("newuser", u);
		
		return "register";
	}
	
	
	
	
	
	@RequestMapping(path = "/exit")
	public String logout(@ModelAttribute("user") User user, Model model, HttpSession session) 
	{
		session.setAttribute("usession", null);
		return "home";
	}
	
	
	
	/*
	 * @RequestMapping(path = "/authenticate") public String
	 * register(@ModelAttribute("user") User user, Model model, HttpSession session)
	 * {
	 * 
	 * UserSession usession = new UserSession(); if(uservice.authenticate(user)) {
	 * User u = uservice.findByName(user.getUsername());
	 * 
	 * usession.setUser(u); session.setAttribute("usession", usession);
	 * 
	 * if(u.getRole().equals(Role.DOCTOR)) return "home-doctor"; else
	 * if(u.getRole().equals(Role.PATIENT)) return "home-patient";
	 * 
	 * else { model.addAttribute("errmsg",msg ); return "register"; }
	 * 
	 * 
	 * } else return "login"; }
	 */
	
}
	
	

