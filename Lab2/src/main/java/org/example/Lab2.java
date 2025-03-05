package org.example;

import org.example.model.*;

import java.util.*;
import java.time.*;

public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        lab2.compulsoryAndHomework();

        lab2.bonus();
    }
    public void compulsoryAndHomework(){
    // Create the projects
        Project project1 = new Project("ABE: Mathematical Research", ProjectType.THEORETICAL);
        Project project2 = new Project("Spotify dupe", ProjectType.PRACTICAL);
        Project project3 = new Project("Operating System", ProjectType.PRACTICAL);
        Project project4 = new Project("Multilinear equations in Cybersecurity", ProjectType.THEORETICAL);
        Project project5 = new Project("Machine Learning Chatbot ", ProjectType.PRACTICAL);
        Project[] allProjects = { project1, project2, project3, project4, project5};

        Student student1 = new Student("Gigel", "Bostanel", LocalDate.of(2000, 5, 15), 1234L, new Project[]{allProjects[4], allProjects[1]});
        Student student2 = new Student("George", "Calinescu", LocalDate.of(2034, 5, 30), 1254L, new Project[]{allProjects[0], allProjects[2]});
        Student student3 = new Student("Frunzulitza", "Garofitza", LocalDate.of(1999, 3, 29), 3354L, new Project[]{allProjects[4], allProjects[0]});
        Student student4 = new Student("Adrian", "CopilulMinune", LocalDate.of(1969, 7, 7), 7777L, new Project[]{allProjects[4], allProjects[0]});

        Student[] allStudents = {student1, student2, student3, student4};
        //System.out.println(s1);
        Allocator allocator = new Allocator(allStudents,  allProjects);
        allocator.assignProjectsToStudents();

        SolutionDisplay display = new SolutionDisplay(allocator);
        display.display();
    }

    public void bonus(){
        System.out.println("Postponed pana stiu exact ce a ala Map in Java");
    }
}