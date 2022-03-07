package com.example.educationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/grades")
public class GradesController {
    @Autowired
    private GradesRepo GR;
    //    add a Grade
    @PostMapping(path = "/add")
    public @ResponseBody
    String addGrade (@RequestParam int studentId, @RequestParam int courseId,
                     @RequestParam int grade){
        Grades gr =new Grades();
        gr.setStudentId(studentId);
        gr.setCourseId(courseId);
        gr.setGrade(grade);
        GR.save(gr);
        return "Saved";
    }


    //api that uses json to add a new object
    //needs to be tested
    //    passed testing
    @PostMapping(path="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAGrade (@RequestBody Grades gr){
        GR.save(gr);
        return "Saved";
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/viewStudentGrades/{studentId}")
    public @ResponseBody
    List<Grades> getStudentGrades(@PathVariable Integer studentId) {
        return GR.findAllByStudentId(studentId);
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/viewCourseGrades/{courseId}")
    public @ResponseBody
    List<Grades> getCourseGrades(@PathVariable Integer courseId) {
        return GR.findAllByCourseId(courseId);
    }

    //needs to be tested
    //    passed testing
    @GetMapping(path="/list")
    public @ResponseBody
    Iterable<Grades> getAllGrades() {
        return GR.findAll();
    }


    //needs to be tested
    //    passed testing
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteGrade(@PathVariable Integer id){
        GR.deleteById(id);
        return "Deleted.";}


    //needs to be tested
    //    passed testing
    @PutMapping(path="/modify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String modifyStudent(@RequestBody Grades g){
        Grades grade = GR.findGradesByGid(g.getGid());
        grade.setStudentId(g.getStudentId());
        grade.setCourseId(g.getCourseId());
        grade.setGrade(g.getGrade());
        GR.save(grade);
        return "Modified";
    }
}
