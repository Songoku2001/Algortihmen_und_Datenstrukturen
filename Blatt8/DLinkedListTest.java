package ads.Blatt8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DLinkedListTest {

	static DLinkedList l;
	static DLinkedList l2;
	
	@Before
	public void setup() {
		l = new DLinkedList();
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l2 = new DLinkedList();
		l2.addLast(4);
		l2.addLast(5);
		l2.addLast(6);
	}
	
	public static int length(DLinkedList l) {
		DLinkedList.Node n = l.head;
		int count = 0;
		while (n.next != l.tail) {
			count++;
			n = n.next;
		}
		return count;
	}

	public static void check(DLinkedList l,
			                 int[] expected) {
		assertEquals(expected.length, length(l));
		DLinkedList.Node n = l.head.next;
		int i = 0;
		while ( n != l.tail ) {
			assertEquals(expected[i], (int)n.obj);
			n = n.next;
			++i;
		}
	}
	
	@Test
	public void testAddLast1() {
		l.addLast(4);
		check(l, new int[] {1,2,3,4});
	}

	@Test
	public void testAddLast2() {
		l.addLast(3);
		check(l, new int[] {1,2,3,3});
	}

	@Test
	public void testAddLast3() {
		l = new DLinkedList();
		l.addLast(1);
		check(l, new int[] {1});
	}

	@Test
	public void testZip1() {
		l.zip(l2);
		check(l, new int[] {1,4,2,5,3,6});
	}

	@Test
	public void testZip2() {
		l.addLast(7);
		l.addLast(8);
		l.addLast(9);
		l.zip(l2);
		check(l, new int[] {1,4,2,5,3,6,7,8,9});
	}

	@Test
	public void testZip3() {
		l2.addLast(7);
		l2.addLast(8);
		l2.addLast(9);
		l.zip(l2);
		check(l, new int[] {1,4,2,5,3,6,7,8,9});
	}

	@Test
	public void testZip4() {
		l = new DLinkedList();
		l.zip(l2);
		check(l, new int[] {4,5,6});
	}

	@Test
	public void testZip5() {
		l2 = new DLinkedList();
		l.zip(l2);
		check(l, new int[] {1,2,3});
	}

	@Test
	public void testSort1() {
		l = new DLinkedList();
		l.addLast(5);
		l.addLast(2);
		l.addLast(3);
		l.addLast(1);
		l.addLast(4);
		l2 = l.selectionSort();
		check(l2, new int[] {1,2,3,4,5});
		// original list should be empty (all nodes removed)
		assertTrue( l.head.next == l.tail );
	}

	@Test
	public void testSort2() {
		l = new DLinkedList();
		l2 = l.selectionSort();
		check(l2, new int[] {});
		// original list should be empty (all nodes removed)
		assertTrue( l.head.next == l.tail );
	}

	@Test
	public void testSort3() {
		l = new DLinkedList();
		l.addLast(7);
		l.addLast(6);
		l.addLast(5);
		l.addLast(4);
		l.addLast(3);
		l.addLast(2);
		l.addLast(1);
		l2 = l.selectionSort();
		check(l2, new int[] {1,2,3,4,5,6,7});
		// original list should be empty (all nodes removed)
		assertTrue( l.head.next == l.tail );
	}

	public void testSort4() {
		l = new DLinkedList();
		l.addLast(4);
		l.addLast(4);
		l.addLast(3);
		l.addLast(3);
		l.addLast(2);
		l.addLast(2);
		l.addLast(1);
		l.addLast(1);
		l2 = l.selectionSort();
		check(l2, new int[] {1,1,2,2,3,3,4,4});
		// original list should be empty (all nodes removed)
		assertTrue( l.head.next == l.tail );
	}

}
