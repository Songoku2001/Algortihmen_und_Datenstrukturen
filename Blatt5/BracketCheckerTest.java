
package ads.Blatt5;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BracketCheckerTest {

	static int init_capacity = 10;
	static double resize_factor = 1.5;
	static int EXCEPTION = -666;

	private static void checkSize(int expected, 
            BracketChecker.ArrayStack<Integer> s) {
		assertEquals(expected, s.size());
	}
	
	private static void checkTop(int expected, 
            BracketChecker.ArrayStack<Integer> s) {
		int x = -1;
		try {
			x = s.top();
		} catch(NoSuchElementException e) {
			x = EXCEPTION;
		}
		assertEquals(expected, x);
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testStack1() {
		BracketChecker.ArrayStack<Integer> s = 
				new BracketChecker.ArrayStack<Integer>(10);
		s.push(1);
		s.push(2);
		s.push(3);
		checkTop(3, s);
		s.pop();
		checkTop(2, s);
		s.pop();
		checkTop(1, s);
		s.push(4);
		checkTop(4, s);
		s.pop();
		checkTop(1, s);
		s.pop();
		checkTop(EXCEPTION, s);
		// should throw exception (stack is empty)
		s.pop();
	}
		
	@Test
	public void testBracketChecker1() {
		// correct brackets
		String s = "(13 + 27 * (3 - (4+1)))";
		assertTrue( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker2() {
		// no brackets -> correct
		String s = "87326csdnvjdk";
		assertTrue( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker3() {
		// brackets not matching
		String s = "1(2}3";
		assertFalse( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker4() {
		// too many closing brackets 
		String s = "((xxx)))";
		assertFalse( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker5() {
		// not enough closing brackets
		String s = "(((xxx))";
		assertFalse( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker6() {
		// multiple top-levels
		String s = "()()()()(())";
		assertTrue( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker7() {
		// multiple lines
		String s = "()()()\npublic static void foo(int c)\n { String s = 's'; }";
		assertTrue( BracketChecker.check(s, init_capacity) );
	}
	
	@Test
	public void testBracketChecker8() {
		// multiple lines
		String s = "()()()\npublic static void foo((int c)\n { String s = 's'; }";
		assertFalse( BracketChecker.check(s, init_capacity) );
	}

}
