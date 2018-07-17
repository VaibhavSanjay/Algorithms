import java.util.Scanner;
import java.util.Vector;

public class GraphUtility {
	public static Vector< Vector< Pair < Integer, Integer > > > getAdjList(Scanner sc) {
		int total_neighbors, id, weight;
		
		int V = sc.nextInt();
		Vector< Vector< Pair < Integer, Integer > > > AdjList = new Vector< Vector< Pair < Integer, Integer > > >(V);
		
	    for (int i = 0; i < V; i++) { // for each vertex
	      AdjList.add(new Vector < Pair < Integer, Integer > >()); // add this empty neighbor list to Adjacency List
	    }

	    for (int i = 0; i < V; i++) {
	      total_neighbors = sc.nextInt();
	      for (int j = 0; j < total_neighbors; j++) {
	        id = sc.nextInt();
	        weight = sc.nextInt();
	        AdjList.get(i).add( new Pair < Integer, Integer > (id - 1, weight)); // some index adjustment
	      }
	    }
		return AdjList;
	}
	
	public static void printAdjList(Vector< Vector< Pair < Integer, Integer > > > AdjList) {
		for (int i = 0; i < AdjList.size(); i++) {
			System.out.println("Neighbors of vertex " + i);
			for (Pair<Integer, Integer> v: AdjList.get(i)) {
				System.out.println("Edge " + i + "-" + v.first() + " (weight = " + v.second() + ")");
			}
		}
	}
	
	public static int[][] getAdjMat(Scanner sc) {
		int V, E, a, b, weight;
		V = sc.nextInt();
	    E = sc.nextInt();
	    
	    int[][] AdjMat = new int[V][];
	    for (int i = 0; i < V; i++) {
	      AdjMat[i] = new int[V];
	      for (int j = 0; j < V; j++)
	        AdjMat[i][j] = 1000000000; // use 1.10^9 to avoid overflow
	      AdjMat[i][i] = 0;
	    }

	    for (int i = 0; i < E; i++) {
	      a = sc.nextInt();
	      b = sc.nextInt();
	      weight = sc.nextInt();
	      AdjMat[a][b] = weight; // directed graph
	    }
	    return AdjMat;
	}
	
	/* relax(u, v, w_u_v) {
	 * 		dist[v] = min(dist[v], dist[u] + w_u_v)
	 * }
	 */
}
