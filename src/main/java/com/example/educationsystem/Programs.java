package com.example.educationsystem;

import javax.persistence.*;

@Entity
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    public int getPid() {return pid;}
    public void setPid(int pid) {this.pid = pid;}

    private String programName;
    public String getProgramName() {return programName;}
    public void setProgramName(String programName) {this.programName = programName;}

    private String campus;
    public String getCampus() {return campus;}
    public void setCampus(String campus) {this.campus = campus;}
}
