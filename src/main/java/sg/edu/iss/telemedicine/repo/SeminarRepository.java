package sg.edu.iss.telemedicine.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import sg.edu.iss.telemedicine.domain.Seminar;

public interface SeminarRepository extends JpaRepository<Seminar, Integer>
{

	
	 public Seminar findTopByOrderByIdDesc();
	 
	
}
