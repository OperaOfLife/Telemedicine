package sg.edu.iss.telemedicine.service;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HomeService {

	int getNumAppointmentsToday(LocalDate currentDate);

	ArrayList<LocalDate> getWeeklyAppointments(LocalDate firstDay, LocalDate lastDay);

}
