
package ads.Blatt9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinTreeCompletenessTest {

	BinTreeCompleteness createTreeFromSheet() {
		BinTreeCompleteness.Node n7 = new BinTreeCompleteness.Node(2);
		BinTreeCompleteness.Node n6 = new BinTreeCompleteness.Node(0);
		BinTreeCompleteness.Node n5 = new BinTreeCompleteness.Node(20, n7, null);
		BinTreeCompleteness.Node n4 = new BinTreeCompleteness.Node(16);
		BinTreeCompleteness.Node n3 = new BinTreeCompleteness.Node(3, null, n6);
		BinTreeCompleteness.Node n2 = new BinTreeCompleteness.Node(-4, n4, n5);
		BinTreeCompleteness.Node n1 = new BinTreeCompleteness.Node(8, n2, n3);
		
		BinTreeCompleteness tree = new BinTreeCompleteness(n1);
		return tree;
	}
	
	BinTreeCompleteness createUnbalancedTree() {
		BinTreeCompleteness.Node root = new BinTreeCompleteness.Node(1);
		BinTreeCompleteness.Node n2 = new BinTreeCompleteness.Node(2);
		BinTreeCompleteness.Node n3 = new BinTreeCompleteness.Node(3);
		BinTreeCompleteness.Node n4 = new BinTreeCompleteness.Node(4);
		BinTreeCompleteness.Node n5 = new BinTreeCompleteness.Node(5);
		BinTreeCompleteness.Node n6 = new BinTreeCompleteness.Node(6);
		root.left = n2;
		n2.left = n3;
		n3.left = n4;
		n4.left = n5;
		n5.left = n6;
		BinTreeCompleteness tree = new BinTreeCompleteness(root);
		return tree;
	}
	
	BinTreeCompleteness createUnbalancedTreeBackward() {
		BinTreeCompleteness.Node root = new BinTreeCompleteness.Node(6);
		BinTreeCompleteness.Node n2 = new BinTreeCompleteness.Node(5);
		BinTreeCompleteness.Node n3 = new BinTreeCompleteness.Node(4);
		BinTreeCompleteness.Node n4 = new BinTreeCompleteness.Node(3);
		BinTreeCompleteness.Node n5 = new BinTreeCompleteness.Node(2);
		BinTreeCompleteness.Node n6 = new BinTreeCompleteness.Node(1);
		root.right = n2;
		n2.right = n3;
		n3.right = n4;
		n4.right = n5;
		n5.right = n6;
		BinTreeCompleteness tree = new BinTreeCompleteness(root);
		return tree;
	}

	BinTreeCompleteness createRootOnlyTree() {
		BinTreeCompleteness.Node root = new BinTreeCompleteness.Node(1);
		BinTreeCompleteness tree = new BinTreeCompleteness(root);
		return tree;
	}

	BinTreeCompleteness createCompleteTree() {
		BinTreeCompleteness.Node n4 = new BinTreeCompleteness.Node(4);
		BinTreeCompleteness.Node n5 = new BinTreeCompleteness.Node(5);
		BinTreeCompleteness.Node n6 = new BinTreeCompleteness.Node(6);
		BinTreeCompleteness.Node n7 = new BinTreeCompleteness.Node(7);
		BinTreeCompleteness.Node n2 = new BinTreeCompleteness.Node(2, n4, n5);
		BinTreeCompleteness.Node n3 = new BinTreeCompleteness.Node(3, n6, n7);
		BinTreeCompleteness.Node root = new BinTreeCompleteness.Node(1, n2, n3);
		BinTreeCompleteness tree = new BinTreeCompleteness(root);
		return tree;
	}

	BinTreeCompleteness createCompleteTree2() {
		BinTreeCompleteness.Node n4 = new BinTreeCompleteness.Node(4);
		BinTreeCompleteness.Node n5 = new BinTreeCompleteness.Node(5);
		BinTreeCompleteness.Node n6 = new BinTreeCompleteness.Node(6);
		BinTreeCompleteness.Node n7 = new BinTreeCompleteness.Node(7);
		BinTreeCompleteness.Node n2 = new BinTreeCompleteness.Node(2, n5, n4);
		BinTreeCompleteness.Node n3 = new BinTreeCompleteness.Node(3, n7, n6);
		BinTreeCompleteness.Node root = new BinTreeCompleteness.Node(1, n2, n3);
		BinTreeCompleteness tree = new BinTreeCompleteness(root);
		return tree;
	}

		
	@Test
	public void testHeight1() {
		BinTreeCompleteness tree = createTreeFromSheet();
		assertEquals(4, tree.height());
	}

	@Test
	public void testHeight2() {
		BinTreeCompleteness tree = createUnbalancedTree();
		assertEquals(6, tree.height());
	}
	
	@Test
	public void testHeight3() {
		BinTreeCompleteness tree = createUnbalancedTreeBackward();
		assertEquals(6, tree.height());
	}
	
	@Test
	public void testHeight4() {
		BinTreeCompleteness tree = createCompleteTree();
		assertEquals(3, tree.height());
	}
	
	@Test
	public void testHeight5() {
		BinTreeCompleteness tree = createRootOnlyTree();
		assertEquals(1, tree.height());
	}

	@Test
	public void testHeight6() {
		// empty tree
		BinTreeCompleteness tree = new BinTreeCompleteness();
		assertEquals(0, tree.height());
	}

		
	/*
	 *    TESTS FOR ISCOMPLETE ...
	 */
	
	/*
	 * two levels on one side, one on the other.
	 * 
	 * 1
	 * |_ 2
	 *    |_ 4
	 *    |_ 5
	 *    
	 * |_ 3
	 * 
	 */
	@Test
	public void testTreeComplete1() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		tree.root.left = new BinTreeCompleteness.Node(2);
		tree.root.right = new BinTreeCompleteness.Node(3);
		tree.root.left.left = new BinTreeCompleteness.Node(4);
		tree.root.left.right = new BinTreeCompleteness.Node(5);
		assertEquals(true,  tree.isCompleteOrAlmostComplete());
	}

	/*
	 * 
	 * both subtrees have the same depth and are almost complete.
	 * 
	 * 1
	 * |_ 2
	 *    |_ 4
	 *    
	 * |_ 3
	 *    |_ 5
	 * 
	 */
	@Test
	public void testTreeComplete2() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		tree.root.left = new BinTreeCompleteness.Node(2);
		tree.root.right = new BinTreeCompleteness.Node(3);
		tree.root.left.left = new BinTreeCompleteness.Node(4);
		tree.root.right.left= new BinTreeCompleteness.Node(5);
		assertEquals(true,  tree.isCompleteOrAlmostComplete());
	}
	
	/*
	 * 
	 * both subtrees have the same depth but are incomplete.
	 * 
	 * 1
	 * |_ 2
	 *    |_ 4
	 *    	 |_ 6
	 *    
	 * |_ 3
	 *    |_ 5
	 * 		 |_ 7
	 */
	@Test
	public void testTreeComplete3() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		tree.root.left = new BinTreeCompleteness.Node(2);
		tree.root.left.left = new BinTreeCompleteness.Node(4);
		tree.root.left.left.left = new BinTreeCompleteness.Node(6);
		tree.root.right = new BinTreeCompleteness.Node(3);
		tree.root.right.right= new BinTreeCompleteness.Node(5);
		tree.root.right.right.right = new BinTreeCompleteness.Node(7);
		assertEquals(false,  tree.isCompleteOrAlmostComplete());
	}


	/*
	 * 
	 * root only.
	 * 
	 */
	@Test
	public void testTreeComplete4() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		assertEquals(true,  tree.isCompleteOrAlmostComplete());
	}
	

	/*
	 * 
	 * empty.
	 * 
	 */
	@Test
	public void testTreeComplete5() {
		BinTreeCompleteness tree = new BinTreeCompleteness();
		assertEquals(true,  tree.isCompleteOrAlmostComplete());
	}

	/*
	 * 
	 * root + one child.
	 * 
	 */
	@Test
	public void testTreeComplete6() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		tree.root.right = new BinTreeCompleteness.Node(2);
		assertEquals(true,  tree.isCompleteOrAlmostComplete());
	}
	
	/*
	 * 
	 * left tree 1 level flatter, both incomplete.
	 * 
	 */
	@Test
	public void testTreeComplete7() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		tree.root.left = new BinTreeCompleteness.Node(1);
		tree.root.left.right = new BinTreeCompleteness.Node(1);
		tree.root.right = new BinTreeCompleteness.Node(1);
		tree.root.right.left = new BinTreeCompleteness.Node(1);
		tree.root.right.right = new BinTreeCompleteness.Node(1);
		tree.root.right.right.right = new BinTreeCompleteness.Node(1);
		assertEquals(false,  tree.isCompleteOrAlmostComplete());
	}

	
	public void addLevel(BinTreeCompleteness.Node n) {
		if (n.left==null && n.right==null) {
			n.left  = new BinTreeCompleteness.Node(1);
			n.right = new BinTreeCompleteness.Node(1);
		} else {
			addLevel(n.left);
			addLevel(n.right);
		}
	}

	/*
	 * 
	 * a big, almost complete tree with one gap 
	 * on the last two levels. -> incomplete!
	 * 
	 */
	@Test
	public void testTreeComplete8() {
		BinTreeCompleteness tree = new BinTreeCompleteness(new BinTreeCompleteness.Node(1));
		addLevel(tree.root);
		addLevel(tree.root);
		addLevel(tree.root);
		addLevel(tree.root);
		addLevel(tree.root);
		addLevel(tree.root);
		tree.root.left.right.left.right.left = null;
		assertEquals(false,  tree.isCompleteOrAlmostComplete());
	}

}
