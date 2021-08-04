package sg.edu.iss.telemedicine.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class MedicalCertificate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate dateTo;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate dateFrom;
	private int duration;
	@OneToOne(mappedBy="mc")
	private Appointment appointMC;
	
}
