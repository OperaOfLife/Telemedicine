package sg.edu.iss.telemedicine.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;
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

	
	@Override
	public void savePatient(Patient patient) {
		prepo.save(patient);
		
	}


	@Override
	public List<Patient> listAllPatients() {
		
		return (List<Patient>)prepo.findAll();
		
	}
	
	//gen
	
	//kat
	

@Autowired 
 PatientRepository patrepo; 
  
 @Autowired 
 PrescriptionRepository prerepo; 
  
 @Autowired 
 AppointmentRepository aptrepo; 
  
 @Autowired 
 MedicalCertificateRepository mcrepo; 
 
 @Transactional 
 public ArrayList<Appointment> findConsultationHistoryByPatientId(String id) { 
   
  return (ArrayList<Appointment>)aptrepo.findConsultationHistoryByPatientId(id); 
 } 
 
 @Override 
 public Prescription findPrescriptionById(String prescriptionId) { 
  Prescription p = prerepo.findPrescriptionById(prescriptionId); 
  return p; 
 } 
 
 @Override 
 public MedicalCertificate findMedicalCertificateById(String mcId) { 
  MedicalCertificate mc = mcrepo.findMedicalCertificateById(mcId); 
  return mc; 
 }
	//kat
}
