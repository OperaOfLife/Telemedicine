package sg.edu.iss.telemedicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Pager;
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

        return findByPage(null,1,6,model);
    }
    @RequestMapping(value = "/search/page/{pageNo}/{pageSize}", method = RequestMethod.GET)

    public String findByPage(@RequestParam(value = "keyword") String keyword,
                             @PathVariable(value = "pageNo") int pageNo,
                             @PathVariable(value = "pageSize") int pageSize,
                             Model model)
    {


        Page<Doctor> page = doctorService.doctorSearchPage(keyword, pageNo, pageSize);
        List<Doctor> doctorList = page.getContent();

        Pager pager=new Pager(page.getTotalPages(),pageNo,5);


        model.addAttribute("doctorList",doctorList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("keyword", keyword);
        model.addAttribute("StartPage", pager.getStartPage());
        model.addAttribute("EndPage", pager.getEndPage());
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

















/*
 * package sg.edu.iss.telemedicine.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * sg.edu.iss.telemedicine.domain.Doctor; import
 * sg.edu.iss.telemedicine.service.DoctorService; import
 * sg.edu.iss.telemedicine.service.DoctorServiceImpl;
 * 
 * import java.util.List;
 * 
 * @Controller
 * 
 * @RequestMapping("/doctors") public class DoctorsListController {
 * 
 * @Autowired DoctorService doctorService;
 * 
 * 
 * @RequestMapping("/list") public String findAll(Model model) { List<Doctor>
 * allDoctors = doctorService.findAllDoctors();
 * model.addAttribute("allDoctors",allDoctors); return "patient-all-doctors"; }
 * 
 * 
 * @RequestMapping("/detail/{id}") public String
 * findDetailById(@PathVariable("id") String id, Model model) { Doctor doctor =
 * doctorService.getDoctorById(id);
 * 
 * model.addAttribute("Doctor",doctor); return "Patient-doctorsDetails"; }
 * 
 * 
 * 
 * 
 * 
 * }
 */