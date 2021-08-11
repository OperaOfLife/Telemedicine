package sg.edu.iss.telemedicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Patient;

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
	
	@Query("SELECT a.id FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId And a.appointmentDate LIKE :appointmentDate") 
	 List<Integer> findPatientBydoctorIdANDDateRest(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate);
	
	@Query("SELECT a FROM Appointment a  WHERE  a.doctor.doctorId LIKE :doctorId OR a.appointmentDate LIKE :appointmentDate") 
	List<Appointment> findPatientBydoctorIdANDDate(@Param("doctorId") String doctorId,@Param ("appointmentDate") LocalDate appointmentDate);
	
 @Query("SELECT a FROM Appointment a INNER JOIN a.doctor d WHERE d.doctorId LIKE :doctorid GROUP BY a.patient")
 public ArrayList<Appointment> findAppointmentsByDoctorID(@Param("doctorid") String doctorid);
 
 @Query("SELECT a FROM Appointment a INNER JOIN a.patient p WHERE p.patientId LIKE :patientid")
 public ArrayList<Appointment> findAppointmentsByPatientID(@Param("patientid") String patientid);
 
 //gen
 //Kat
 

 @Query("SELECT a FROM Appointment a JOIN a.prescription p JOIN a.mc mc WHERE a.patient.patientId LIKE :id")  
 public ArrayList<Appointment> findConsultationHistoryByPatientId(@Param("id") String id);
 
 //kat
}
