package sg.edu.iss.telemedicine.service;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.controller.UserSession;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository urepo;
	
	
	

	@Override
	public void createUser(User user) 
	{
		urepo.save(user);
	}

	
	
	
	  @Override public boolean authenticate(User user)
	  { 
		  User fromDB =  urepo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	       if (fromDB != null)
	    	   return true;
	       else
	    	   return false;
	       }
	 
	
	@Override
	public boolean authenticateRegister(User user)
	{
		User fromDB = urepo.findUserByUsername(user.getUsername());
		if (fromDB != null)
			return true;
		else
			return false;
	}

	@Override
	public User findByName(String name) 
	{
		return urepo.findUserByUsername(name);
	}
	
	
	
	
	public ResponseEntity<User> loginuser(String uname,String pwd) 
	{
		//HttpHeaders responseHeaders = new HttpHeaders();
		
		User userdetail = urepo.findUserByUsernameAndPassword(uname,pwd);
		
		return new ResponseEntity<User>(userdetail, null, HttpStatus.OK);
		
		/*
		 * Map<String, String> imap = new LinkedHashMap<String,String>();
		 * 
		 * imap.put("User", userdetail.getUsername().toString()); return imap;
		 */
		
		/*
		 * if (userdetail != null) { responseHeaders.set("msg","Successful login");
		 * 
		 * return new ResponseEntity<User>(userdetail, responseHeaders, HttpStatus.OK);
		 * } else { responseHeaders.set("Error","UnSuccessful Attempt");
		 * 
		 * return new ResponseEntity<User>(null, responseHeaders,
		 * HttpStatus.BAD_REQUEST); }
		 */
	}



	@Override 
	   public boolean authenticate(String uname, String pwd) { 
	    boolean check = false; 
	    User fromDB =  urepo.findUserByUsernameAndPassword(uname, pwd); 
	        if (fromDB != null) 
	         check = true; 
	        return check; 
	   }
	
	/*
	 * @Override public RoleType findRoleByName(String name) { return
	 * urepo.findRoleByUsername(name); }
	 * 
	 * 
	 * 
	 * @Override public Lecturer lecturerByEmail(String email) {
	 * 
	 * return lrepo.findLecturerByEmail(email); }
	 * 
	 * 
	 * 
	 * @Override public Student studentByEmail(String email) {
	 * 
	 * return srepo.findStudentIdByEmail(email); }
	 */


	
}
