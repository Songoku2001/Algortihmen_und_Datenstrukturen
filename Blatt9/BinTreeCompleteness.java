package ads.Blatt9;

public class BinTreeCompleteness {

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


	public BinTreeCompleteness() {
		root = null;
	}

	public BinTreeCompleteness(Node root) {
		this.root = root;
	}

	public int height() {
		Node n = root;
		return height(n);
	}

	private int height(Node n) {
		if (n==null) {
			return 0;
		}
		int l=height(n.left);
		int r=height(n.right);

		return Math.max(l, r)+1;
	}



	public boolean isCompleteOrAlmostComplete() {
		if (root == null) {
			return true;
		}

		Node n;
		n = root;

		//Anzahl der Knoten linken hälfte --> Vollständigkeit
		int complete_left = (int) (Math.pow(2, height(n.left)) - 1);
		//Anzahl der Knoten rechten hälfte --> Vollständigkeit
		int complete_right = (int) (Math.pow(2, height(n.right)) - 1);

		//isComplete
		if (height(n.left) == height(n.right)
						&& rechtehoehe(n.right, complete_right)
						&& linkehoehe(n.left, complete_left)) {
			return true;
		}


		//Anzahl der Knoten rechten hälfte bei hoehe-2 --> letzte und vorletzte ebene dürfen lücken besitzen
		int almost_right = (int) (Math.pow(2, height(n.right) - 2) - 1);
		//Anzahl der Knoten linken hälfte bei hoehe-2 --> letzte und vorletzte ebene dürfen lücken besitzen
		int almost_left = (int) (Math.pow(2, height(n.left) - 2) - 1);

		//AlmostComplete
		return height(n) <= 3
						|| Math.abs(height(n.left) - height(n.right)) <= 1
						&& linkehoehe(n.left, almost_left)
						&& rechtehoehe(n.right, almost_right);
	}


	private boolean linkehoehe(Node n, int leftpart) {
		return leftpart==countNode(n);
	}

	private boolean rechtehoehe(Node n, int rightpart) {
		return rightpart==countNode(n);
	}

	private int countNode(Node node) {
		if (node==null) {
			return 0;
		}
		return 1+countNode(node.left)+countNode(node.right);
	}



	public static void main(String[] args) {
		/*
		 *  an incomplete sample tree
		 * (not fully complete, not almost complete)
		 *
		 * 1
		 * |_ 2
		 *    |_ 4
		 *    |_ 5
		 *       |_ 7
		 *       |_
		 *
		 * |_ 3
		 *    |_
		 *    |_ 6
		*/
		BinTreeCompleteness.Node n7 = new BinTreeCompleteness.Node(7);
		BinTreeCompleteness.Node n6 = new BinTreeCompleteness.Node(6);
		BinTreeCompleteness.Node n5 = new BinTreeCompleteness.Node(5, n7, null);
		BinTreeCompleteness.Node n4 = new BinTreeCompleteness.Node(4);
		BinTreeCompleteness.Node n3 = new BinTreeCompleteness.Node(3, null, n6);
		BinTreeCompleteness.Node n2 = new BinTreeCompleteness.Node(2, n4, n5);
		BinTreeCompleteness.Node n1 = new BinTreeCompleteness.Node(1, n2, n3);
		BinTreeCompleteness tree = new BinTreeCompleteness(n1);
		// should be false!
		//System.out.println(tree.isCompleteOrAlmostComplete());

		BinTreeCompleteness test2 = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		test2.root.left = new BinTreeCompleteness.Node(2);
		test2.root.right = new BinTreeCompleteness.Node(3);
		test2.root.left.left = new BinTreeCompleteness.Node(4);
		test2.root.right.left= new BinTreeCompleteness.Node(5);
		System.out.println(test2.isCompleteOrAlmostComplete());
	}

}

