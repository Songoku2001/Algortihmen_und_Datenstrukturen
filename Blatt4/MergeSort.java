package ads.Blatt4;

import java.util.Random;

class MergeSort {

	// buffer for merge operation.
	int[] b;

	public void sort(int[] a) {
		merge(a, 0, a.length-1);
	}

	public void merge(int[] a,int left, int right) {
		if (left>=right) return;
		int m = left + (left+right)/2; // [1, 2, 3, 4] --> [1, 2] [3, 4] --> [1] [2] --> [3] [4]
		System.out.println(m); //                      m=2            m=1

		merge(a, left, m);
		merge(a, m+1, right);
		mergea(a, left,m, right);
	}

	private void mergea(int []a, int l, int m, int r) {
		int[] b = new int[a.length];
		int i;
		int j;

		for (i = l; i <= m; i++) { //Laufen bis zum mitte des arrays
			b[i] = a[i];
		}
		
		for (j = m+1; j <= r; j++) { //Laufen von mitte bis ende des arrays
			b[r + m+1 - j] = a[j];
			//rechter Teil + die mitte - die mitte (wird auf addiert)
		}

		i = l;
		j = r;
		for (int k = l; k <= r; k++) {
			if (b[i] <= b[j]) {
				a[k] = b[i++];
			}
			else {
				a[k] = b[j--];
			}
		}
	}

	public static void swap(int[] a, int pos1, int pos2) {
		int tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
	}

	// always the same pseudo random numbers!
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
		MergeSort sort = new MergeSort();
		startTime = System.currentTimeMillis();
		sort.sort(a);
		endTime = System.currentTimeMillis();
		System.out.format(
				"[n=%d] : %d ms.\n",
				n, (endTime - startTime));
	}

	public static void main(String[] args) {
		int [] c = {3, 4, 5, 2};
		MergeSort m = new MergeSort();
		m.merge(c, 0, c.length-1);
		/*for (int i=0;i<c.length;i++) {
			System.out.println(c[i]);*/
		}
	}


