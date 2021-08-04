package sg.edu.iss.telemedicine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.telemedicine.domain.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, String>
{

}
