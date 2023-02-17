
package ads.Blatt5;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DynamicArrayQueueTest {

	static int init_capacity = 10;
	static double resize_factor = 1.5;
	static int EXCEPTION = -666;

	private static void checkCapacity(int expected, 
			                          DynamicArrayQueue<Integer> q) {
		Object[] a = (Object[])q.a;
		assertEquals(expected, a.length);
	}
	
	private static void checkSize(int expected, 
            					  DynamicArrayQueue<Integer> q) {
		assertEquals(expected, q.start==-1 ? 0 : q.end-q.start+1);
	}
	
	private static void checkTop(int expected, 
            					 DynamicArrayQueue<Integer> q) {
		int x = -1;
		try {
			x = q.top();
		} catch(NoSuchElementException e) {
			x = EXCEPTION;
		}
		assertEquals(expected, x);
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testQueue1() {
		DynamicArrayQueue<Integer> q = new DynamicArrayQueue<Integer>(4, 1.5);
		checkCapacity(4, q);
		checkSize(0, q);
		q.push(1);
		checkCapacity(4, q);
		checkSize(1, q);
		checkTop(1, q);
		q.push(2);
		checkCapacity(4, q);
		checkSize(2, q);
		checkTop(1, q);
		q.push(3);
		checkCapacity(4, q);
		checkSize(3, q);
		checkTop(1, q);
		q.pop();
		checkCapacity(4, q);
		checkSize(2, q);
		checkTop(2, q);
		q.pop();
		checkCapacity(4, q);
		checkSize(1, q);
		checkTop(3, q);
		q.pop();
		checkCapacity(4, q);
		checkSize(0, q);
		q.top(); // should throw exception (queue is empty)
	}

	@Test (expected = NoSuchElementException.class)
	public void testQueue2() {
		DynamicArrayQueue<Integer> q = new DynamicArrayQueue<Integer>(4, 1.5);
		q.push(2);
		q.pop();
		// check cannot pop empty queue
		q.pop();
	}
	
	
	@Test
	public void testQueue3() {
		// checks that stuff still works when resizing
		DynamicArrayQueue<Integer> q = new DynamicArrayQueue<Integer>(4, 1.5);
		checkCapacity(4, q);
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		checkCapacity(6, q);
		assertFalse(q.isEmpty());
		checkTop(1, q); q.pop();
		checkTop(2, q); q.pop();
		checkTop(3, q); q.pop();
		checkTop(4, q); q.pop();
		checkTop(5, q); q.pop();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testQueue4() {
		// checks that stuff still works when resizing
		DynamicArrayQueue<Integer> q = new DynamicArrayQueue<Integer>(4, 1.5);
		q.push(1);
		q.push(2);q.pop();
		q.push(3);q.pop();
		q.push(4);q.pop();
		q.push(5);q.pop();
		assertFalse(q.isEmpty());
		checkTop(5, q); q.pop();
		assertTrue(q.isEmpty());
	}
	
}	
	
