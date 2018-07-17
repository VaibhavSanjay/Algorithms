import java.util.*;
public class Graphs {

	public static void main(String[] args) {
		 int V, E, total_neighbors, id, weight, a, b;

		    // Try this input for Adjacency Matrix/List/EdgeList
		    // Adj Matrix
		    //   for each line: |V| entries, 0 or the weight
		    // Adj List
		    //   for each line: num neighbors, list of neighbors + weight Pairs
		    // Edge List
		    //   for each line: a-b of edge(a,b) and weight
		    /*
		    6
		      0  10   0   0 100   0
		     10   0   7   0   8   0
		      0   7   0   9   0   0
		      0   0   9   0  20   5
		    100   8   0  20   0   0
		      0   0   0   5   0   0
		    6
		    2 2 10 5 100
		    3 1 10 3 7 5 8
		    2 2 7 4 9
		    3 3 9 5 20 6 5
		    3 1 100 2 8 4 20
		    1 4 5
		    7
		    1 2 10
		    1 5 100
		    2 3 7
		    2 5 8
		    3 4 9
		    4 5 20
		    4 6 5
		    */

		    Scanner sc = new Scanner(System.in);
		    V = sc.nextInt(); // we must know this size first!
		                      // remember that if V is > 100, try NOT to use AdjMat!
		    
		    //ADJACENCY MATRIX
		    int[][] AdjMat = new int[V][];
		    for (int i = 0; i < V; i++) {
		      AdjMat[i] = new int[V];
		      for (int j = 0; j < V; j++)
		        AdjMat[i][j] = sc.nextInt();
		    }

		    System.out.println("Neighbors of vertex 0:");
		    for (int j = 0; j < V; j++) // O(|V|)
		      if (AdjMat[0][j] != 0)
		        System.out.println("Edge 0-" + j + " (weight = " + AdjMat[0][j] + ")");
		    
		    // ADJACENCY LIST
		    V = sc.nextInt();
		    Vector< Vector< Pair < Integer, Integer > > > AdjList = new Vector< Vector< Pair < Integer, Integer > > >(V);
		    for (int i = 0; i < V; i++) { // for each vertex
		      Vector< Pair < Integer, Integer > > Neighbor = new Vector < Pair < Integer, Integer > >();
		      AdjList.add(Neighbor); // add this empty neighbor list to Adjacency List
		    }

		    for (int i = 0; i < V; i++) {
		      total_neighbors = sc.nextInt();
		      for (int j = 0; j < total_neighbors; j++) {
		        id = sc.nextInt();
		        weight = sc.nextInt();
		        AdjList.get(i).add( new Pair < Integer, Integer > (id - 1, weight)); // some index adjustment
		      }
		    }

		    System.out.println("Neighbors of vertex 0:");
		    Iterator it = AdjList.get(0).iterator(); // AdjList[0] contains the required information
		    while (it.hasNext()) { // O(k), where k is the number of neighbors
		      Pair< Integer, Integer > val = (Pair< Integer, Integer >)it.next();
		      System.out.println("Edge 0-" + val.first() + " (weight = " + val.second() + ")");
		    }
		    
		    // EDGE LIST
		    E = sc.nextInt();
		    PriorityQueue < Pair < Integer, Pair < Integer, Integer > > > EdgeList = new PriorityQueue < Pair < Integer, Pair < Integer, Integer > > >(1, 
		      new Comparator< Pair < Integer, Pair < Integer, Integer > > >() { // overriding the compare method
		        public int compare(Pair < Integer, Pair < Integer, Integer > > i, Pair < Integer, Pair < Integer, Integer > > j) {
		          return i.first() - j.first(); // currently min heap based on cost
		        }
		      }
		    );

		    for (int i = 0; i < E; i++) {
		      a = sc.nextInt();
		      b = sc.nextInt();
		      Pair < Integer, Integer > ab = new Pair < Integer, Integer > (a, b);
		      weight = sc.nextInt();
		      EdgeList.offer(new Pair < Integer, Pair < Integer, Integer > > 
		                               (-weight,  ab) ); // trick to reverse sort order */
		    }

		    // edges sorted by weight (smallest->largest)
		    for (int i = 0; i < E; i++) {
		      Pair < Integer, Pair < Integer, Integer > > edge = EdgeList.poll();
		      // negate the weight again
		      System.out.println("weight: " + (-edge.first()) + " (" + edge.second().first() + "-" + edge.second().second() + ")");
		    }
		    
		    sc.close();
	}

}
