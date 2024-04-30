import java.util.NoSuchElementException;

// Stack
public class Part2 {

    private Node top;
    private int size = 0;

    private static class Node {
        Integer element;
        Node next;

        Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public void push(Integer element) {
        top = new Node(element, top);
        size++;
        System.out.println("Pushed: " + element);
    }

    public Integer pop() {
        if (top == null) {
            throw new NoSuchElementException("empty");
        }
        Integer element = top.element;
        top = top.next;
        size--;
        System.out.println("Popped: " + element);
        return element;
    }

    public Integer peek() {
        if (top == null) {
            throw new NoSuchElementException("empty");
        }
        return top.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Part2 stack = new Part2();

        stack.push(10);
        stack.push(3);
        stack.push(7);
        System.out.println("Last: " + stack.peek());
        stack.pop();
        System.out.println("Last: " + stack.peek());
    }
}