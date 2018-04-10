package graphalgorithms;


import java.io.*;
import java.util.*;

import com.sun.javafx.geom.Edge;

public class floydWarshall {
	Integer[][] shortestPathMat = new Integer[5][5];
	Integer[][] successor = new Integer[5][5];
	ArrayList<Edge> edges = getEdges(true);

	public void initializeData(String[][] incomingArray, String [] vert) {
		for (int i=0; i<5; i++) {
			shortestPathMat[i][i] = 0;
		}
		for (Edge edge: edges) {
			Integer v1 = 0;
			Integer v2 = 1;
			Integer edgew = 2;
			shortestPathMat[v1][v2] = edgew;
			successor[v1][v2] = v2;
		}

		for (int k=0; k<5; k++) {
			for (int i=0; i<5; i++) {
				if (successor[i][k] == null) {
					continue;
				}
				for (int j=0; j<5; j++) {
					if (shortestPathMat[i][k]==null || shortestPathMat[k][j]==null) {
						continue;
					}
					if ((shortestPathMat[i][j] == null) ||	// if distance at infinity
							(shortestPathMat[i][j] > shortestPathMat[i][k] + shortestPathMat[k][j])) {
						shortestPathMat[i][j] = shortestPathMat[i][k] + shortestPathMat[k][j];
						successor[i][j] = successor[i][k];
					}
				}
			}
		}
		System.out.println("APSP:");
		//displayAdjacencyMatrix(shortestPathMat);
		System.out.println("Successor matrix:");
		//displayAdjacencyMatrix(successor);



	}
	private ArrayList<Edge> getEdges(boolean b) {
		return edges;
	}
}






