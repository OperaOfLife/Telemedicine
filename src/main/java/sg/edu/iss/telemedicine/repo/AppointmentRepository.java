package sg.edu.iss.telemedicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.TimeSlots;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lombok.experimental.PackagePrivate;
import sg.edu.iss.telemedicine.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>
{

 //get all appointments by doctor id -- Genesis
	
	//gen searchbar for issue mc 
	
	 //gen 
	 @Query("SELECT a FROM Appointment a WHERE a.appointmentTime LIKE :time AND a.doctor LIKE :doctor AND a.appointmentDate LIKE :date") 
	 public Appointment findAppointmentByDocDateTime(@Param("time") TimeSlots time,@Param("doctor") Doctor doctor, @Param("date") LocalDate date);
	
	

	 //gen-dashboard
	 @Query("SELECT COUNT(a) FROM Appointment a WHERE a.appointmentDate LIKE :date")
	 public int findAppointbyDate(@Param("date")LocalDate date);
	 
	 @Query("SELECT a.appointmentDate From Appointment a WHERE a.appointmentDate BETWEEN :today AND :sevendays")
	 public ArrayList<LocalDate> findWeeklyAppoint(@Param("today")LocalDate today, @Param("sevendays")LocalDate sevendays);
	

@Query("SELECT a FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId OR a.appointmentDate LIKE :appointmentDate") 
 List<Appointment> findPatientBydoctorIdANDDate(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate);


	 @Query("SELECT a FROM Appointment a JOIN a.patient p  "
	   + "WHERE CONCAT(p.firstName, ' ', a.id, ' ', p.patientId)"
	   + "LIKE %?1%")
	 public List<Appointment> search(String keyword);
	
 @Query("SELECT a FROM Appointment a INNER JOIN a.doctor d WHERE d.doctorId LIKE :doctorid GROUP BY a.patient")
 public ArrayList<Appointment> findAppointmentsByDoctorID(@Param("doctorid") String doctorid);
 
 @Query("SELECT a FROM Appointment a INNER JOIN a.patient p WHERE p.patientId LIKE :patientid")
 public ArrayList<Appointment> findAppointmentsByPatientID(@Param("patientid") String patientid);
 
 //gen
 //Kat
 
 @Query("SELECT a FROM Appointment a WHERE a.doctor.doctorId LIKE :id") 
 public ArrayList<Appointment> findAllAppointmentsByDoctorId(@Param("id") String id); 
  
 @Query("SELECT a FROM Appointment a WHERE a.id LIKE :id") 
 public Appointment findBookingByAppointmentId(@Param("id") int id);
 
 @Query("SELECT a FROM Appointment a WHERE a.patient.patientId LIKE :id")  
 public ArrayList<Appointment> findConsultationHistoryByPatientId(@Param("id") String id);
//kat
 
 //Anisha
 
 @Query("SELECT a.id FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId And a.appointmentDate LIKE :appointmentDate") 
 List<Integer> findPatientBydoctorIdANDDateRest(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate);

@Query("SELECT a FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId AND a.appointmentDate LIKE :appointmentDate And a.appointmentTime LIKE :appointmentTime") 
List<Appointment> findPatientBydoctorIdANDDateTime(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate
								,@Param ("appointmentTime") TimeSlots appointmentTime);


@Query("SELECT a.appointmentTime FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId AND a.appointmentDate LIKE :appointmentDate") 
List<TimeSlots> findSlotsbyAppointment(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate);

@Query("SELECT COUNT(a) FROM Appointment a WHERE a.appointmentDate LIKE :date And a.doctor.doctorId LIKE :doctorId") 
public int findAppointbyDateAndId(@Param("date")LocalDate date, @Param("doctorId") String doctorId);

@Query("SELECT  COUNT(distinct a.patient.patientId) FROM Appointment a WHERE a.doctor.doctorId LIKE :doctorId") 
public int myPatients(@Param("doctorId") String doctorId);

@Query("SELECT a.id FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId And a.appointmentDate LIKE :appointmentDate") 
public List<Integer> findAllByIdAndDate(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate);


@Query("SELECT a.patient FROM Appointment a WHERE a.appointmentDate LIKE :date And a.doctor.doctorId LIKE :doctorId") 
public List<Patient> findPatientsTodayByIdAndDate(@Param("date")LocalDate date, @Param("doctorId") String doctorId);


 //Anisha
 
}
