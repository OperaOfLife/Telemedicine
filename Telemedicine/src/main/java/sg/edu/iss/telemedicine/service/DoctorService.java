package sg.edu.iss.telemedicine.service;

import org.springframework.data.domain.Page;
import sg.edu.iss.telemedicine.domain.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> findAllDoctors();
    public List<Doctor> doctorSearch(String keyword);
    public Page<Doctor> doctorSearchPage(String keyword, int pageNo, int pageSize, String sortField,
                                       String sortDirection);


}
