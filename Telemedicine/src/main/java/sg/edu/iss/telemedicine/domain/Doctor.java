package sg.edu.iss.telemedicine.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor 
{
	@Id
	private String doctorId;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobile;
	private String email;
	@OneToMany(mappedBy="doctor")
	private List<Appointment> appointments;
}
