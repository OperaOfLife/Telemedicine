package sg.edu.iss.telemedicine.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.telemedicine.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>
{
	
		/*
		 * @Query("SELECT a.patient FROM Appointment a  WHERE a.doctor.doctorId LIKE :doctorId"
		 * ) Patient findPatientBydoctorId(@Param("doctorId") String doctorId);
		 */
}
