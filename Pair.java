class Pair < X, Y > { // utilizing Java "Generics"
  private X _first;
  private Y _second;

  public Pair(X f, Y s) { _first = f; _second = s; }

  X first() { return _first; }
  Y second() { return _second; }

  void setFirst(X f) { _first = f; }
  void setSecond(Y s) { _second = s; }
}