package org.example.model;

public class SolutionDisplay {
    private Allocator allocator;

    public SolutionDisplay(Allocator allocator){
        this.allocator = allocator;
    }

    public void display(){
        Student[] students = allocator.getStudents();
        Project[] assignedProjects = allocator.getAssignedProjects();

        System.out.println("\n Final Project Assignment: ");
        for(int i =0; i<students.length; i++){
            String projectTitle = (assignedProjects[i] != null) ? assignedProjects[i].getTitle() : "No project Assgined";
            System.out.println(students[i].getFullName() + "->" + projectTitle);
        }
    }
}
