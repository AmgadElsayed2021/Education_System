package com.example.educationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepo ER;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addEnrollment (@RequestParam int courseId, int studentId){
        Enrollment er =new Enrollment();
        er.setCourseId(courseId);
        er.setStudentId(studentId);
        ER.save(er);
        return "Saved";
    }

    //api that uses json to add a new object
    //needs to be tested
    //    passed testing
    @PostMapping(path="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAnEnrollment (@RequestBody Enrollment e){
        ER.save(e);
        return "Saved";
    }

    @GetMapping(path="/viewStudentEnrollments/{studentId}")
    public @ResponseBody
    List<Enrollment> getStudentEnrollments(@PathVariable Integer studentId) {
        return ER.findAllByStudentId(studentId);
    }

    //needs to be tested
    //    passed testing
    @GetMapping(path="/viewCourseEnrollments/{courseId}")
    public @ResponseBody
    List<Enrollment> getCourseEnrollments(@PathVariable Integer courseId) {
        return ER.findAllByCourseId(courseId);
    }

    @GetMapping(path="/list")
    public @ResponseBody
    Iterable<Enrollment> getAllGrades() {
        return ER.findAll();
    }




    //needs to be tested
    //    passed testing
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteEnrollment(@PathVariable Integer id){
        ER.deleteById(id);
        return "Deleted.";}



    //needs to be tested
    //    passed testing
    @PutMapping(path="/modify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String modifyStudent(@RequestBody Enrollment e){
        Enrollment enrollment = ER.findEnrollmentByEid(e.getEid());
        enrollment.setStudentId(e.getStudentId());
        enrollment.setCourseId(e.getCourseId());
        ER.save(enrollment);
        return "Modified";
    }

}


