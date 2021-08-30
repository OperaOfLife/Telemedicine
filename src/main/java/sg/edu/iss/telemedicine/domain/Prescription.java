package sg.edu.iss.telemedicine.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prescription 
{
	@Id 
	 @GeneratedValue(strategy = GenerationType.AUTO) 
	 private int id; 
	 private String medicine; 
	 private String remarks; 
	 private String problem; 
	 
	 @JsonIgnore
	 @OneToOne 
	 private Appointment appoint;
	 
	 
	 
	 
	 
	public Prescription() {
		super();
	}
	public Prescription(String medicine, String remarks, String problem, Appointment appoint) {
		super();
		this.medicine = medicine;
		this.remarks = remarks;
		this.problem = problem;
		this.appoint = appoint;
	}
	public Prescription(int id, String medicine, String remarks, String problem, Appointment appoint) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.remarks = remarks;
		this.problem = problem;
		this.appoint = appoint;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Appointment getAppoint() {
		return appoint;
	}
	public void setAppoint(Appointment appoint) {
		this.appoint = appoint;
	}
	 
	 
	 
	 
	
}
