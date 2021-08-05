package sg.edu.iss.telemedicine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sg.edu.iss.telemedicine.service.PatientService;

@Controller
public class PatientConsultationHistoryController
{

	@Autowired
	PatientService pservice;
	
	
	
}
