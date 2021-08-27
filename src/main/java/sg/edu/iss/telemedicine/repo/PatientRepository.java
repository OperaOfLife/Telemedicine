package sg.edu.iss.telemedicine.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.telemedicine.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>
{
	
	//gen
	
	 @Query("SELECT p FROM Patient p WHERE CONCAT(p.firstName, ' ', p.patientId) "
			    + "LIKE %?1%")
			  public List<Patient> search(String keyword);
	
		/*
		 * @Query("SELECT a.patient FROM Appointment a  WHERE a.doctor.doctorId LIKE :doctorId"
		 * ) Patient findPatientBydoctorId(@Param("doctorId") String doctorId);
		 */
	
	//KAT (11/8/2021) - Display patient by patientId 
	 @Query("SELECT p FROM Patient p WHERE p.id LIKE :id") 
	 public Optional<Patient> findPatientByPatientId(@Param("id") String id);
	 
	 //Ani
	 @Query("SELECT count(p) FROM Patient p") 
	 public int findAllPatients();
}
