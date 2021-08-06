package sg.edu.iss.telemedicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.telemedicine.domain.Appointment;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.telemedicine.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>
{

 //get all appointments by doctor id -- Genesis
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
