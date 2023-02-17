public class LinkedList<T> {

  private Node head;
  private Node tail;

  private class Node {
    T obj;
    Node next;

    public Node(T obj) {
      this.obj = obj;
    }
    public Node() {
    }

  }


  public LinkedList() {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.next = null;
  }

  public T getFirst() {
    if (head == null) {
      System.out.println("list ist leer");
    }
    return head.next.obj;
  }

  public void addFirst(T t) {
    Node n = new Node(t);
    n.next = head;
    head = n;
  }

  public void addLast(T t) {
    if (head == null) {
      addFirst(t);
    }
    Node last = head;
    while (last.next != tail) {
      last = last.next;
    }
    Node n = new Node(t);
    last.next = n;
    n.next = tail;

  }

  public T getLast(){
    Node last = head;
    while (last.next != tail){
      last=last.next;
    }
    return last.obj;
  }

  public void removeFirst(){
    head.next = head.next.next;
  }

  public int size(){
    int size = 0;
    Node n = head;
    while(n.next != tail){
      n = n.next;
      size++;
    }
    return size;
  }

  public void insert(int index, T y) {
    if (index >= this.size()) {return;}
    if (index<0){return;}

    Node n = this.head;
    int i=0;
    while(i<index){
      n = n.next;
      i++;
    }

    Node newNode = new Node(y);
    newNode.next = n.next;
    n.next = newNode;

  }

  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.addLast("G");  //index 0
    linkedList.addLast("o");
    linkedList.addLast("k");
    linkedList.addLast("u");
    //System.out.println(linkedList.size());

    //System.out.println(linkedList.getLast());
    linkedList.insert(0, "goku");
    //System.out.println(linkedList.head.next.obj);

    /*****   Iterieren ueber die ganze Liste   *****/
    while(linkedList.head.next != linkedList.tail){
      linkedList.head = linkedList.head.next;
      System.out.println(linkedList.head.obj);
    }

  }
}