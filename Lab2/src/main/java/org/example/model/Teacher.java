package org.example.model;

import java.time.LocalDate;
import java.util.*;
public class Teacher extends Person {
    private Project[] proposedProjects;

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, Project[] proposedProjects) {
        super(firstName, lastName, dateOfBirth);
        this.proposedProjects = proposedProjects;
    }

    public Project[] getProposedProjects() {
        return proposedProjects;
    }

    @Override
    public String toString() {
        return super.toString() + " (Proposes " + proposedProjects.length + " projects)";
    }
}
