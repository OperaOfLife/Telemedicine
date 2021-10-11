package sg.edu.iss.telemedicine.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.telemedicine.domain.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	
	//kat
	


	
	  @Query("SELECT pre FROM Prescription pre JOIN pre.appoint apt JOIN apt.patient WHERE pre.id LIKE :id"
	  ) public Prescription findPrescriptionById(@Param("id") int id);
	 
	
	
//	@Query("SELECT pre FROM Prescription pre WHERE pre.id LIKE :id") 
//	 public Prescription findPrescriptionById(@Param("id") int id);
	
	 //kat
	 
	 
	 //Ani
		/*
		 * @Query("SELECT p.id FROM Prescription p  WHERE  p.doctor.doctorId LIKE :doctorId And a.appointmentDate LIKE :appointmentDate"
		 * ) public int totalPresByDateAndId(@Param("doctorId") String doctorId,@Param
		 * ("appointmentDate") LocalDate appointmentDate);
		 */
		/*
		 * @Query(SELECT a.prescription.id from Appointment a where a.id IKE :id")
		 * public Object findAllByApptId(@Param("id") int id);
		 */
		
		  @Query("SELECT p.id FROM Prescription p  WHERE  p.appoint.id LIKE :id")
		  public Object findAllByApptId(@Param("id") int id);
		 

	
}
