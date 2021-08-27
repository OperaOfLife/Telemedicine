package sg.edu.iss.telemedicine.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Clinic;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;
import sg.edu.iss.telemedicine.domain.TimeSlots;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.repo.AppointmentRepository;
import sg.edu.iss.telemedicine.repo.ClinicRepository;
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
	ClinicRepository clrepo;
	
	
	  
	 @Autowired 
	 PrescriptionRepository prerepo; 
	  
	 @Autowired 
	 AppointmentRepository aptrepo; 
	  
	 @Autowired 
	 MedicalCertificateRepository mcrepo; 
	
	//Anisha
			
			
	 @Override
	 public List<TimeSlots> findSlotsbyAppointment(String doctorId, LocalDate date) 
	 {
	 	
		 return aptrepo.findSlotsbyAppointment(doctorId, date);
	 
	 }
	
	 
	 
	 
	 @Override
	 public ResponseEntity<List<Integer>> findPatientbyAppointmentRest(String doctorId, LocalDate date)
	 {
		 List<Integer> pat = aptrepo.findPatientBydoctorIdANDDateRest(doctorId,date);
			
			return new ResponseEntity<List<Integer>>(pat, null, HttpStatus.OK);
	}
	 
	 
	@Override
	public List<Appointment> findPatientbyAppointment(String doctorId,LocalDate date,TimeSlots time)
	{
		
		return aptrepo.findPatientBydoctorIdANDDateTime(doctorId,date,time);
		
		
	}
	
	
	@Override
	public int totalPatients() {
		
		return prepo.findAllPatients();
	}

	//Anisha
	
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
	
	
	//gen searchbar for retrieve med hist
	  @Transactional  
	  public List<Patient> listAll(String keyword){ 
	    if (keyword != null) { 
	     return prepo.search(keyword); 
	    } 
	    return prepo.findAll(); 
	   }
	  @Override
	  public List<Appointment> findPatientbyAppointmentRest1(String doctorId,LocalDate date)
	  {
	   
	   return aptrepo.findPatientBydoctorIdANDDate(doctorId,date);
	   
	   
	  }
	
	//kat
	
	//KAT (23/8/2021) - Display clinics by zone  
	  @Override 
	  public ArrayList<Clinic> findClinicsByZone(String zone) { 
	   ArrayList<Clinic> clist = clrepo.findByZone(zone); 
	   return clist; 
	  } 
	//KAT (26/8/2021) - Display searched clinics 
	  @Override 
	  public ArrayList<Clinic> findSearchedClinics(String searchValue) { 
	   ArrayList<Clinic> clist = clrepo.findSearchedClinics(searchValue); 
	   return clist; 
	  }
	  
	  //KAT (25/8/2021) - Display all clinics 
	  @Override 
	  public ArrayList<Clinic> findAllClinics() { 
	   ArrayList<Clinic> clist = clrepo.findAllClinicsWithOrder(); 
	   return clist; 
	  }

 
//kat hardcode patientId 
@Transactional 
public ArrayList<Appointment> findConsultationHistoryByPatientId(String id) { 
  
 return (ArrayList<Appointment>)aptrepo.findConsultationHistoryByPatientId(id); 
}

//kat hardcode prescriptionId 
@Override 
public Prescription findPrescriptionById(int prescriptionId) { 
 Prescription p = prerepo.findPrescriptionById(prescriptionId); 
 return p; 
}

//kat hardcode mcId 
@Override 
public MedicalCertificate findMedicalCertificateById(String mcId) { 
 MedicalCertificate mc = mcrepo.findMedicalCertificateById(mcId); 
 return mc; 
}
	//kat

//KAT (11/8/2021) - Display patient by patientId 
@Override 
public Optional<Patient> findPatientByPatientId(String patientId) { 
Optional<Patient> patient = prepo.findById(patientId); 
return patient; 
}






}
