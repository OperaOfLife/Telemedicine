package sg.edu.iss.telemedicine.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MedicalCertificate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate dateTo;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate dateFrom;
	
	@JsonIgnore
	@OneToOne
	private Appointment appointMC;
	
	
	
	public MedicalCertificate(LocalDate dateTo, LocalDate dateFrom) {
		super();
		this.dateTo = dateTo;
		this.dateFrom = dateFrom;
		
	}
	public MedicalCertificate(LocalDate dateTo, LocalDate dateFrom,  Appointment appointMC) {
		super();
		this.dateTo = dateTo;
		this.dateFrom = dateFrom;
		
		this.appointMC = appointMC;
	}
	public MedicalCertificate() {
		super();
	}
	public MedicalCertificate(int id, LocalDate dateTo, LocalDate dateFrom,  Appointment appointMC) {
		super();
		this.id = id;
		this.dateTo = dateTo;
		this.dateFrom = dateFrom;
		
		this.appointMC = appointMC;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateTo() {
		return dateTo;
	}
	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}
	public LocalDate getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public Appointment getAppointMC() {
		return appointMC;
	}
	public void setAppointMC(Appointment appointMC) {
		this.appointMC = appointMC;
	}
	
	
	
}
