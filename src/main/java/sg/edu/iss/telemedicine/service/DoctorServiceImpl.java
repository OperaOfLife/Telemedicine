package sg.edu.iss.telemedicine.service;
import java.time.LocalDate;
import java.util.ArrayList; 
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.repo.DoctorRepository;
import sg.edu.iss.telemedicine.repo.MedicalCertificateRepository;

import java.util.List;
 
import sg.edu.iss.telemedicine.domain.Appointment; 
import sg.edu.iss.telemedicine.domain.Patient; 
import sg.edu.iss.telemedicine.domain.Prescription; 
import sg.edu.iss.telemedicine.repo.AppointmentRepository; 
import sg.edu.iss.telemedicine.repo.PatientRepository; 
import sg.edu.iss.telemedicine.repo.PrescriptionRepository; 
 
@Service 
public class DoctorServiceImpl implements DoctorService 
{ 
 
  
 @Autowired 
 AppointmentRepository arepo; 
 
 @Autowired
 DoctorRepository doctorRepository;
 
 @Autowired
 MedicalCertificateRepository mrepo;
 
 @Autowired
 PrescriptionRepository presrepo;
 
 
 
 //Anisha
 
 @Override
	public List<Integer> getAppointmentsTodayById(LocalDate currentDate, String currentusername)
 {
		return arepo.findAllByIdAndDate(currentusername,  currentDate);
	}

 @Override
	public List<Patient> getPatientsTodayById(LocalDate currentDate, String currentusername)
 {

	 return arepo.findPatientsTodayByIdAndDate(currentDate,currentusername);
	 
	}

 
 @Override
	public int myPatients(String currentusername) {
		// TODO Auto-generated method stub
		return arepo.myPatients(currentusername);
	}

 @Override
	public int totalPresByApptId(List<Integer> appt) 
 {
	 int total=0;
	 List<Prescription> pres=new ArrayList<>();
 	 for (Integer a : appt) 
	 {
 		 if(presrepo.findAllByApptId(a) != null)
 			 	total=total+1;
	 }
	 
	 return total;
	 
	}

 
 @Override
	public int getNumAppointmentsTodayById(LocalDate currentDate, String currentusername) {
		// TODO Auto-generated method stub
	 return arepo.findAppointbyDateAndId(currentDate,currentusername);
	}
 
//kat 
 public ArrayList<Appointment> findAllAppointmentsByDoctorId(String doctorid,LocalDate date) { 
  return arepo.findAllAppointmentsByDoctorId(doctorid,date);  
 } 

//kat 
@Override 
public void deleteBookingByAppointmentId(int id) { 
Appointment a = arepo.findBookingByAppointmentId(id); 
  arepo.delete(a); 
}
 
 
 
  
 //genesis
 
 @Transactional  
 public List<Appointment> listAll(String keyword){ 
   if (keyword != null) { 
    return arepo.search(keyword); 
   } 
   return arepo.findAll(); 
  }
 

 public void saveMc(MedicalCertificate mc) {
  mrepo.save(mc);
 }
 
 
 
 //genesis
 
  
 @Autowired 
 PrescriptionRepository psrepo; 
 //get distinct appointments from DoctorId 
  
 public ArrayList<Appointment> findAppointmentByDoctorId(String doctorid) { 
  return arepo.findAppointmentsByDoctorID(doctorid); 
 } 
  
 //get list of appointments pertaining to patient ID 
 public ArrayList<Appointment> findAppointmentsByPatientId(String patientid){ 
  return arepo.findAppointmentsByPatientID(patientid); 
 } 
  
//find all doctors
public ArrayList<Doctor> getAllDoctors(){
 return (ArrayList<Doctor>) doctorRepository.findAll();
}

//find doctor
public Doctor getDoctorById(String id) {
return doctorRepository.getById(id);
}
  
 public void savePrescription(Prescription pre) { 
  psrepo.save(pre); 
 } 
 //get appointment 
 public Optional<Appointment> getAppointmentById(int id) { 
  return arepo.findById(id); 
 } 


    

    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }



    @Override
    public List<Doctor> doctorSearch(String keyword) {
        return doctorRepository.doctorSearch(keyword);
    }

	/*
	 * @Override public Page<Doctor> doctorSearchPage(String keyword, int pageNo,
	 * int pageSize, String sortField, String sortDirection) { return null; }
	 */


	@Override
	public void saveAppointment(Appointment appointment) {
		arepo.save(appointment);
		
	}



	
//ZY
	
	
	
	@Override
	public Page<Doctor> doctorSearchPage(String keyword, int pageNo, int pageSize) {

	 Pageable pageable = PageRequest.of(pageNo-1,pageSize);
	    if (keyword == null) {
	        return doctorRepository.findAll(pageable);
	    }
	    else
	        return doctorRepository.doctorSearchWithPage(keyword,pageable);
	}

	@Override
	public void save(Doctor doctor) {
		doctorRepository.save(doctor);
		
	}

	
	
	

	
}
// refs/remotes/origin/Zhang_Yi
