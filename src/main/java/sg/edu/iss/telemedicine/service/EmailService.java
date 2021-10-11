package sg.edu.iss.telemedicine.service;

import sg.edu.iss.telemedicine.domain.Appointment;


public interface EmailService 
{
	
	
	public void sendEmail(Appointment appointment);

}
