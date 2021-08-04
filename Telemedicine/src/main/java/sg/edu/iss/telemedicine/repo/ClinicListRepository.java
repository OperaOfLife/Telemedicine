package sg.edu.iss.telemedicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.telemedicine.domain.ClinicList;

public interface ClinicListRepository extends JpaRepository<ClinicList, String>
{

}
