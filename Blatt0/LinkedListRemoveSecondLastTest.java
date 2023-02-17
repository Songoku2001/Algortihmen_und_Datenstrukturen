
package ads.Blatt0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListRemoveSecondLastTest {

	static LinkedListRemoveSecondLast l;
	
	public static void runTest(int[] a) {
		// generate a list containing a's elements 
		// (in the same order)
		l = new LinkedListRemoveSecondLast();
		for (int i=a.length-1; i>=0; --i)
			l.addFirst(a[i]);
		// call target method
		l.removeSecondLast();
		// check if l's values match the values in a 
		// (when ignoring the second last one).
		LinkedListRemoveSecondLast.Node n = l.head.next;
		int count = a.length==2 ? 1 : 0;
		while (n != l.tail) {
			assertEquals(a[count], n.obj);
			n = n.next;
			count += count==a.length-3? 2 : 1;
		}
		// check that list does not contain any extra elements.
		assertEquals(count, a.length);
	}

	@Test
	public void test1() {
		runTest(new int[] {1,2,3,4});
	}

	@Test
	public void test2() {
		runTest(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18});
	}

	@Test
	public void test3() {
		runTest(new int[] {4,4,4,4,4,4});
	}

	@Test
	public void test4() {
		runTest(new int[] {});
	}

	@Test
	public void test5() {
		runTest(new int[] {17});
	}

	@Test
	public void test6() {
		runTest(new int[] {17,42});
		l.print();
	}

}
