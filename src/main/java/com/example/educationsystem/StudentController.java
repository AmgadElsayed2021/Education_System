package com.example.educationsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")

public class StudentController {
    @Autowired
    private StudentRepo SR;

    @Autowired
    private EnrollmentRepo ER;

    @Autowired
    private GradesRepo GR;


    //    add a student
    @PostMapping(path = "/add")
    public @ResponseBody
    String addStudent (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                       @RequestParam String address, @RequestParam String city, @RequestParam String postal,
                       @RequestParam String phone){
        Student ST =new Student();
        ST.setFirstName(firstName);
        ST.setLastName(lastName);
        ST.setEmail(email);
        ST.setAddress(address);
        ST.setCity(city);
        ST.setPostal(postal);
        ST.setPhone(phone);
        SR.save(ST);
        return "Saved";
    }

    //api that uses json to add a new object
    //needs to be tested
    //    passed testing
    @PostMapping(path="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAStudent (@RequestBody Student s){
        SR.save(s);

        return "Saved";
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/list")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return SR.findAll();
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/view/{id}")
    public @ResponseBody
    Optional<Student> getStudentById(@PathVariable int id) {
        return SR.findById(id);
    }

    //needs to be tested
    //    passed testing
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteStudent(@PathVariable Integer id){
        //delete the record from student table
        SR.deleteById(id);

        //delete the record from enrollments table
        List<Enrollment> enrollments=ER.findAllByStudentId(id);
        ER.deleteAll(enrollments);

        //delete the record from grades table
        List<Grades> grades=GR.findAllByStudentId(id);
        GR.deleteAll(grades);


        return "Deleted.";}


    //needs to be tested
    //    passed testing
    @PutMapping(path="/modify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String modifyStudent(@RequestBody Student std){
        Student student = SR.findStudentByStudentId(std.getStudentId());
        student.setFirstName(std.getFirstName());
        student.setLastName(std.getLastName());
        student.setEmail(std.getEmail());
        student.setAddress(std.getAddress());
        student.setCity(std.getCity());
        student.setPostal(std.getPostal());
        student.setPhone(std.getPhone());
        SR.save(student);
        return "Modified";
    }

}
