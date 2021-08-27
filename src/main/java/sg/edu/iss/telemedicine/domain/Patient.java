package sg.edu.iss.telemedicine.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy="patient") private List<Appointment> appointment;
	 */
	
	
	
	public Patient() {
		super();
	}




	public Patient(String patientId, String firstName, String lastName, String gender, String mobile, String email) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
	}




	/*
	 * public Patient(String patientId, String firstName, String lastName, String
	 * gender, String mobile, String email, List<Appointment> appointment) {
	 * super(); this.patientId = patientId; this.firstName = firstName;
	 * this.lastName = lastName; this.gender = gender; this.mobile = mobile;
	 * this.email = email; //this.appointment = appointment; }
	 */




	public String getPatientId() {
		return patientId;
	}




	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}



	/*
	 * public List<Appointment> getAppointment() { return appointment; }
	 * 
	 * 
	 * 
	 * 
	 * public void setAppointment(List<Appointment> appointment) { this.appointment
	 * = appointment; }
	 */
	
}
