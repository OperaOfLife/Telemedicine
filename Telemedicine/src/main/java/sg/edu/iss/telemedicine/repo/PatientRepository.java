package sg.edu.iss.telemedicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.telemedicine.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
