package sg.edu.iss.telemedicine.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.telemedicine.domain.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String>
{

}