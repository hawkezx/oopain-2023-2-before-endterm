package hus.oop.sorteddatastructure;

public class MySortedLinkedList extends MySortedAbstractList {
    private Node head;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MySortedLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        return getNodeByIndex(index).data;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null || head.data >= value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    @Override
    public int binarySearch(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value) != -1;
    }

    private Node getNodeByIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

}
