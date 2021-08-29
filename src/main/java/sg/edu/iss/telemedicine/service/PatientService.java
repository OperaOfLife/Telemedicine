package sg.edu.iss.telemedicine.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Clinic;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;
import sg.edu.iss.telemedicine.domain.TimeSlots;

public interface PatientService {
	
	//gen
	public void savePatient(Patient patient);

	public List<Patient> listAllPatients();
	public Patient findPatientById(String id);
	//gen
	public List<Appointment> findPatientbyAppointmentRest1(String doctorid, LocalDate date);
	
	//kat
	 public ArrayList<Appointment> findConsultationHistoryByPatientId(String id); 
	 
	 public Prescription findPrescriptionById(int prescriptionId); 
	 
	 public MedicalCertificate findMedicalCertificateById(int mcId);
	 
	 public Optional<Patient> findPatientByPatientId(String patientId);
		
	//kat

	//Anisha
	 public List<Appointment> findPatientbyAppointment(String doctorId,LocalDate date,TimeSlots time);

	 public ResponseEntity<List<Integer>>findPatientbyAppointmentRest(String doctorId,LocalDate date);

	public List<TimeSlots> findSlotsbyAppointment(String doctorId, LocalDate date);

	public List<Patient> listAll(String keyword);

	public int totalPatients();

	public ArrayList<Clinic> findAllClinics();

	public ArrayList<Clinic> findClinicsByZone(String zone);

	public ArrayList<Clinic> findSearchedClinics(String searchValue);

	public boolean validateAppointment(TimeSlots appointmentTime, Doctor doctor, LocalDate datedate);

	
	//Anisha
}
