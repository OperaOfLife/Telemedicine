package sg.edu.iss.telemedicine.service;

import java.util.ArrayList;
import java.util.Optional;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Prescription;

public interface DoctorService {
	public ArrayList<Appointment> findAppointmentByDoctorId(String doctorid);
	 
	 public ArrayList<Appointment> findAppointmentsByPatientId(String patientid);
	 
	 public void savePrescription(Prescription pre);
	 public Optional<Appointment> getAppointmentById(int i) ;
	}