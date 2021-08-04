package sg.edu.iss.telemedicine.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate appointmentDate;	
	@ManyToOne
	private Doctor doctor;
	@ManyToOne
	private Patient patient;
	 @OneToOne
	 private Prescription prescription;
	  @OneToOne
	  private MedicalCertificate mc;
	 
}
