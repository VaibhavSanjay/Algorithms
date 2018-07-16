import java.util.Scanner;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFSVisit {
	static Vector< Vector< Pair < Integer, Integer > > > AdjList;
	static boolean[] edgeVis;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// ADJACENCY LIST
		AdjList = GraphUtility.getAdjList(sc);
		edgeVis = new boolean[AdjList.capacity()];
		
		// DFS
		DFS(0);
		
		System.out.println();
		
		AdjList = GraphUtility.getAdjList(sc);
		edgeVis = new boolean[AdjList.capacity()];
		
		//BFS
		BFS();
		
		sc.close();
		
		//Find connected components
	}
	
	public static void DFS(int u) {
		System.out.println("Visiting " + (u + 1));
		edgeVis[u] = true;
		for (int j = 0; j < AdjList.get(u).size(); j++) {
			Pair<Integer, Integer> v = AdjList.get(u).get(j);
			if (!edgeVis[v.first()]) {
				DFS(v.first());
			}
		}
	}
	
	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		edgeVis[0] = true;
		
		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.println("Visiting " + (u + 1));
			for (int j = 0; j < AdjList.get(u).size(); j++) {
				Pair<Integer, Integer> v = AdjList.get(u).get(j);
				if (!edgeVis[v.first()]) {
					edgeVis[v.first()] = true;
					q.add(v.first());
				}
			}
		}
	}
}
