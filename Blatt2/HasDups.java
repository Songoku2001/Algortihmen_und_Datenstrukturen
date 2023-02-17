package ads.Blatt2;

public class HasDups {

	  static boolean hasDups(int[] xs) {
	    for (int i=0; i<xs.length; i++) {
	    	if (linearSearch(xs, i, xs[i])) {
	    		return true;
				}
			}
	    return false;
	  }

	  private static boolean linearSearch(int[] xs, int start, int v) {
	  	var j = start;
	  	while (j<xs.length) {
	  		if (xs[j]== v){
	  			return true;
				}
	  		j =j+1;
			}
	    return false;
	  }

	  static boolean hasDupsFaster(int[] xs) {
	    return false;
	  }


	  // as requested on the exercise sheet, we
	  // run a duplicate check and record runtime.
	  public static void runTest(int[] xs) {
		boolean result;
		long startTime;
		long endTime;

		// run slow version
		startTime = System.currentTimeMillis();
		result = hasDups(xs);
		endTime = System.currentTimeMillis();
		System.out.format(
				"[QUADRATIC] %d values: %d ms. Found duplicate? %b\n",
				xs.length, (endTime - startTime), result);

		// run fast version
		startTime = System.currentTimeMillis();
		result = hasDupsFaster(xs);
		endTime = System.currentTimeMillis();
		System.out.format(
				"[LINEAR] %d values: %d ms. Found duplicate? %b\n",
				xs.length, (endTime - startTime), result);
	  }
	
}