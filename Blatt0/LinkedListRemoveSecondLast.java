package ads.Blatt0;

public class LinkedListRemoveSecondLast {

	class Node {
		Node next;
		int obj;
	}
	
	Node head, tail;
	
	public LinkedListRemoveSecondLast() {
		head = new Node();
		tail = new Node();
		head.next = tail;
	}
		
	public void addFirst(int t) {
		Node n = new Node();
		n.obj = t;
		n.next = head.next;
		head.next = n;
	}
	
	// prints the list to stout
	public void print() {
		Node n = head.next;
		while (n != tail) {
			System.out.println("> " + String.valueOf(n.obj));
			n = n.next;
		}
		System.out.println();
	}
	
	public void removeSecondLast() {
		Node letzter_knoten = head;
		Node vorletzter_knoten = head;
		Node n = head;

		//  head zeigt auf tail || das erste elemnt zeigt auf teil
		if (head.next == tail || head.next.next == tail) {
			return;
		}

		while(letzter_knoten.next!=tail) {
			letzter_knoten = letzter_knoten.next;
		}
		while(vorletzter_knoten.next != letzter_knoten) {
			vorletzter_knoten = vorletzter_knoten.next;
		}
		while(n.next != vorletzter_knoten) {
			n = n.next;
		}
		n.next = letzter_knoten;

	}
	
	public static void main(String[] args) {
		LinkedListRemoveSecondLast l = new LinkedListRemoveSecondLast();
		l.addFirst(5);
		l.addFirst(1);
		l.addFirst(4);
		l.addFirst(3);
		l.addFirst(2);
		l.print(); // should be: 2 3 4 1 5
		l.removeSecondLast();
		l.print(); // should be: 2 3 4 5
	}
	
}
