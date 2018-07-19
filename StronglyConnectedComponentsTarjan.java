import java.util.*;

/**
 * For finding the Strongly Connected Components in a graph.
 * These are subgraphs such that any vertex u can get to any vertex v in the subgraph
 * and vice versa.
 * @author vaibh
 *
 */
public class StronglyConnectedComponentsTarjan {
	static Vector< Vector< Pair < Integer, Integer > > > AdjList;
	static Stack<Integer> S = new Stack<Integer>();
	static int[] dfs_low;
	static int[] dfs_num;
	static boolean[] visited;
	final static int UNVISITED = -1;
	static int dfsNumberCounter = 0;
	static int numSCC = 0;
	
	public static void main(String[] args) {
		AdjList = GraphUtility.getAdjList(new Scanner(System.in));
		
		dfs_low = new int[AdjList.capacity()];
		dfs_num = new int[AdjList.capacity()];
		visited = new boolean[AdjList.capacity()];
		Arrays.fill(dfs_num, UNVISITED);
		
		for (int i = 0; i < AdjList.capacity(); i++) {
			if (dfs_num[i] == UNVISITED) {
				tarjanSCC(i);
			}
		}
	}
	
	public static void tarjanSCC(int u) {
		dfs_low[u] = dfsNumberCounter;
		dfs_num[u] = dfsNumberCounter;
		dfsNumberCounter++;
		
		S.push(u);
		visited[u] = true;
		
		for (int j = 0; j < AdjList.get(u).size(); j++) {
			Pair<Integer, Integer> v = AdjList.get(u).get(j);
			
			if (dfs_num[v.first()] == UNVISITED) {
				tarjanSCC(v.first());
			}
			if (visited[v.first()]) {
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v.first()]);
			}
		}
		
		if (dfs_low[u] == dfs_num[u]) {
			System.out.println("SCC " + (++numSCC) + ":");
			
			while(true) {
				int v = S.pop();
				visited[v] = false;
				System.out.print(v + " ");
				if (u == v) break;
			}
			
			System.out.println();
		}
	}

}
