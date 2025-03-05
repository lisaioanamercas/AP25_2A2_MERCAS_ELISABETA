package org.example.model;

public class Project {
    private String projectName;
    private ProjectType projectType;
    private Student assignedStudent;

    public Project(String projectName, ProjectType projectType) {
        this.projectName = projectName;
        this.projectType = projectType;
    }

    public String getTitle(){
        return projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public Student getAssignedStudent() {
        return assignedStudent;
    }

    public void assignStudent(Student student){
        this.assignedStudent = student;
    }

    @Override
    public String toString(){
        return projectName + " (" + projectType + ")";
    }
}
