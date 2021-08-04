package sg.edu.iss.telemedicine.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.telemedicine.domain.User;

public interface UserRepository extends JpaRepository<User, String>
{

}
