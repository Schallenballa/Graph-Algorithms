

import java.io.*;
import java.util.*;

public class floydWarshall {
	Integer[][] shortestPathMat = new Integer[totalVertices][totalVertices];
	Integer[][] successor = new Integer[totalVertices][totalVertices];
	ArrayList<Edge> edges = getEdges(true);
	
	for (int i=0; i<totalVertices; i++) {
		shortestPathMat[i][i] = 0;
	}
	for (Edge edge: edges) {
		Integer v1 = edge.getVertex1();
		Integer v2 = edge.getVertex2();
		Integer edgew = edge.getWeight();
		shortestPathMat[v1][v2] = edgew;
		successor[v1][v2] = v2;
	}
	
	for (int k=0; k<totalVertices; k++) {
		for (int i=0; i<totalVertices; i++) {
			if (successor[i][k] == null) {
				continue;
			}
			for (int j=0; j<totalVertices; j++) {
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
	displayAdjacencyMatrix(shortestPathMat);
	System.out.println("Successor matrix:");
	displayAdjacencyMatrix(successor);
}


