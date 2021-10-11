package sg.edu.iss.telemedicine.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Role;
import sg.edu.iss.telemedicine.domain.User;

@Component
public class LoadData
{
	/*
	 * public class LoadData implements CommandLineRunner {
	 */	
	
	 
	    @Autowired
	    DoctorService doctorService;
	    @Autowired
	    PatientService patientService;
	    @Autowired
	    UserService userService;
	    
	    
	    //@Override
	    public void run(String... args) throws Exception {
	        loadDoctors();
	        loadPatients();
	        loadUsers();

	        
	    }

	    private void loadUsers() {
	        User user1=new User(3031,"A0111111B","kat", Role.PATIENT);
	        User user2=new User(3032,"A0222222B","kat", Role.PATIENT);
	        User user3=new User(3033,"A1111111B","kat", Role.DOCTOR);
	        User user4=new User(3034,"A2222222B","kat", Role.DOCTOR);

	        userService.createUser(user1);
	        userService.createUser(user2);
	        userService.createUser(user3);
	        userService.createUser(user4);

	    }

	    private void loadPatients() {
	        Patient patient1=new Patient("A0111111B","Zhang","Yi","male","23522634","zhangyi@gmail.com");
	        Patient patient2=new Patient("A0222222B","Genesis","Tan","male","12835835","genesis@gmail.com");
	        Patient patient3=new Patient("A0333333B","Kat","Wong","female","28357475","kat@gmail.com");
	        Patient patient4=new Patient("A0444444B","Anisha","Sinha","female","925232237","anisha@gmail.com");

	    patientService.savePatient(patient1);
	    patientService.savePatient(patient2);
	    patientService.savePatient(patient3);
	    patientService.savePatient(patient4);


	    }

	    private void loadDoctors() {
	        Doctor doctor1=new Doctor(
	                "A0000000B","Tan","cher","male",
	                "85465597","cher@gmail.com","Cardiologist",
	                "Infections in patients with hematologic malignancies,Transcatheter management of coarctation of the aorta",
	                "Vista Medical Centre"
	        );
	        Doctor doctor2=new Doctor(
	                "A1111111B","Benjamin","Sheares","male",
	                "85463286","Benjamin@gmail.com","Dentist",
	                "Balloon pulmonary valvuloplasty in adults and children,Transcatheter tricuspid valve-in-valve placement",
	                "Toa Payoh North Clinic & Surgery"
	        );
	        Doctor doctor3=new Doctor(
	                "A2222222B","Allon","Kahn","male",
	                "23741286","Allon@gmail.com","Gastroenterologist",
	                "Management of sports injuries to the elbow, wrist and hand",
	                "Vista Medical Centre"
	        );
	        Doctor doctor4=new Doctor(
	                "A3333333B","Sanjeev","Kakar","male",
	                "92232566","Sanjeev@gmail.com","General Surgeon",
	                "Transcatheter management of coarctation of the aorta,Transcatheter pulmonary valve implantation",
	                "Cambridge Clinic - Tampines"
	        );
	        Doctor doctor5=new Doctor(
	                "A44444444B","Nathaniel","Taggart","male",
	                "92427486","Nathaniel@gmail.com","Cardiologist",
	                "Effect of transcatheter interventions on quality of life and exercise capacity",
	                "Peak Medical Clinic & Surgery"
	        );
	        Doctor doctor6=new Doctor(
	                "A5555555B","Tahir","Tak","male",
	                "44233946","Tahir@gmail.com","Hematologist",
	                "Preventive cardiology and rehabilitation,Infective endocarditis",
	                "Cambridge Clinic - Tampines"
	        );
	        Doctor doctor7=new Doctor(
	                "A6666666B","Edwin","Takahashi","male",
	                "12243286","Edwin@gmail.com","Radiologist",
	                "Dialysis access management, Renal artery angioplasty, Renal artery stent procedure, IVC filter removal",
	                "Peak Medical Clinic & Surgery"
	        );
	        Doctor doctor8=new Doctor(
	                "A7777777B","Sandra","Taler","female",
	                "829363286","Sandra@gmail.com","Nephrologist",
	                "Obesity issues in kidney transplantation",
	                "Toa Payoh North Clinic & Surgery"
	        );


	        doctorService.save(doctor1);
	        doctorService.save(doctor2);
	        doctorService.save(doctor3);
	        doctorService.save(doctor4);
	        doctorService.save(doctor5);
	        doctorService.save(doctor6);
	        doctorService.save(doctor7);
	        doctorService.save(doctor8);


	    }

	

}
