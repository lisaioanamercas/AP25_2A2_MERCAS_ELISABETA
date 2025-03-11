package org.example.model;

import java.util.*;

public class AssignmentChecker {
    private Map<Student, Project[]> adjancencyList;
    private Map<Project, Student> projectAssignments;
    private Student[] allStudents;
    private Project[] allProjects;
    private boolean[] visited;

    public AssignmentChecker(Map<Student, Project[]> adjancencyList) {
        this.adjancencyList = adjancencyList;
        this.projectAssignments = new HashMap<>();
        this.allStudents = new Student[adjancencyList.size()];
        this.allProjects = new Project[adjancencyList.size()];
        this.visited = new boolean[adjancencyList.size()];

        int index = 0;
        for (Student student : adjancencyList.keySet()) {
            allStudents[index++] = student;
        }
    }

    /**
     * Run the Hopcroft-Karp alg to check if every student can get a project.
     * return true if a perfect matching existis
     */
    public boolean canAllocateProjects() {
        for (int i = 0; i < allStudents.length; i++) {
            clearVisited();
            if (!(dfs(allStudents[i]))) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Student student) {
        int studentIndex = getStudentIndex(student);
        if(visited[studentIndex]) return false; //prevent infinite loops
        visited[studentIndex] = true;

        Project[] prefferedProjects = adjancencyList.get(student);
        for(int i=0; i<prefferedProjects.length; i++) {
            Project project = prefferedProjects[i];
            /**
             * IF the project is not assigned
             *      OR the current assigned student can be reassigned to another project
             */
            if(!projectAssignments.containsKey(project) ||
                dfs(projectAssignments.get(project))) {
                projectAssignments.put(project, student);
                return true;
            }
        }
        return false;
    }
    private void clearVisited() {
        for(int i=0; i<visited.length;i++) {
            visited[i] = false;
        }
    }

    private int getStudentIndex(Student student) {
        for (int i = 0; i < allStudents.length; i++) {
            if(allStudents[i].equals(student)) {
                return i;
            }
        }
        return -1; //worst case scenario in care nu il gaseste pe student
    }

    public void printAssignments() {
        if(!canAllocateProjects()) {
            System.out.println("NO! :(");
            return;
        }

        System.out.println("YES! ;)");
        System.out.println("Project Assignments:");
        for(Map.Entry<Project, Student> entry : projectAssignments.entrySet()) {
            System.out.println(entry.getValue(). getFullName() + " -> " + entry.getKey().getTitle());
        }
    }

}
