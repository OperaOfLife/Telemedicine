package sg.edu.iss.telemedicine.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import sg.edu.iss.telemedicine.domain.User;

public interface UserService 
{
	public User findByName(String name);
	public void createUser(User user);
	public boolean authenticate(User user);
	public boolean authenticate(String uname,String pwd);
	public ResponseEntity<User> loginuser(String uname,String pwd);

	/*
	 * public RoleType findRoleByName(String name); public Lecturer
	 * lecturerByEmail(String email); public Student studentByEmail(String email);
	 */
	boolean authenticateRegister(User user);
}
