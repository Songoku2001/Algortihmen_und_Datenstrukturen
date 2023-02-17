package ads.Blatt3;

import java.util.Random;

public class BobSort {
	
	public static void swap(int[] a, int pos1, int pos2) {
		int tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
	}
	
	public static void sort(int[] a) {
		for (int i=0; i<a.length;i++) {
			int tauschposition=0;

			for (int tausch=0; tausch<a.length; tausch++) {

				if (a[i] > a[tausch]) {
					tauschposition++;
				}

				if (tausch==a.length-1) {
					swap(a, i, tauschposition);
				}
			}
		}
	}
	
	// immer dieselben Pseudozufallszahlen!
	private static final Integer DEFAULT_SEED = Integer.valueOf(654321);

	public static int[] createRandomArray(int n) {
		int[] a = new int[n];
		for (int i=0; i<n; ++i) 
			a[i] = i;
		// shuffle randomly.
		Random rand = new Random(DEFAULT_SEED*n); 
		for (int i=0; i<n; ++i) {
			int pos = rand.nextInt(n);
			swap(a, i, pos);
		}
		return a;
	}
	
	public static void runTest(int n) {

		long startTime;
		long endTime;

		int[] a = createRandomArray(n);
		startTime = System.currentTimeMillis();
		sort(a);
		endTime = System.currentTimeMillis();
		System.out.format(
				"[n=%d] : %d ms.\n",
				n, (endTime - startTime));
	}
	
	public static void main(String[] args) {
		int [] a = {5, 4, 3, 2, 1, 3 ,4 ,5 ,6, 7, };
		BobSort.sort(a);
		for (int i=0; i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
}
