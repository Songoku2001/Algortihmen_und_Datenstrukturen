package ads.Blatt3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TernarySearchTest {
	
  @Test
  public void testSmall() {
    int[] a;
    a = new int[] {1};
    assertEquals("For the array a=[1], ternarySearch(a, 2) should return -1!", 
      TernarySearch.ternarySearch(a, 2), -1);
    assertEquals("For the array a=[1], ternarySearch(a, 1) should return 0!", 
      TernarySearch.ternarySearch(a, 1), 0);
    a = new int[] {1,2};
    assertEquals("For the array a=[1,2], ternarySearch(a, 5) should return -1!", 
      TernarySearch.ternarySearch(a, 5), -1);
    assertEquals("For the array a=[1,2], ternarySearch(a, 2) should return 1!", 
      TernarySearch.ternarySearch(a, 2), 1);
    a = new int[] {1,2,3};
    assertEquals("For the array a=[1,2,3], ternarySearch(a, 5) should return -1!", 
      TernarySearch.ternarySearch(a, 5), -1);
    assertEquals("For the array a=[1,2,3], ternarySearch(a, 2) should return 1!", 
      TernarySearch.ternarySearch(a, 2), 1);
  }
	
  @Test
  public void testFirst() {
    int[] a;
    a = new int[] {1,2,3,4,5,6,7,8,9,10};
    assertEquals("For the array a=[1,2,3,4,5,6,7,8,9,10], ternarySearch(a, 1) should return 0!", 
      TernarySearch.ternarySearch(a, 1), 0);
  }

  @Test
  public void testGap() {
    int[] a;
    a = new int[] {1,2,3,4,5,6,8,9,10};
    assertEquals("For the array a=[1,2,3,4,5,6,8,9,10], ternarySearch(a, 7) should return -1!", 
      TernarySearch.ternarySearch(a, 7), -1);
  }

  @Test
  public void testDup() {
    int[] a;
    a = new int[] {1,2,2,2,2,2,2,2,2};
    assertTrue("For the array a=[1,2,2,2,2,2,2,2,2]], ternarySearch(a, 2) should return a value > 0!", 
      TernarySearch.ternarySearch(a, 2) > 0);
    assertEquals("For the array a=[1,2,2,2,2,2,2,2,2]], ternarySearch(a, 3) should return -1!", 
      TernarySearch.ternarySearch(a, 3), -1);
  }
}