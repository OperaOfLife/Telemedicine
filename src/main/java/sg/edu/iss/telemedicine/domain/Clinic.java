package sg.edu.iss.telemedicine.domain;


			import javax.persistence.Entity; 
			import javax.persistence.GeneratedValue; 
			import javax.persistence.GenerationType; 
			import javax.persistence.Id; 
			 
			@Entity 
			public class Clinic 
			{ 
			 @Id 
			 @GeneratedValue(strategy = GenerationType.AUTO) 
			 private String id; 
			 private String zone; 
			 private String clinicName; 
			 private String address; 
			 private String phoneNo; 
			 private String openingHours; 
			 private double lat; 
			 private double lng; 
			  
			  
			  
			 public String getId() { 
			  return id; 
			 } 
			 public void setId(String id) { 
			  this.id = id; 
			 } 
			 public String getZone() { 
			  return zone; 
			 } 
			 public void setZone(String zone) { 
			  this.zone = zone; 
			 } 
			 public String getClinicName() { 
			  return clinicName; 
			 } 
			 public void setClinicName(String clinicName) { 
			  this.clinicName = clinicName; 
			 } 
			 public String getAddress() { 
			  return address; 
			 } 
			 public void setAddress(String address) { 
			  this.address = address; 
			 } 
			 public String getPhoneNo() { 
			  return phoneNo; 
			 } 
			 public void setPhoneNo(String phoneNo) { 
			  this.phoneNo = phoneNo; 
			 } 
			 public String getOpeningHours() { 
			  return openingHours; 
			 } 
			 public void setOpeningHours(String openingHours) { 
			  this.openingHours = openingHours; 
			 } 
			 public double getLat() { 
			  return lat; 
			 } 
			 public void setLat(double lat) { 
			  this.lat = lat; 
			 } 
			 public double getLng() { 
			  return lng; 
			 } 
			 public void setLng(double lng) { 
			  this.lng = lng; 
			 } 
			  
			  
			  
			  
			}