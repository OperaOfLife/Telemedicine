package sg.edu.iss.telemedicine.repo;

import java.util.ArrayList; 
 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param; 
 
import sg.edu.iss.telemedicine.domain.Clinic; 
 
public interface ClinicRepository extends JpaRepository<Clinic, String> 
{ 
	
	@Query("SELECT c FROM Clinic c WHERE c.clinicName LIKE %?1%") 
	 ArrayList<Clinic> findSearchedClinics(String searchValue);
 
 @Query("SELECT c FROM Clinic c WHERE c.zone LIKE :zone") 
 ArrayList<Clinic> findByZone(@Param("zone") String zone); 
 
 @Query("SELECT c FROM Clinic c ORDER BY c.clinicName") 
 ArrayList<Clinic> findAllClinicsWithOrder(); 
 
}
