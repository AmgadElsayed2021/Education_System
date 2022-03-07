package com.example.educationsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/course")
public class CourseController {
    @Autowired
    private  CourseRepo CR;

    @Autowired
    private EnrollmentRepo ER;

    @Autowired
    private GradesRepo GR;

    //    add a Course
    @PostMapping(path = "/add")
    public @ResponseBody String addCourse (@RequestParam String courseName,@RequestParam int courseNumber,
                                           @RequestParam int capacity,@RequestParam int year ,
                                           @RequestParam String semester,@RequestParam int pid){
        Course CRS =new Course();
        CRS.setCourseName(courseName);
        CRS.setCourseNumber(courseNumber);
        CRS.setCapacity(capacity);
        CRS.setYear(year);
        CRS.setSemester(semester);
        CRS.setPid(pid);
        CR.save(CRS);
        return "Saved";
    }

    //api that uses json to add a new object
    //needs to be tested
    //    passed testing
    @PostMapping(path="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addACourse (@RequestBody Course c){
        CR.save(c);
        return "Saved";
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/list")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return CR.findAll();
}


    //needs to be tested
    //    passed testing
    @GetMapping(path="/view/{id}")
    public @ResponseBody
    Optional<Course> getCourseById(@PathVariable int id) {
        return CR.findById(id);
    }

    //needs to be tested
    //    passed testing
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteCourse(@PathVariable Integer id){

        List<Enrollment> enrollments=ER.findAllByCourseId(id);
        ER.deleteAll(enrollments);

        //delete the record from grades table
        List<Grades> grades=GR.findAllByCourseId(id);
        GR.deleteAll(grades);

        CR.deleteById(id);

        return "Deleted.";}


    //needs to be tested
    //    passed testing
    @PutMapping(path="/modify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String modifyCourse(@RequestBody Course crs){
        Course course = CR.findCourseByCourseId(crs.getCourseId());
        course.setCourseName(crs.getCourseName());
        course.setCourseNumber(crs.getCourseNumber());
        course.setCapacity(crs.getCapacity());
        course.setYear(crs.getYear());
        course.setSemester(crs.getSemester());
        course.setPid(crs.getPid());
        CR.save(course);
        return "Modified";

    }
}

