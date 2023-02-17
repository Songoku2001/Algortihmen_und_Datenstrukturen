package ads.Blatt0;

import java.util.Stack;

public class StackSort {
	
	public static void quicksort(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}
		int pivot = stack.pop();
		Stack<Integer> kleiner_pivot = new Stack<>();
		Stack<Integer> groesser_gleich_pivot = new Stack<>();

		for (int i=0; i<stack.size();) {
			var element = stack.pop();

			if (element<pivot) {
				kleiner_pivot.push(element);
			}
			else {
				groesser_gleich_pivot.push(element);
			}
		}
		quicksort(kleiner_pivot);
		quicksort(groesser_gleich_pivot);

		for (int i=0; i<groesser_gleich_pivot.size();) {
			stack.push(groesser_gleich_pivot.pop());
		}
		stack.push(pivot);
		for (int i=0; i<kleiner_pivot.size();) {
			stack.push(kleiner_pivot.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		while (!s.empty()) {
			System.out.println(s.pop());
		}
		System.out.println("nach quicksort:");
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		quicksort(s);
		// Sollte 1,2,3,4 ausgeben.
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}

}
	
	
