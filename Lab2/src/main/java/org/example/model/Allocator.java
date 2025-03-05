package org.example.model;

import java.util.*;

public class Allocator {
    private Student[] students;
    private Project[] projects;
    private Project[] assignedProjects;
    private boolean[] assigned;

    public Allocator(Student[] students, Project[] projects){
        this.students = students;
        this.projects = projects;
        this.assignedProjects = new Project[students.length];
        this.assigned = new boolean[projects.length];
    }

    private int getProjectIndex(Project project){
        for(int i = 0; i < projects.length; i++){
            if(projects[i].equals(project))
                return i;
        }
        return -1;
    }

    public void assignProjectsToStudents(){
        Random rand = new Random();

        for(int i=0; i<students.length; i++){
            Student student = students[i];
            boolean assignedSuccesfully = false;

            //try to assign a preffered projectttt
            for(Project preference : student.getPrefferedProjects()){
                int projectIndex = getProjectIndex(preference);
                if(projectIndex != -1 &&  !assigned[projectIndex]) {
                    assigned[projectIndex] = true; //mark this as solved, you can;t assign the same project to two students
                    assignedProjects[i] = projects[projectIndex];//add this to the assignedProjects array so that you mark it
                    projects[projectIndex].assignStudent(student);
                    assignedSuccesfully = true;
                    break;
                }
            }
            if(assignedSuccesfully == false){
                int freeProjectIndex = getRandomAvailableProject(rand);
                if(freeProjectIndex != -1){
                    assigned[freeProjectIndex] = true;
                    assignedProjects[i] = projects[freeProjectIndex];
                    projects[freeProjectIndex].assignStudent(student);
                    assignedSuccesfully = true;
                }
            }
        }
    }

    private int getRandomAvailableProject(Random random){
        int[] availableProjects = new int[projects.length];
        int availableCount = 0;

        for(int i = 0; i < projects.length; i++){
            if(!assigned[i]){
                availableProjects[availableCount++] = i;
            }
        }

        if(availableCount > 0){
            return availableProjects[random.nextInt(availableCount)];
        }
        return -1;
    }

    public Project[] getAssignedProjects(){
        return assignedProjects;
    }

    public Student[] getStudents(){
        return students;
    }

}
