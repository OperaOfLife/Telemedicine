package sg.edu.iss.telemedicine.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.repo.AppointmentRepository;
import sg.edu.iss.telemedicine.repo.MedicalCertificateRepository;
import sg.edu.iss.telemedicine.repo.PatientRepository;
import sg.edu.iss.telemedicine.repo.PrescriptionRepository;

@Service
public class PatientServiceImpl implements PatientService
{

	
	//gen
	
	@Autowired
	PatientRepository prepo;
	
	
	  
	 @Autowired 
	 PrescriptionRepository prerepo; 
	  
	 @Autowired 
	 AppointmentRepository aptrepo; 
	  
	 @Autowired 
	 MedicalCertificateRepository mcrepo; 
	
	
			
			
	
	@Override
	public ResponseEntity<Patient> findPatientbyAppointment(String doctorId, Date date)
	{
		Patient pat = prepo.findPatientBydoctorIdAndDate(doctorId, date);
		return new ResponseEntity<Patient>(pat, null, HttpStatus.OK);
	}

	
	@Override
	public void savePatient(Patient patient) {
		prepo.save(patient);
		
	}

	public Patient findPatientById(String id) {
		  return prepo.getById(id);
		 }

	@Override
	public List<Patient> listAllPatients() {
		
		return (List<Patient>)prepo.findAll();
		
	}
	
	//gen
	
	//kat
	


 
//kat hardcode patientId 
@Transactional 
public ArrayList<Appointment> findConsultationHistoryByPatientId(String id) { 
  
 return (ArrayList<Appointment>)aptrepo.findConsultationHistoryByPatientId("1"); 
}

//kat hardcode prescriptionId 
@Override 
public Prescription findPrescriptionById(int prescriptionId) { 
 Prescription p = prerepo.findPrescriptionById(123456); 
 return p; 
}

//kat hardcode mcId 
@Override 
public MedicalCertificate findMedicalCertificateById(String mcId) { 
 MedicalCertificate mc = mcrepo.findMedicalCertificateById("MC001"); 
 return mc; 
}
	//kat


}
