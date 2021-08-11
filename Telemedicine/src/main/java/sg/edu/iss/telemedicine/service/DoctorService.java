package sg.edu.iss.telemedicine.service;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Prescription;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import sg.edu.iss.telemedicine.domain.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> findAllDoctors();
    public List<Doctor> doctorSearch(String keyword);
    public Page<Doctor> doctorSearchPage(String keyword, int pageNo, int pageSize, String sortField,
                                       String sortDirection);
	public Optional<Appointment> getAppointmentById(int id);

// refs/remotes/origin/Zhang_Yi

	public ArrayList<Appointment> findAppointmentByDoctorId(String doctorid);
	 
	 public ArrayList<Appointment> findAppointmentsByPatientId(String patientid);
	 
	 public void savePrescription(Prescription pre);
	 
	 //Gen
	 public ArrayList<Doctor> getAllDoctors();
	public Doctor getDoctorById(String id);
	
	}