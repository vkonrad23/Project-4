public class Part1 {

    private Node firstElementOfList; // head
    private Node lasElementOfList;  // tail
    private int size = 0;

    private static class Node {
        Integer element;
        Node next;
        Node prev;

        Node(Node prev, Integer element, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(Integer element) {
        Node l = lasElementOfList; // NULL if list is empty
        Node newNode = new Node(l, element, null);
        lasElementOfList = newNode;
        if (l == null)
            firstElementOfList = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void remove(Integer element) {
        for (Node x = firstElementOfList; x != null; x = x.next) {
            if (element.equals(x.element)) {
                unlink(x);
                break;
            }
        }
    }

    public void remove(int index) {
        checkIndexBounds(index);
        Node x = getNode(index);
        unlink(x);
    }

    public void removeAll(Integer element) {
        Node currentNode = firstElementOfList;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (element.equals(currentNode.element)) {
                unlink(currentNode);
            }
            currentNode = nextNode;
        }
    }

    public void addFirst(Integer element) {
        Node oldFirstNode = firstElementOfList;
        Node newFirstNode = new Node(null, element, oldFirstNode);
        firstElementOfList = newFirstNode; // IF list is empty, newFirstNode is also lastElementOfList
        if (oldFirstNode == null) {
            lasElementOfList = newFirstNode;
        } else {
            oldFirstNode.prev = newFirstNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder listContents = new StringBuilder();
        for (Node currentNode = firstElementOfList; currentNode != null; currentNode = currentNode.next) {
            listContents.append(currentNode.element).append(" ");
        }
        return listContents.toString().trim();
    }

    private Node getNode(int index) {
        Node currentNode = firstElementOfList;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private void unlink(Node x) {
        Node nextNode = x.next;
        Node prevNode = x.prev;

        if (prevNode == null) {
            firstElementOfList = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) {
            lasElementOfList = prevNode;
        } else {
            nextNode.prev = prevNode;
        }

        x = null;
        size--;
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        Part1 list = new Part1();

        list.add(55);
        list.add(2);
        list.add(14);
        System.out.println(list);

        list.addFirst(100);
        System.out.println(list);

        list.remove(Integer.valueOf(2));
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.add(2);
        System.out.println(list);

        list.removeAll(2);
        System.out.println(list);
    }
}