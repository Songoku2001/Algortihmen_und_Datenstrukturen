package ads.Blatt10.Projekt.Aufgabe2;
//13
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class SpellCorrector {

	static class Entry {

		String reducedWord;
		String origWord;

		public Entry(String changedWord, String origWord) {
			this.reducedWord = changedWord;
			this.origWord = origWord;
		}

		// how many letters have been removed?
		public int nchanged() {
			return origWord.length() - reducedWord.length();
		}

	}

	// Die Anzahl durchzuführender Reduktionen jedes Wortes
	int K;
	// Die Größe der internen Hash-Tabelle
	int N;
	// Die Basis der Hashfunktion der internen Hash-Tabelle
	int basis;

	Hashtable<String, List<String>> hashtable = new Hashtable<>();

	public SpellCorrector(int K, int N, int basis) {
		this.K = K;
		this.N = N;
		this.basis = basis;
	}


	public void add(String word) {
		List<Entry> x = generate(word, K);
		add(word, hashtable, x);
	}


	private Hashtable<String, List<String>> add(String word, Hashtable<String, List<String>> hashtable, List<Entry> x) {

		for (int i=0; i<x.size(); i++) {
			if (hashtable.containsKey(x.get(i).reducedWord)) {
				List<String> list = hashtable.get(x.get(i).reducedWord);
				list.add(word);
			}
			else {
				List<String> newlist = new LinkedList<>();
				newlist.add(word);
				hashtable.put(x.get(i).reducedWord, newlist);
			}
		}
		return hashtable;
	}


	public List<Entry> generate(String word, int K) {
		List<Entry> result = new LinkedList<>();
		Hashtable<String, String> hashtable = new Hashtable<>();

		generate(word, K, hashtable, word);
		hashtable.forEach((x, y)-> result.add(new Entry(x, y)));

		return result;
	}

	private void generate(String word, int K, Hashtable<String, String> result, String originalword) {
		StringBuilder changeword;

		if (K>=0) {
			result.put(word, originalword);
			for (int i=0; i<word.length(); i++) {
				changeword = new StringBuilder(word);
				changeword.deleteCharAt(i);
				generate(changeword.toString(), K-1 ,result, originalword);
			}
		}
	}


	public List<String> match(String query) {
		List<Entry> entries = generate(query, K);
		List<String> result = new LinkedList<>();
		int newdistance=Integer.MAX_VALUE;

		match(entries, result, hashtable,newdistance,query);
		return result;
	}

	private void match(List<Entry> entries, List<String> result, Hashtable<String, List<String>> hashtable, int newdistance, String query) {
		List<String> newlist = new LinkedList<>();

		for (Entry entry : entries) {
			if (hashtable.containsKey(entry.reducedWord)) {
				List<String> stringList = hashtable.get(entry.reducedWord);

				for (int j=0; j<hashtable.get(entry.reducedWord).size(); j++) {
					int leftformel = query.length() - entry.reducedWord.length();
					int rightformel = stringList.get(j).length() - entry.reducedWord.length();
					int distance = leftformel + rightformel;

					if (distance < newdistance) {
						newdistance = distance;
						newlist = new LinkedList<>();
						newlist.add(stringList.get(j));
					}
					if (!newlist.contains(stringList.get(j)) && distance == newdistance) {
						newlist.add(stringList.get(j));
					}
				}

			}
		}
		result.addAll(newlist);
	}


	public static void main(String[] args) {

	/*
		SpellCorrector test2 = new SpellCorrector(2, 101, 10);
		List<SpellCorrector.Entry> actual2 = test2.generate("abc", test2.K);


		SpellCorrector.Entry[] expected2 = new SpellCorrector.Entry[] {
						new SpellCorrector.Entry("a", "abc"),
						new SpellCorrector.Entry("b", "abc"),
						new SpellCorrector.Entry("c", "abc"),
						new SpellCorrector.Entry("ab", "abc"),
						new SpellCorrector.Entry("ac", "abc"),
						new SpellCorrector.Entry("bc", "abc"),
						new SpellCorrector.Entry("abc", "abc"),
		};
/*
		for (Entry entry : actual2) {
			System.out.println("actual2 = " + entry.reducedWord +", " + entry.origWord);
		}


		/*----------------------------------------------------------------------------------------*/

		SpellCorrector test2 = new SpellCorrector(2, 101, 10);
		test2.match("abc");
		test2.add("abc");

		SpellCorrector.Entry[] expected2 = new SpellCorrector.Entry[] {
						new SpellCorrector.Entry("a", "abc"),
						new SpellCorrector.Entry("b", "abc"),
						new SpellCorrector.Entry("c", "abc"),
						new SpellCorrector.Entry("ab", "abc"),
						new SpellCorrector.Entry("ac", "abc"),
						new SpellCorrector.Entry("bc", "abc"),
						new SpellCorrector.Entry("abc", "abc"),
		};



		/*----------------------------------------------------------------------------------------*/


/*
		String test = "test";

		char[] t = test.toCharArray();
		t[1] = Character.MIN_VALUE;
		String result = "";
		result +=t[0];
		result +=t[2];
		result +=t[3];
		System.out.println(result);
		 */

/*
		StringBuilder s = new StringBuilder(test);
		s.deleteCharAt(1);

		System.out.println(s);

 */

	}

}