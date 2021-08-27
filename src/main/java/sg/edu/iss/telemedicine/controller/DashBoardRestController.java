package sg.edu.iss.telemedicine.controller;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.HomeService;
import sg.edu.iss.telemedicine.service.PatientService;

@RestController
public class DashBoardRestController 
{
	@Autowired
	HomeService hservice;
	
	@Autowired
	PatientService pservice;
	
	@Autowired
	DoctorService dservice;

	//dashboard test
	 @RequestMapping("todaysize")
	 public Integer getTodaySize() {
	  //get number of appointment based on current date 
	  LocalDate currentDate = LocalDate.now();
	  //new method
	  return hservice.getNumAppointmentsToday(currentDate);
	  
	 }
	 
	 @RequestMapping("numofpatients")
	 public Integer getNumOfPatients() {
	  return pservice.listAllPatients().size();
	  
	 }
	 
	 @RequestMapping("numofdoctors")
	 public Integer getNumOfDoctors() {
	  return dservice.findAllDoctors().size();
	 }
	 
	 @RequestMapping("numofappointments")
	 public ArrayList<Integer> getWeeklyAppointments(){
	  //today 
	  LocalDate todaydate = LocalDate.now();
	  //get the first day of the week and the last day of the week 
	  TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
	  
	  LocalDate firstDay = todaydate.with(fieldISO, 1);
	  LocalDate lastDay = todaydate.with(fieldISO,7);

	  //get arraylist of appointments-new method
	  ArrayList<LocalDate> weeklyDates = hservice.getWeeklyAppointments(firstDay, lastDay);
	  
	  //create new list
	  ArrayList<String> weeklyDays = new ArrayList<String>();
	  for(int i = 0; i < weeklyDates.size();i++) {
	   weeklyDays.add(weeklyDates.get(i).getDayOfWeek().toString());
	  }
	  
	  //count duplicates and store in new arraylist
	  ArrayList<Integer> dailyCounts = new ArrayList<Integer>();
	  int countA=Collections.frequency(weeklyDays, "MONDAY");
	  int countB=Collections.frequency(weeklyDays, "TUESDAY");
	  int countC=Collections.frequency(weeklyDays, "WEDNESDAY");
	  int countD=Collections.frequency(weeklyDays, "THURSDAY");
	  int countE=Collections.frequency(weeklyDays, "FRIDAY");
	  int countF=Collections.frequency(weeklyDays, "SATURDAY");
	  int countG=Collections.frequency(weeklyDays, "SUNDAY");
	  
	  dailyCounts.add(countA);
	  dailyCounts.add(countB);
	  dailyCounts.add(countC);
	  dailyCounts.add(countD);
	  dailyCounts.add(countE);
	  dailyCounts.add(countF);
	  dailyCounts.add(countG);
	  
	  return dailyCounts;
	  }
}
