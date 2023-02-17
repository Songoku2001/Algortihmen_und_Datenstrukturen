package ads.Blatt8;


public class BinTree {

	Node root;

	static class Node {

		Node left;
		Node right;
		int value;

		Node(int value) {
			this.value = value;
		}

		Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}
			
	
	public BinTree() {
		root = null;
	}

	public BinTree(Node root) {
		this.root = root;
	}

	public int height() {
		return height(root);
	}

	public int height(Node n) {
		if (n==null) {
			return 0;
		}
		int l = height(n.left);
		int r = height(n.right);
		System.out.println("right " + r);
		return Math.max(l, r)+1;
	}
	
	public String pathToMax() {
		return maximum(root);
	}
	private String maximum(Node n) {
		int wurzel = root.value;
		int result = Integer.MIN_VALUE;
		var left = "left->";
		var right = "right";
		String r = "";

		// max value finden in der linken seiten
		if (n.value>result) {
			result=n.value;
		}
		r+=left;//den Pfad in meinem r speichern
		if (n.left!=null) {
			left = maximum(n.left);
		}

		// max value finden auf der rechten seiten
		if (n.value>result) {
			result=n.value;
		}
		r+=right;//den Pfad in meinem r speichern
		if (n.right!=null) {
			right = maximum(n.right);
		}

		//wenn die wurzel größer ist als der größter value
		if (wurzel>result) {
			return "";
		}
		return r;
	}

	public boolean isCompleteOrAlmostComplete() {
		return false;
	}

	@Override
	public String toString() {
		return "BinTree{" + "root=" + root + '}';
	}

	public static void main(String[] args) {

		var root = new BinTree.Node(6);
		var n2 = new BinTree.Node(5);
		var n3 = new BinTree.Node(4);
		var n4 = new BinTree.Node(3);
		var n5 = new BinTree.Node(2);
		var n6 = new BinTree.Node(1);
		root.right = n2;
		n2.right = n3;
		n3.right = n4;
		n4.right = n5;
		n5.right = n6;

		BinTree tree = new BinTree(root);
		var x = tree.height();
		//tree.pathToMax();

		System.out.println(x);
	}

}
