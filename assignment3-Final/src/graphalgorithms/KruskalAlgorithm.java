package graphalgorithms;

import java.util.Arrays;

//Authors: Ahmed Naji, Robert Murch and Zach Schallenberger
//
//Date submitted: April 10, 2018
//
//Runs Kruskal's Algorithm with the given input

public class KruskalAlgorithm {

    String[] verticies;
    int[][] actualData;
    int max = Integer.MAX_VALUE;
    int numVerticies;

    //Construct the data array:
    public void initializeData(String[][] incomingArray, String [] vert) {
        
        verticies = vert;
        actualData = new int[incomingArray.length][incomingArray.length];

        for (int i = 0; i < actualData.length; i++) {
            for (int j = 0; j < incomingArray.length; j++) {

                if (incomingArray[i][j].equals("\u221E")) {

                    actualData[i][j] = 0;      //if inf symbol is seen replace with high value weight
                } else {
                    actualData[i][j] = Integer.parseInt(incomingArray[i][j]);
                }
            }
        }

        System.out.println();
        System.out.println("The adjacency matrix you are finding the MST for is: ");
        for (int[] actualData1 : actualData) {
            for (int j = 0; j < actualData1.length; j++) {
                System.out.print("\t" + actualData1[j]);
            }
            System.out.println();
        }

        numVerticies = actualData.length;
        kruskalAlg(actualData);
    }

    //Print the MST:
    void print(int parent[], int n, int graph[][]) {
        
        System.out.println();
        System.out.println("Verticies: ");
        System.out.println(Arrays.toString(verticies));
        System.out.println("------------------------");
        System.out.println();
        System.out.println("MST Edge's: ");
        for (int i = 1; i < numVerticies; i++) {
            System.out.println(((parent[i]+2)/2) + "---" + i);
        }
    }

    //Find's minimum vertex in MST:
    int minimumVertex(int key[], Boolean[] mstArray) {

        int min = max;
        int smallestIndex = -1;

        for (int i = 0; i < numVerticies; i++) {
            if (mstArray[i] == false) {
                if (key[i] < min) {
                    min = key[i];
                    smallestIndex = i;
                }
            }
        }

        return smallestIndex;
    }

    //Builds MST:
    void kruskalAlg(int graph[][]) {

        int[] arrayForMST = new int[numVerticies];
        int[] minWeight = new int[numVerticies];
        Boolean mstSet[] = new Boolean[numVerticies];

        //Initialize minWeight as large number
        for (int i = 0; i < numVerticies; i++) {
            minWeight[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        //Not directional therefore initialize:
        minWeight[0] = 0;
        arrayForMST[0] = -1;

        for (int count = 0; count < numVerticies - 1; count++) {

            int a = minimumVertex(minWeight, mstSet);

            //Add vertex:
            mstSet[a] = true;

            //Update value:
            for (int v = 0; v < numVerticies; v++) {
                if (graph[a][v] != 0 && mstSet[v] == false) {
                    if (graph[a][v] >= minWeight[v]) {
                    } else {
                        arrayForMST[v] = a;
                        minWeight[v] = graph[a][v];
                    }
                }
            }
        }

        //print call
        print(arrayForMST, numVerticies, graph);
    }
}
