package sg.edu.iss.telemedicine.service;

import java.util.List;

import sg.edu.iss.telemedicine.domain.Patient;

public interface PatientService {
	public void savePatient(Patient patient);

	public List<Patient> listAllPatients();
}
