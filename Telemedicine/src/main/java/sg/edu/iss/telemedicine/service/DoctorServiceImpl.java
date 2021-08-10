package sg.edu.iss.telemedicine.service;
import java.util.ArrayList; 
import java.util.Optional; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 


import org.springframework.data.domain.Page;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.repo.DoctorRepository;

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
 PrescriptionRepository psrepo; 
 //get distinct appointments from DoctorId 
  
 public ArrayList<Appointment> findAppointmentByDoctorId(String doctorid) { 
  return arepo.findAppointmentsByDoctorID(doctorid); 
 } 
  
 //get list of appointments pertaining to patient ID 
 public ArrayList<Appointment> findAppointmentsByPatientId(String patientid){ 
  return arepo.findAppointmentsByPatientID(patientid); 
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

    @Override
    public Page<Doctor> doctorSearchPage(String keyword, int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }
}
// refs/remotes/origin/Zhang_Yi
