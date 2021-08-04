package sg.edu.iss.telemedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.User;



@Controller
@RequestMapping("/register")
public class RegisterController
{
	

		@RequestMapping(path = "/save")
		public String login(Model model) {
			User u = new User();
			//model.addAttribute("user", u);
			return "login";
		}
		
		@RequestMapping(path = "/authenticate")
		public String authenticate(@ModelAttribute("user") User user, Model model) 
		{
			/*
			 * if(lservice.authenticate(user)) { User u =
			 * lservice.findByName(user.getUsername()); session.setAttribute("usession", u);
			 * return "register"; } else return "login";
			 */
			return null;
		}
		
	
	
}
