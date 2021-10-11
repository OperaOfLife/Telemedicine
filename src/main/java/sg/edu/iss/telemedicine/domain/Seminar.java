package sg.edu.iss.telemedicine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seminar
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	String name;
	String link;
	
	public Seminar() 
	{
		super();
	}

	public Seminar( String name, String link) 
	{
		super();
		this.name = name;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	
	
	
}
