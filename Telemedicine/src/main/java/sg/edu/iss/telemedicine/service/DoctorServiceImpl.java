package sg.edu.iss.telemedicine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.repo.DoctorRepository;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }



    @Override
    public List<Doctor> doctorSearch(String keyword) {
        return doctorRepository.doctorSearch(keyword);
    }

    @Override
    public Page<Doctor> doctorSearchPage(String keyword, int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }
}
