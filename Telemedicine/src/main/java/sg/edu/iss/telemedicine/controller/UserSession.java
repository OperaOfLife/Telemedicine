package sg.edu.iss.telemedicine.controller;

import java.io.Serializable;

import sg.edu.iss.telemedicine.domain.User;



public class UserSession implements Serializable
{
	private static final long serialVersionUID = 1L;
	private User user = null;
	
	
	
	
	public UserSession() 
	{
		super();
	}


	public UserSession(User user) 
	{
		super();
		this.user = user;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
