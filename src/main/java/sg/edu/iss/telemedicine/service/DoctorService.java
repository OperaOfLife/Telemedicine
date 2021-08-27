package sg.edu.iss.telemedicine.service;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Prescription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;

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
	public List<Appointment> listAll(String keyword);
	public void saveMc(MedicalCertificate mc);
	public void saveAppointment(Appointment appointment);
	public void deleteBookingByAppointmentId(int id);
	public ArrayList<Appointment> findAllAppointmentsByDoctorId(String currentusername);
	public int getNumAppointmentsTodayById(LocalDate currentDate, String currentusername);
	
	public int myPatients(String currentusername);
	public List<Integer> getAppointmentsTodayById(LocalDate currentDate, String currentusername);
	public int totalPresByApptId(List<Integer> appt);
	public List<Patient> getPatientsTodayById(LocalDate currentDate, String currentusername);
	
	
	
	}