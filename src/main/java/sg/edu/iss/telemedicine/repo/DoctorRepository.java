package sg.edu.iss.telemedicine.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    
    
    
     @Modifying
	 @Query("UPDATE Doctor d set d.firstName = :fname,d.lastName = :lname,d.email = :email,d.gender = :gender,d.mobile = :mobile,d.description = :desc,d.speciality = :spl, d.clinic_address = :addr WHERE d.doctorId LIKE :id")
     public void updateProfileDoc(@Param("id") String id,@Param("fname") String fname,@Param("lname") String lname,@Param("email") String email,@Param("gender") String gender,@Param("mobile") String mobile,@Param("desc") String desc,@Param("spl") String spl,@Param("addr") String addr);


}