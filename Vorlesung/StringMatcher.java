package ads.Vorlesung;

public class StringMatcher {

	// n = Länge des Referenzstrings s
	// m = Länge des Patterns
	
	// Best Case: Pattern vorhanden -> O(m)
	//  (pattern an pos=0 checken, fertig)
	
	// Worst Case: s = aaaaaaaaaaaaaaaaa, pattern = aaaaaaaab
	// O( (n-m) * m ) = O( n*m - m*m ) 
	
	// if pattern is in s: return first position of pattern in s.
	// if pattern is not in s: return -1.
	static int match(String sarg, String patternarg) {
		char[] s = sarg.toCharArray();
		char[] pattern = patternarg.toCharArray();
		
		for (int pos=0; pos<=s.length-pattern.length; ++pos) { // O(n-m)
			// Check if s[pos,...] = pattern[0,...]
			boolean success = true;
			for (int j=0; j<pattern.length; ++j) {   // O(m)
				if (s[pos+j]!=pattern[j]) {
					success = false;
					break;
				}
			}
			if (success) {
				return pos;
			}
		}
		return -1; // pattern not present in s
	}
	
	// s = 'abcdefghijklm'
    //           ^           (pos=5)
	// pattern = 'fgh'
	public static void main(String[] args) {
		System.out.println(match("ADS ist toll!", "doof!!"));
	}
	
}
