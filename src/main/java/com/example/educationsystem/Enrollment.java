package com.example.educationsystem;

import javax.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    public int getEid() {return eid;}
    public void setEid(int eid) {this.eid = eid;}

    private int courseId;
    public int getCourseId() {return courseId;}
    public void setCourseId(int courseId) {this.courseId = courseId;}

    private int studentId;
    public int getStudentId() {return studentId;}
    public void setStudentId(int studentId) {this.studentId = studentId;}
}
