package org.example.model;

import java.time.LocalDate;
import java.util.*;

public class Student extends Person {
    private long regNumber;
    private Project[] prefferedProjects;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, long regNumber,  Project[] prefferedProjects) {
        super(firstName, lastName, dateOfBirth);
        this.regNumber = regNumber;
        this.prefferedProjects = prefferedProjects;
    }

    public long getRegNumber() {
        return regNumber;
    }

    public Project[] getPrefferedProjects() {
        return prefferedProjects;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student)obj;
        return regNumber == student.regNumber;
    }
    /**
     * Metoda de mai sus explicata: ...
     */

    @Override
    public String toString() {
        return super.toString() + " (RegID: " + regNumber + ")";
    }

}
