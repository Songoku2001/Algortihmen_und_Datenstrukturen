
package ads.Blatt9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BinTreeWithIteratorTest {

	public void check(BinTreeWithIterator<Integer> tree, int[] expected) {
		int count = 0;
		for (int actual : tree) {
			assertEquals(expected[count++], actual);
		}
		assertEquals(expected.length, count);
	}

	
	@Test
	public void testIterator1() {
		// tiny
		BinTreeWithIterator<Integer> tree = new BinTreeWithIterator<Integer>();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		check(tree, new int[] {1,2,3});
	}	

	@Test
	public void testIterator2() {
		// degenerated left
		BinTreeWithIterator<Integer> tree = new BinTreeWithIterator<Integer>();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.left.left = tree.new Node(8);
		check(tree, new int[] {1,2,4,8});
	}	

	@Test
	public void testIterator3() {
		// degenerated right
		BinTreeWithIterator<Integer> tree = new BinTreeWithIterator<Integer>();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(3);
		tree.root.left.left = tree.new Node(7);
		tree.root.left.left.left = tree.new Node(15);
		check(tree, new int[] {1,3,7,15});
	}	

	@Test
	public void testIterator4() {
		// empty
		BinTreeWithIterator<Integer> tree = new BinTreeWithIterator<Integer>();
		check(tree, new int[] {});
	}	

	@Test
	public void testIterator5() {
		// root only
		BinTreeWithIterator<Integer> tree = new BinTreeWithIterator<Integer>();
		tree.root = tree.new Node(1);
		check(tree, new int[] {1});
	}	

	@Test
	public void testIterator6() {
		// hole on third level
		BinTreeWithIterator<Integer> tree = new BinTreeWithIterator<Integer>();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.left.right = tree.new Node(5);
		tree.root.right.right = tree.new Node(7);
		check(tree, new int[] {1,2,3,5,7});
	}	

}
