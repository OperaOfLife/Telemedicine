package sg.edu.iss.telemedicine.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient 
{
	@Id
	private String patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobile;
	private String email;
	@OneToMany(mappedBy="patient")
	private List<Appointment> appointment;
}
