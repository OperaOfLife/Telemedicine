package sg.edu.iss.telemedicine.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate appointmentDate;	
	@DateTimeFormat(pattern ="HH:mm")
	private LocalDate appointmentTime;
	@ManyToOne
	private Doctor doctor;
	@ManyToOne
	private Patient patient;
	@OneToOne(mappedBy="appoint", cascade = CascadeType.ALL)
	private Prescription prescription;
	@OneToOne(mappedBy="appointMC", cascade = CascadeType.ALL)
	private MedicalCertificate mc;
	
	
	
	
	
	public Appointment() {
		super();
	}





	public Appointment(LocalDate appointmentDate,LocalDate appointmentTime) {
		super();
		this.appointmentDate = appointmentDate;
		this.appointmentTime=appointmentTime;
	}





	public Appointment(int id, LocalDate appointmentDate,LocalDate appointmentTime) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime=appointmentTime;
	}





	public Appointment(int id, LocalDate appointmentDate,LocalDate appointmentTime, Doctor doctor, Patient patient, Prescription prescription,
			MedicalCertificate mc) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.doctor = doctor;
		this.patient = patient;
		this.prescription = prescription;
		this.mc = mc;
	}





	





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}





	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}





	public Doctor getDoctor() {
		return doctor;
	}





	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}





	public Patient getPatient() {
		return patient;
	}





	public void setPatient(Patient patient) {
		this.patient = patient;
	}





	public Prescription getPrescription() {
		return prescription;
	}





	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}





	public MedicalCertificate getMc() {
		return mc;
	}





	public void setMc(MedicalCertificate mc) {
		this.mc = mc;
	}





	public LocalDate getAppointmentTime() {
		return appointmentTime;
	}





	public void setAppointmentTime(LocalDate appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	
	 
}
