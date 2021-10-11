package sg.edu.iss.telemedicine.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.User;

public interface UserRepository extends JpaRepository<User, String>
{
	public User findUserByUsernameAndPassword(String un, String pwd);
    public User findUserByUsername(String name);

   
    @Modifying
    @Query("UPDATE User u set u.password = :pwd WHERE u.username LIKE :id") 
	 public void updatePwd(@Param("id") String id , @Param("pwd") String pwd);
}
