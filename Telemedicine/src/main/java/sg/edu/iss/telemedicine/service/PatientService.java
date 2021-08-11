package sg.edu.iss.telemedicine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;

public interface PatientService {
	
	//gen
	public void savePatient(Patient patient);

	public List<Patient> listAllPatients();
	public Patient findPatientById(String id);
	//gen
	
	
	//kat
	 public ArrayList<Appointment> findConsultationHistoryByPatientId(String id); 
	 
	 public Prescription findPrescriptionById(int prescriptionId); 
	 
	 public MedicalCertificate findMedicalCertificateById(String mcId);
	//kat

	public ResponseEntity<Patient> findPatientbyAppointment(String doctorId, Date date);
}
