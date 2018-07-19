import java.util.*;

public class KruskalPrim {
  static Vector< Vector < IntegerPair> > AdjList = new Vector < Vector < IntegerPair > > ();
  static Vector<Boolean> taken = new Vector<Boolean>(); // global boolean flag to avoid cycle
  static PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>(); // priority queue to help choose shorter edges

  static void process(int vtx) { //  we do not need to use -ve sign to reverse the sort order
    taken.set(vtx, true);
    for (int j = 0; j < (int)AdjList.get(vtx).size(); j++) {
      IntegerPair v = AdjList.get(vtx).get(j);
      if (!taken.get(v.first()))
        pq.offer(new IntegerPair(v.second(), v.first()));
  } }    

  public static void main(String[] args) throws Exception {
    int V, E, u, v, w;

    /*
    // Graph in Figure 4.10 left, format: list of weighted edges
    // This example shows another form of reading graph input
    5 7
    0 1 4
    0 2 4
    0 3 6
    0 4 6
    1 2 2
    2 3 8
    3 4 9
    */

    Scanner sc = new Scanner(System.in);

    V = sc.nextInt();
    E = sc.nextInt();
    // Kruskal's algorithm merged with Prim's algorithm

    AdjList.clear();
    for (int i = 0; i < V; i++) {
      Vector < IntegerPair > Neighbor = new Vector < IntegerPair >(); // create vector of pair<int, int> 
      AdjList.add(Neighbor); // store blank vector first
    }
    Vector<IntegerTriple> EdgeList = new Vector<IntegerTriple>();
  
    // sort by edge weight O(E log E)
    // PQ default: sort descending. Trick: use <(negative) weight(i, j), <i, j> >
    for (int i = 0; i < E; i++) {
      u = sc.nextInt();
      v = sc.nextInt();
      w = sc.nextInt();
      EdgeList.add(new IntegerTriple(w, u, v));                // (w, u, v)
      AdjList.get(u).add(new IntegerPair(v, w));
      AdjList.get(v).add(new IntegerPair(u, w));
    }
    sc.close();
    Collections.sort(EdgeList);

    int mst_cost = 0;           // all V are disjoint sets at the beginning
    UnionFind UF = new UnionFind(V);
    for (int i = 0; i < E; i++) {                   // for each edge, O(E)
      IntegerTriple front = EdgeList.get(i);
      if (!UF.isSameSet(front.second(), front.third())) {          // check
        mst_cost += front.first();            // add the weight of e to MST
        UF.unionSet(front.second(), front.third());            // link them
      }
      if (UF.numDisjointSets() == 1) {
    	  break;
      }
    }

    // note: the number of disjoint sets must eventually be 1 for a valid MST
    System.out.printf("MST cost = %d (Kruskal's)\n", mst_cost);



  // inside int main() --- assume the graph is stored in AdjList, pq is empty
    for (int i = 0; i < V; i++)
      taken.add(false);                // no vertex is taken at the beginning
    process(0);   // take vertex 0 and process all edges incident to vertex 0
    mst_cost = 0;
    while (!pq.isEmpty()) { // repeat until V vertices (E=V-1 edges) are taken
      IntegerPair front = pq.peek(); pq.poll();
      u = front.second(); w = front.first();   // no need to negate id/weight
      if (!taken.get(u)) {           // we have not connected this vertex yet
        mst_cost += w;
        process(u); // take u, process all edges incident to u
      }
    }                                        // each edge is in pq only once!
    System.out.printf("MST cost = %d (Prim's)\n", mst_cost);
  }
}