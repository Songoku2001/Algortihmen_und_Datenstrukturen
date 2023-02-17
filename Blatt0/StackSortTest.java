
package ads.Blatt0;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.extensions.TestDecorator;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class StackSortTest {

    private static void runTest(int[] a) {
    	// create two copies of a, 
    	// one sorted using Java's built-in sort,
    	// one using the sort algorithm to test.
    	Stack<Integer> s = new Stack<Integer>();
    	for (int i=a.length-1; i>=0; --i) {
    		s.push(a[i]);
    	}
    	int[] bcopy = new int[a.length];
    	System.arraycopy(a, 0, bcopy, 0, a.length);
		StackSort.quicksort(s);
		assertEquals( a.length, s.size() );
    	int[] acopy = new int[a.length];
    	for (int i=0; i<a.length; ++i) {
    		acopy[i] = s.pop();
    	}
    	Arrays.sort(bcopy);
    	assertTrue(Arrays.equals(acopy, bcopy));
    }
    
	@Test
	public void test1() {
		int[] a = new int[] {7};
		runTest(a);
	}
	
	@Test
	public void test2() {
		int[] a = new int[] {-3, -8, 1, -4};
		runTest(a);
	}

	@Test
	public void test3() {
		int[] a = new int[] {1, 2, 3, 4, 5};
		runTest(a);
	}

	@Test
	public void test4() {
		int[] a = new int[] {5, 4, 3, 2, 1};
		runTest(a);
	}

	@Test
	public void test6() {
		int[] a = new int[] {1,8,1,8,2,6,2,6};
		runTest(a);
	}

	@Test
	public void test7() {
		int[] a = new int[] {5,6,7,8,1,2,3,4};
		runTest(a);
	}

	@Test
	public void test8() {
		int[] a = new int[] {};
		runTest(a);
	}

}
