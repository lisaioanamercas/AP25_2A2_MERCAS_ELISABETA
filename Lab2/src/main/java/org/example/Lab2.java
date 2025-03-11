package org.example;

import org.example.model.*;
import java.util.*;
import java.time.*;
import java.io.*;
import java.nio.file.*;

public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        lab2.compulsoryAndHomework();

        System.out.println("");
        System.out.println("----------------------------------------------------------------------------\n");

        lab2.bonus();
    }
    public void compulsoryAndHomework(){
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
        try {
            String studentFile = "C:\\Users\\Elisa\\Desktop\\Java\\PA\\Lab2\\students.txt";
            String projectsFile = "C:\\Users\\Elisa\\Desktop\\Java\\PA\\Lab2\\projects.txt";

            long startTime = System.nanoTime();
            Map<Student, Project[]> adjacencyList = graphGenerator(studentFile, projectsFile, 0.1);

            Runtime runtime = Runtime.getRuntime();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

            //printAdjancencyList(adjacencyList);

            AssignmentChecker checkHallsTheorem = new AssignmentChecker(adjacencyList);

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
            long endTime = System.nanoTime();

            long timeElapsed = (endTime - startTime)/1000000;//Convert nanos -> milis
            long memoryUsed = (memoryAfter - memoryBefore)/2024;//convert bytes -> KB

            checkHallsTheorem.printAssignments();
            System.out.println("Execution time: " + timeElapsed + " ms");
            System.out.println("Memory used: " + memoryUsed + " KB");
        }
        catch (IOException e) {
            System.err.println("Error reading files:" + e.getMessage());
        }
    }

    void printAdjancencyList(Map<Student, Project[]> adjancencyList){
        for(Map.Entry<Student, Project[]> entry : adjancencyList.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            System.out.print("[");

            Project[] projects = entry.getValue();
            for(int i =0; i<projects.length; i++){
                System.out.print(projects[i]);
                if(i<projects.length-1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public Map<Student, Project[]> graphGenerator(String studentFile, String projectsFile, double projectSelectionProbability) throws IOException {
        String[] studentLines = Files.readAllLines(Paths.get(studentFile)).toArray(new String[0]);
        /**
         * O mica explicatie la ce am facut aici:
         * IOException este cam o obligatie atunci cand lucrez cu fisiere
         * apoi citesc si stochez toate liniile din students.txt si dau throw la IOException daca nu exista fisiereul sau nu am permisiuni etc
         */
        Student[] students = new Student[studentLines.length];

        for (int i = 0; i < studentLines.length; i++) {
            String[] token = studentLines[i].split(",");
            if (token.length < 3)
                continue; //This mean that the string is properly formatted and skips the invalid lines

            String[] fullStudentName = token[0].split(" ");
            String firstName = fullStudentName[0];
            String lastName = "";
            if (fullStudentName.length > 1) lastName = fullStudentName[1]; //daca numele are macar 2 componente atunci le despart !!!

            LocalDate birthDate = LocalDate.parse(token[1]);
            long registrationNumber = Long.parseLong(token[2]);

            students[i] = new Student(firstName, lastName, birthDate, registrationNumber, new Project[]{});
        }

        //Acum citim din fisierul de proiecte

        String[] projectLines = Files.readAllLines(Paths.get(projectsFile)).toArray(new String[0]);
        Project[] projects = new Project[projectLines.length];

        for (int i = 0; i < projectLines.length; i++) {
            String[] token = projectLines[i].split(",");
            if (token.length < 2) continue; //Skip la linii invalide

            String projectName = token[0];
            ProjectType projectType = ProjectType.valueOf(token[1]);

            projects[i] = new Project(projectName, projectType);
        }
        int numberOfStudents = students.length;
        Student[] availableStudents = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            availableStudents[i] = students[i];
        }

        Map<Student, Project[]> adjListForRandomGraph = new HashMap<>();
        Random random = new Random();

        for (Student student : availableStudents) {
            int numberOfPrefferedProjects = 0;
            Project[] tempProjects = new Project[projects.length];

            for (int i = 0; i < projects.length; i++) {
                if (random.nextDouble() < projectSelectionProbability) {
                    tempProjects[numberOfPrefferedProjects] = projects[i];
                    numberOfPrefferedProjects++;
                }
            }
            if (numberOfPrefferedProjects == 0) {
                tempProjects[0] = projects[random.nextInt(projects.length)];
                numberOfPrefferedProjects = 1;
            }

            //copiez intr-un array de dimensiuni respectabile
            Project[] prefferedProjects = new Project[numberOfPrefferedProjects];
            for (int i = 0; i < numberOfPrefferedProjects; i++) {
                prefferedProjects[i] = tempProjects[i];
            }
            adjListForRandomGraph.put(student, prefferedProjects);
        }
        return adjListForRandomGraph;
    }
}