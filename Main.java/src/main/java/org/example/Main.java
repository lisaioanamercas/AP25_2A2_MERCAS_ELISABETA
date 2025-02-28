package org.example;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main lab1 = new Main();
        lab1.compulsory();

        System.out.println("\n------------------------------------------\n");
        if(args.length == 0){
            System.out.println("Please provide command line arguments\n");
        }
        lab1.homework(args);
        System.out.println("\n------------------------------------------\n");

        lab1.bonus();
    }
    void compulsory(){
        System.out.println("Hello World!%n");

        String[] languages= {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n=n*3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n=n*6;
        int sum =0;
        sum = sumOfDigits(n);
        System.out.printf("%d\n",sum);

        System.out.printf("Willy-nilly, this semester I will learn " + languages[sumOfDigits(sum)]);
    }
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    void homework(String[] args) {
        // Am pus la configuratie command line arguments
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if(k>n){
            System.out.println("k cannot be greater than n");
            return;
        }
        long startTime = System.nanoTime();

        int[][] adjMatrix = generateGraph(n, k);

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime)/1000000;
        if(n>=30000) {
            System.out.println("Matrix display skipped for large n");
            System.out.println("Execution Time: " + durationMs + " ms");
        }
        else
            printMatrix(adjMatrix);
    }
    private static int[][] generateGraph(int n, int k){
        int[][] tempMatrix = new int[n][n];
        Random random = new Random();
        boolean[] selected = new boolean[n];
        int [] degrees = new int[n];
        int nrOfEdges = 0, maxDegree = 0, maxDegreeNode=0, sumOfDegrees=0, minDegreeNode=0;

        int[]  cliqueNodes = new int[k];
        int count = 0;
        do{
            int node = random.nextInt(n);
            if(!selected[node]){
                //System.out.printf("Nodul ales pt clica este: %d\n", node);
                cliqueNodes[count++] = node;
                selected[node] = true;
            }
        }while(count < k);

        for(int i=0; i<k; i++){
            for(int j=i+1; j<k; j++) {
                tempMatrix[cliqueNodes[i]][cliqueNodes[j]]=1;
                tempMatrix[cliqueNodes[j]][cliqueNodes[i]]=1;
                degrees[cliqueNodes[i]]++;
                degrees[cliqueNodes[j]]++;
                nrOfEdges++;
            }
        }

        int[] stableSetNodes = new int[k];
        count = 0;
        while(count<k){
            int node = random.nextInt(n);
            if(!selected[node]) {
                //System.out.printf("Nodul ales pt stable set este: %d\n", node);
                stableSetNodes[count++] = node;
                selected[node] = true;
                minDegreeNode = node;
            }
        }
//        System.out.printf("%d\n",count);

        //Ensure the stable set in indeed stable
        for(int i=0; i<k; i++){
            for(int j=i+1; j<k; j++){
                tempMatrix[stableSetNodes[i]][stableSetNodes[j]]=0;
                tempMatrix[stableSetNodes[j]][stableSetNodes[i]]=0;
            }
        }
        int[] remainingNodes = new int[n-2*k];
        count = 0;
        for(int i=0; i<n; i++){
            if(!selected[i])
                remainingNodes[count++] = i;
        }

        double edgeProbability = (double)k/(double)n;
        for(int i=0; i< remainingNodes.length; i++){
            for(int j=i+1; j< remainingNodes.length; j++){
                if(tempMatrix[i][j]==0 && random.nextDouble()<edgeProbability && !selected[j] || !selected[i]){
                    //System.out.printf("Muchia pe care o adaug in graf este intre nodurile: %d %d\n", i, j);
                    tempMatrix[i][j] = 1;
                    tempMatrix[j][i] = 1;
                    degrees[i]++;
                    degrees[j]++;
                    nrOfEdges++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (degrees[i] > maxDegree) {
                maxDegree = degrees[i];
                maxDegreeNode = i;
            }
            sumOfDegrees += degrees[i];
        }

        if(sumOfDegrees/2!= nrOfEdges) {
            System.out.println("Very bad, the number of ednges is NOT equal to the sum of degrees");
        }
        System.out.print("The number of edges is " + nrOfEdges +"\n");
        System.out.println("The maximum degree of a vertex, " + "\u0394," + " is " + maxDegree + " for node "+ maxDegreeNode);
        System.out.println("The maximum degree of a vertex, " + "\u03B4," + " is 0" + " for node "+ minDegreeNode);
        return tempMatrix;
    }
    private static void printMatrix(int[][] matrix) {
        int n=matrix.length;
        System.out.print("   ");
        for(int i=0; i<n; i++){
            System.out.printf("%d ", i); //column index
        }
        System.out.println();

        for(int i=0; i<n; i++){
            System.out.printf("%2d ", i); //row index
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] ==1 ? "\u2B1B" : "\u2B1C");
            }
            System.out.println();
        }
    }

    void bonus() {

    }

}