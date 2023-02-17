package ads.Blatt9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinTreeWithIterator<T> implements Iterable<T> {

	Node root;
	Queue<Node> queue; //neu

	class Node {

		Node left;
		Node right;
		T value;

		Node(T value) {
			this.value = value;
		}

		Node(T value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}


	@Override
	public Iterator<T> iterator() {
		return new TreeIterator(root);
	}
	public class TreeIterator implements Iterator<T> {
		public TreeIterator (Node root) {
			if (root!=null) {
				queue.add(root);
			}
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
		public T next() {
			Node knoten=queue.poll();

			if (knoten.left!=null) {
				queue.add(knoten.left);
			}
			if (knoten.right!=null) {
				queue.add(knoten.right);
			}
			return knoten.value;
		}
	}

	public BinTreeWithIterator() {
		queue = new LinkedList<>();
	}

	public static void main(String[] args) {
		BinTreeWithIterator<String> tree = new BinTreeWithIterator<String>();
		tree.root = tree.new Node("Winter");
		tree.root.left = tree.new Node("is");
		tree.root.right = tree.new Node("coming.");
		// should print "Winter \n is \n coming."
		for (String s : tree) {
			System.out.println(s);
		}
	}
}
