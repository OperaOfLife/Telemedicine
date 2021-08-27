package sg.edu.iss.telemedicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.DoctorServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorsListController {
    @Autowired
    DoctorService doctorService;
    
    
    @RequestMapping("/list")
    public String findAll(Model model)
    {
        List<Doctor> allDoctors = doctorService.findAllDoctors();
        model.addAttribute("allDoctors",allDoctors);
        return "patient-all-doctors";
    }

    
    @RequestMapping("/detail/{id}")
    public String findDetailById(@PathVariable("id") String id, Model model)
    {
        Doctor doctor = doctorService.getDoctorById(id);

        model.addAttribute("Doctor",doctor);
        return "Patient-doctorsDetails";
    }
    
    
    


}
