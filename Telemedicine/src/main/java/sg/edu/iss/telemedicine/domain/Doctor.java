package sg.edu.iss.telemedicine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	private String office;
	private String Introduction;

	@OneToMany(mappedBy="doctor")
	private List<Appointment> appointments;
}
