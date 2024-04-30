import java.util.NoSuchElementException;

//  Queue
public class Part3 {

    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node {
        Integer element;
        Node next;

        Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public void enqueue(Integer element) {
        Node newNode = new Node(element, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Enqueued: " + element);
    }

    public Integer dequeue() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Integer element = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        System.out.println("Dequeued: " + element);
        return element;
    }

    public Integer peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Part3 queue = new Part3();

        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(7);
        System.out.println("First: " + queue.peek());
        queue.dequeue();
        System.out.println("First: " + queue.peek());
    }
}