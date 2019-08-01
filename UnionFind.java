import java.util.Vector;

class UnionFind {                                              // OOP style
  private Vector<Integer> p, rank, setSize;
  private int numSets;

  public UnionFind(int N) {
    p = new Vector<Integer>(N); // Parent array
    rank = new Vector<Integer>(N); //Rank array (unnecessary but helps keep tree short)
    setSize = new Vector<Integer>(N); //Size of each array
    numSets = N;
    for (int i = 0; i < N; i++) {
      p.add(i); // Each value is its own parent.
      rank.add(0);
      setSize.add(1);
    }
  }

  public int findSet(int i) { 
    if (p.get(i) == i) return i; // We found the top of this tree so return it.
    else {
      int ret = findSet(p.get(i)); p.set(i, ret); // Find the parent of the parent. Set the parent of this to that so next time it is shorter.
      return ret; // return the parent back down the chain.} }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { numSets--; // Only union if they are in different sets.
    int x = findSet(i), y = findSet(j); // Find the tops of the trees of the different numbers.
    // rank is used to keep the tree short
    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); } // Set the parent of y since it is lower rank, and add the size of y to the size of x's tree.
    else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x)); // Same as above.
                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } } // If it is equal, then set the rank of y to higher than x because y is the parent of x now.
  public int numDisjointSets() { return numSets; }
  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}
