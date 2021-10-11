package sg.edu.iss.telemedicine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;




@Service
public class EmailServiceImpl implements EmailService
{

	private JavaMailSender javaMailSender;


	@Autowired
	PatientService pservice;
	
	@Autowired
	DoctorService dservice;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(Appointment apt) throws MailException
	{

		Patient p=pservice.findPatientById(apt.getPatient().getPatientId());
		Doctor d= dservice.findDoctorById(apt.getDoctor().getDoctorId());
		

		SimpleMailMessage mail = new SimpleMailMessage();
		//mail.setTo(p.getEmail());
		mail.setTo("anishasinha10@gmail.com");
		mail.setSubject("Booking Confirmation");
		mail.setText("You have successfully booked your appointment with Dr. "+ d.getFirstName() +
				      " on " + apt.getAppointmentDate() + " at " + apt.getAppointmentTime() +".");

		
		javaMailSender.send(mail);
	}

	
}
