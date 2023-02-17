
package ads.Blatt7.Projekt.Aufgabe3;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class LogicSolverBacktrackingTest {

	// ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
	short[][] formula1 = new short[][] {
		{ -1, -1,  0, 0 },
		{ 0,  1, -1, 0 },
		{ 0,  0,  1, 1 }
	};
		
	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 )
	short[][] formula2 = new short[][] {
		{ -1, -1 },
		{ -1,  1 },
		{  1, -1 },
	};

	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
	short[][] formula3 = new short[][] {
		{ -1, -1 },
		{ -1,  1 },
		{  1, -1 },
		{  1,  1 },
	};

	// ( -X1 v -X2 ) ^ X1
	short[][] formula4 = new short[][] {
		{ -1, -1 },
		{  1,  0 },
	};

	// X6
	short[][] formula5 = new short[][] {
		{ 0, 0, 0, 1 },
	};


	// ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
	@Test
	public void testBacktracking1() {
		short[] result = LogicSolverBacktracking.solveBacktracking(formula1);
		assertTrue( Arrays.equals(new short[] {-1,-1,-1,1}, result) );
	}

	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 )
	@Test
	public void testBacktracking2() {
		short[] result = LogicSolverBacktracking.solveBacktracking(formula2);
		assertTrue( Arrays.equals(new short[] {-1,-1}, result) );
	}
	
	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
	@Test
	public void testBacktracking3() {
		short[] result = LogicSolverBacktracking.solveBacktracking(formula3);
		assertTrue( Arrays.equals(new short[] {0,0}, result) );
	}

	// ( -X1 v -X2 ) ^ X1
	@Test
	public void testBacktracking4() {
		short[] result = LogicSolverBacktracking.solveBacktracking(formula4);
		assertTrue( Arrays.equals(new short[] {1,-1}, result) );
	}

	// X4 (nur X4)
	@Test
	public void testBacktracking5() {
		short[] result = LogicSolverBacktracking.solveBacktracking(formula5);
		assertTrue( Arrays.equals(new short[] {-1,-1,-1,1}, result) );
	}
	
}
