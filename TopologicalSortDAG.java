import java.util.Scanner;
import java.util.Vector;

/**
 * This is for creating ONE topological sort of a directed acyclic graph.
 * @author vaibh
 *
 */
public class TopologicalSortDAG {
	static boolean[] dfs_num;
	static Vector< Vector< Pair < Integer, Integer > > > AdjList;
	static Vector<Integer> ts;
	
	public static void main(String[] args) {
		AdjList = GraphUtility.getAdjList(new Scanner(System.in));
		dfs_num = new boolean[AdjList.capacity()];
		ts = new Vector<Integer>(AdjList.capacity());
		dfs2(0);
		System.out.println(ts.toString());
	}
	
	public static void dfs2(int u) {
		dfs_num[u] = true;
		for (int j = 0; j < AdjList.get(u).size(); j++) {
			Pair<Integer, Integer> v = AdjList.get(u).get(j);
			if (dfs_num[v.first()] = false) {
				dfs2(v.first());
			}
			
		}
		ts.add(u);
	}
	
}
