package sg.edu.iss.telemedicine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	
	@Override
	public boolean authenticate(User user)
	{
		User fromDB = urepo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
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
