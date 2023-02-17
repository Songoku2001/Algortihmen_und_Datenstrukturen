package ads.Blatt5;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArrayQueue<T> {

	private int init_capacity;
	private double resize_factor;
	T[] a;
	int start,end;


	public DynamicArrayQueue(int init_capacity,
            				 double resize_factor) {
		this.init_capacity = init_capacity;
		this.resize_factor = resize_factor;

		a = (T[]) new Object[init_capacity];
		start = 0;
		end = -1;

	}

	@Override
	public String toString() {
		return "DynamicArrayQueue{" +
						"init_capacity=" + init_capacity +
						", resize_factor=" + resize_factor +
						", a=" + Arrays.toString(a) +
						", start=" + start +
						", end=" + end +
						'}';
	}

	public void push(T e) {

		if (end==a.length-1) {
			T[] b = (T[]) new Object[(int) (init_capacity * resize_factor)];
			System.arraycopy(a, 0, b, 0, a.length);

 			init_capacity=b.length;
			end = a.length-1;
			a=b;
		}
		a[++end] = e;
	}

	public boolean isEmpty() {
		return a[0] == null;
	}

	public T top() throws NoSuchElementException {
		if (!isEmpty()) {
			return a[start];
		}
		throw new NoSuchElementException();
	}

	public void pop() throws NoSuchElementException {
		if (!isEmpty()) {

			T[] b = (T[]) new Object[(int) (a.length)];
			System.arraycopy(a, 1, b, 0, end);
			a=b;
			end--;
		} else {
			throw new NoSuchElementException();
		}
	}

	public static void main(String[] args) {
		DynamicArrayQueue<Integer> array = new DynamicArrayQueue<Integer>(2, 2);

		array.push(1);
		array.push(2);
		//array.push(3);
		array.pop();
		System.out.println(array);

	}

}
