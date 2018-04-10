package graphalgorithms;

import java.io.*;
import java.util.*;

//Authors: Ahmed Naji, Robert Murch and Zach Schallenberger
//
//Date submitted: April x, 2018
//
//The following program takes in data from a csv file the form of which can be seen below.
//It then creates minimum spanning tree's based off of the input using three diffrent methods.
//
//Current input:
//
//0,1,2,3,4
//----------
//∞,6,∞,∞,2
//6,∞,4,9,6
//∞,4,∞,8,∞
//∞,9,8,∞,7
//2,6,∞,7,∞
//
//Note, the input can be altered by altering the text file located in the input folder.


public class GraphAlgorithms {

    public static void main(String[] args) throws IOException {

        String inputFile = "src/input/input.txt";
        String fName = inputFile;
        String thisLine;
        String[][] data = new String[100][100];
        int count = 0;
        int size = 0;
        
        PrimsAlgorithm graph = new PrimsAlgorithm();

        FileInputStream geek = new FileInputStream(fName);
        BufferedReader in = new BufferedReader(new InputStreamReader(geek, "UTF-16"));

        while ((thisLine = in.readLine()) != null) {

            String[] array = thisLine.split(",");
            System.arraycopy(array, 0, data[count], 0, array.length);
            size = array.length;
            count++;
        }

        String[] vert = new String[size];
        System.arraycopy(data[0], 0, vert, 0, size);

        String[][] arrayData = new String[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(data[i + 1], 0, arrayData[i], 0, size);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the algorithm you wish to run: "
                + "1 for Prim's algorithm, 2 for Kruskal's algorithm"
                + "or 3 for Floyd-Warshall’s algorithm ");

        while (sc.hasNext()) {

            int i = sc.nextInt();
            switch (i) {

                case 1:
                    
                    System.out.println();
                    System.out.println("You chose Prim's algorithm.");
                    graph.initializeData(arrayData, vert);
                    break;

                case 2:
                    System.out.println("You chose Kruskal's algorithm.");
                    break;

                case 3:
                    System.out.println("You chose Floyd-Warshall's algorithm.");
                    break;

                default:
                    System.out.println("Invalid entry");
                    break;
            }
            System.out.println();
            System.out.println("Please select the algorithm you wish to run: "
                    + "1 for Prim's algorithm, 2 for Kruskal's algorithm"
                    + "or 3 for Floyd-Warshall’s algorithm ");
        }
    }
}
