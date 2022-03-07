package com.example.educationsystem;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    public int getCourseId() {return courseId;}
    public void setCourseId(int courseId) {this.courseId = courseId;}

    private String courseName;
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}

    private int courseNumber;
    public int getCourseNumber() {return courseNumber;}
    public void setCourseNumber(int courseNumber) {this.courseNumber = courseNumber;}

    private int capacity;
    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    private int year;
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    private String semester;
    public String getSemester() {return semester;}
    public void setSemester(String semester) {this.semester = semester;}

    private int pid;
    public int getPid() {return pid;}
    public void setPid(int pid) {this.pid = pid;}

}
