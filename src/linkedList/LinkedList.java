import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public int size() {
        return size;
    }

    public void printMiddle(){
        if (isEmpty())
            throw new IllegalArgumentException();

        var current = first;
        var middle = first;
        Node beforeMiddle = null;
        var count = 1;

        while (current.next != null) {
            current = current.next;
            if (count % 2 != 0) {
                beforeMiddle = middle;
                middle = middle.next;
            }
            count++;
        }

        if (count % 2 == 0) System.out.println(beforeMiddle.value);

        System.out.println(middle.value);
    }

    // O(1)
    public void addFirst(int value){
        var newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        size++;
    }

    // O(1)
    public void addLast(int value){
        var newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    // O(1)
    public void deleteFirst(){
        if (isEmpty())
            throw new NoSuchElementException();

        first = first.next;
        size--;
    }

    // O(n)
    public void deleteLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        if (isSingleNode()) {
            first = null;
        }

        var current = first;

        while (current.next != last){
            current = current.next;
        }

        last = current;
        last.next = null;
        size--;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public int indexOf(int value){
        int index = 0;
        Node current = first;

        while (current.next != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public int[] toArray(){
        var array = new int[size];
        var current = first;
        var index = 0;

        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    // first -> 10 -> 20 -> 30 -> 40 -> last
    // first -> 40 -> 30 -> 20 -> 10 -> last
    public void reverse(){
        var current = first;
        Node previuos = null;

        while (current != null) {
            var next = current.next;
            current.next = previuos;
            previuos = current;
            current = next;
        }

        var tmp = last;
        last = first;
        first = tmp;
    }

    // first -> 10 -> 20 -> 30 -> 40 -> 50 -> last
    //                      *-----------*
    public int getKthFromTheEnd(int k){
        var current = first;
        var searched = first;
        var distance = 0;

        while (current != null){
            current = current.next;
            if (distance > k-1) {
                searched = searched.next;
            }
            distance++;
        }

        if (k > distance)
            throw new IllegalArgumentException();

        return searched.value;
    }

    public boolean hasLoop(){
        var slow = first;
        var fast = first;

        while (fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return  true;
        }

        return false;
    }

    private Node getPreviousNode(Node node){
        var current = first;
        while (current.next != null){
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private boolean isSingleNode(){
        return first == last;
    }


}
