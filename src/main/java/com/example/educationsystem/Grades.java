package com.example.educationsystem;

import javax.persistence.*;

@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gid;
    public int getGid() {return gid;}
    public void setGid(int gid) {this.gid = gid;}

    private int studentId;
    public int getStudentId() {return studentId;}
    public void setStudentId(int studentId) {this.studentId = studentId;}

    private int courseId;
    public int getCourseId() {return courseId;}
    public void setCourseId(int courseId) {this.courseId = courseId;}

    private int grade;
    public int getGrade() {return grade;}
    public void setGrade(int grade) {this.grade = grade;}
}
