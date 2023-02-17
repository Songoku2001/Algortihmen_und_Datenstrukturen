package ads.Blatt8;

public class DLinkedList {

	class Node {
		Node next;
		Node prev;
		int obj;

		@Override
		public String toString() {
			if (next==null) {
			return Integer.toString(obj);
			}
			else {
				return obj + " -> " + next;
			}
		}
	}
	
	Node head, tail;
	
	public DLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		/*
		head.prev = null;
		tail.next = null;
		*/
	}

	int length() {
		int count=0;
		 var n = head.next;

		 while(n!=tail) {
		 	count++;
		 	n = n.next;
		 }
		 return count;
	}
		
	public void addLast(int t) {
		Node n = new Node();    	 //neuen Node erstellen
		n.obj = t;                //dann auf das neue node dem Objekt zuweisen
		Node tmp = tail.prev;    //tmp ist der letzte knoten mite einem obj
		n.next = tail;				  //neuer knoten zeigt auf den letzten knoten
		n.prev = tmp;					 //neuer knoten zeigt auf dem vorletzten knoten
		tail.prev = n;			  //letzte knoten zeigt auf den neuen letzten knoten mit obj
		tmp.next = n;				 //der vorletzte zeigt nun auf dem letzten knoten mit obj
	}
	
	public void zip(DLinkedList other) {
		var thistmp = this.head.next; //zeigt auf das erste elemt
		var othertmp=other.head.next;//zeigt auf das erste element der other liste

		while (thistmp.next!=null||othertmp.next!=null) {

			var thisreferenz = thistmp.next;//3
			var otherreferenz = othertmp.next;//4

			thistmp.next = othertmp;//1->2
			othertmp.prev = thistmp;//1<-2 neu

			othertmp.next = thisreferenz;//2->3
			thisreferenz.prev = othertmp;//2<-3 neu

			thistmp = thisreferenz;//1 wird zu 3
			othertmp = otherreferenz;//2 wird zu 4

			while (thistmp.next!=null && othertmp.next==null) {//wenn die this liste größer ist
				thistmp = thistmp.next;
			}

			if (thistmp.next==null && othertmp.next!=null) {//wenn die that liste größer ist
				var x = othertmp;
				othertmp=thistmp;
				thistmp = x;
			}
		}
	}


	public DLinkedList selectionSort() {
		var result = new DLinkedList();
		var tmp = this.head;
		var nexttmp = this.head;
		var length = this.head;

		while (length.next!=tail) {
			tmp=length.next;
			nexttmp=length.next.next;

			while (nexttmp.next!=null) {
				if (tmp.obj>nexttmp.obj) {
					tmp=nexttmp;
				}
				nexttmp=nexttmp.next;
			}

			tmp.prev.next=tmp.next;
			tmp.next.prev=tmp.prev;

			result.addLast(tmp.obj);
		}
		return result;
	}

	public static void main(String[] args) {
		DLinkedList t1 = new DLinkedList();
		t1.addLast(1);//1->3->5
		t1.addLast(3);
		t1.addLast(5);

		DLinkedList t2 = new DLinkedList();
		t2.addLast(2);//2->4->6
		t2.addLast(4);
		t2.addLast(6);
		t2.addLast(8);
		t2.addLast(10);
//1->2->3->4
		t1.zip(t2);

		//t1.selectionSort();

		Node n = t1.head.next;
		while (n != t1.tail) {
			System.out.println(n.obj);
			n = n.next;
		}
	}
}
