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
public class Prescription 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String medicine;
	private String remarks;
	@OneToOne(mappedBy="prescription")
	private Appointment appoint;
	
}
