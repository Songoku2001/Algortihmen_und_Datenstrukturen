package ads.Vorlesung;

import java.util.HashSet;

public class CycleTree {

  public static class Node {
    Node left, right;
    int val;

    public Node(int val) {
      this.val = val;
    }

  }

  Node root;

  public CycleTree() {
  }

  // return true iff. tree has cycles.
  public boolean hasCycles() {
    HashSet<Node> allNodes = new HashSet<Node>();
    return hasCycles(root, allNodes);
  }

  public boolean hasCycles(Node n, HashSet<Node> allNodes) {
    if (n == null) {
      return false; // no cycle here...
    }
    if (allNodes.contains(n)) {
      return true; // found cycle
    }
    allNodes.add(n);
    return hasCycles(n.left, allNodes) || hasCycles(n.right, allNodes);
  }

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    CycleTree tree = new CycleTree();
    tree.root = n1;
    tree.root.left = n2;
    tree.root.right = n3;
    tree.root.left.left = n4;
    tree.root.right.left = n4;
    System.out.println(tree.hasCycles());
  }

}

