package com.example.educationsystem;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    public int getStudentId() {return studentId;}
    public void setStudentId(int studentId) {this.studentId = studentId;}

    private String firstName;
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    private String lastName;
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    private String address;
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    private String city;
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    private String postal;
    public String getPostal() {return postal;}
    public void setPostal(String postal) {this.postal = postal;}

    private String phone;
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}



}
