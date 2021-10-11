package sg.edu.iss.telemedicine.service;

import java.util.List;

import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Seminar;

public interface AdminService 
{
	public void saveSeminar(Seminar seminar);

	public Seminar findSeminars();
}
