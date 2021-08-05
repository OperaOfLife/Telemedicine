package sg.edu.iss.telemedicine.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Appointment;


@Controller
@RequestMapping("/appointment")
public class PatientAppointmentController 
{
	

	@RequestMapping("/bookform")
	public String add(Model model)
	{
		model.addAttribute("appointment",new Appointment());
		return "patient-book-consultation";
	}
	
	@RequestMapping("/book")
	public String book(@ModelAttribute("appointment") Appointment appointment,Model model)
	{
		Date dt=appointment.getAppointmentDate();
		Date time=appointment.getAppointmentTime();
		
		return "patient-book-consultation";
	}
}
