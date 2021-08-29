package sg.edu.iss.telemedicine.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import sg.edu.iss.telemedicine.domain.Doctor;


import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, String>
{
	/*
	 * @Query("SELECT d FROM Doctor d  WHERE " + "d.doctorId LIKE %?1%" +
	 * "OR d.firstName LIKE %?1%" + "OR d.lastName LIKE %?1%" +
	 * "OR d.mobile LIKE %?1%" + "OR d.email LIKE %?1%") public List<Doctor>
	 * doctorSearch(String keyword);
	 */
    
    
    
    @Query("SELECT d FROM Doctor d  WHERE "
            + "d.doctorId LIKE %?1%"
            + "OR d.firstName LIKE %?1%"
            + "OR d.lastName LIKE %?1%"
            + "OR d.mobile LIKE %?1%"
            + "OR d.email LIKE %?1%"
            + "OR d.speciality LIKE %?1%"
            + "OR d.description LIKE %?1%")
    public List<Doctor> doctorSearch(String keyword);

    @Query("SELECT d FROM Doctor d  WHERE "
            + "d.doctorId LIKE %?1%"
            + "OR d.firstName LIKE %?1%"
            + "OR d.lastName LIKE %?1%"
            + "OR d.mobile LIKE %?1%"
            + "OR d.email LIKE %?1%"
             + "OR d.speciality LIKE %?1%"
             + "OR d.description LIKE %?1%")
    public Page<Doctor> doctorSearchWithPage(String keyword, Pageable pageable);


}