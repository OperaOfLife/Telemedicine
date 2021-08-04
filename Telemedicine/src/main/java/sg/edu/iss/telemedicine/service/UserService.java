package sg.edu.iss.telemedicine.service;

import sg.edu.iss.telemedicine.domain.User;

public interface UserService 
{
	public User findByName(String name);
	public void createUser(User user);
	public boolean authenticate(User user);

	/*
	 * public RoleType findRoleByName(String name); public Lecturer
	 * lecturerByEmail(String email); public Student studentByEmail(String email);
	 */
	boolean authenticateRegister(User user);
}
