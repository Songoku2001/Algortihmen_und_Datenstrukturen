package ads.Blatt10.Projekt.Aufgabe1;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class HashMap<T> {

	public class Entry {
		String key;
		T value;

		public Entry(String key, T value) {
			this.key = key;
			this.value = value;
		}
	}

	// the hash table
	Entry[] table;

	// size of the hash table
	int N;

	// used to hash strings with the Horner schema.
	int basis;

	public HashMap(int N, int basis) {
		table = (Entry[]) Array.newInstance(Entry[].class.getComponentType(), N);
		this.basis = basis;
		this.N = N;
	}

	/**Done**/
	public int size() {
		int count = 0;

		for (int i=0; i<N; i++) {
			if (table[i]!=null) {
				count++;
			}
		}
		return count;
	}

	/**Done**/
	public double fillRatio() {
		return (double) this.size()/N;
	}

	/**Done**/
	List<T> toList() {
		LinkedList<T> result = new LinkedList<>();

		for (int i=0; i<N; i++) {
			if (table[i]!=null) {
				result.add(table[i].value);
			}
		}
		return result;
	}

	/**Done**/
	public int hashcode(String key) {
		int value=0;

		for (int i=0; i<key.length(); i++) {
			value=(value*basis+key.charAt(i))%N;
		}
		return value;
	}

	/**Done**/
	public T get(String key) {
		int z=hashcode(key);

		for (int i=0; i<N; i++) {
			if (key.equals(table[z].key) && table[z]!=null) {
				return table[z].value;
			}

			z = (z+2*(i)+1)%N;
		}
		return null;
	}

	/**Done**/
	public boolean add(String key, T value) {
		int z=hashcode(key);

		for (int i=0; i<N; i++) {
			if (table[z]==null || key.equals(table[z].key)) {
				table[z]=new Entry(key, value);
				return true;
			}
			z=(z+2*(i)+1)%N;
		}

		return false;
	}
}

