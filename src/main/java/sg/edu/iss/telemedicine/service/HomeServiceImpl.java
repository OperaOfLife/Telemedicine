package sg.edu.iss.telemedicine.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.repo.AppointmentRepository;
@Service
public class HomeServiceImpl implements HomeService
{

	 @Autowired 
	 AppointmentRepository arepo;
	 
	 
	 
	 public int getNumAppointmentsToday(LocalDate date) {
	  return arepo.findAppointbyDate(date);
	 }
	 
	 public ArrayList<LocalDate> getWeeklyAppointments(LocalDate today, LocalDate seven) {
	  //return a list of localDate
	  return arepo.findWeeklyAppoint(today, seven);
	  
	 }
}
