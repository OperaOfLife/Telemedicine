package sg.edu.iss.telemedicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.service.DoctorService;

import java.util.List;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class DoctorsListRestController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctor/list")
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        List<Doctor> allDoctors = doctorService.findAllDoctors();
        return new ResponseEntity<List<Doctor>>(allDoctors, HttpStatus.OK);
    }
    
    
    
   
        
        @RequestMapping(path = "searchDoctor/{keyword}", method = RequestMethod.GET)
        public ResponseEntity<List<Doctor>> searchDoctor(@PathVariable("keyword") String keyword){
            try {
                return new ResponseEntity<List<Doctor>> (doctorService.doctorSearch(keyword), HttpStatus.OK);
            }
            catch(Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }



    }  
    
    



