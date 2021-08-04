package sg.edu.iss.telemedicine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClinicList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String zone;
	private String clinicName;
	private String address;
	private String PIN;
	private String phoneNo;
	
	
}
