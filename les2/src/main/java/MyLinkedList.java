import java.util.Objects;
import java.util.logging.Logger;

public class MyLinkedList<T> implements MyList<T>, IMyLinkedList<T>{

    private static final Logger LOG = Logger.getLogger(MyLinkedList.class.getName());

    private Node first;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;
    }


    @Override
    public void add(T t) {
        Node node = new Node(t);
        LOG.info("add node: "  + node.getElement());
        if(first == null) {
            first = last = node;
            first.prev = null;
            last.next =  null;
        }
        else {
            last.next = node;
            node.prev = last;
            last = node;
            last.next = null;
        }

        size++;
    }

    @Override
    public void addAfterIndex(int index, T t) {
        Node newNode = new Node(t);
        Node current =null;
        current = getNode(index);
        newNode.prev = current;
        newNode.next = current.next;
        current.next = newNode;

    }

    private Node getNode(int index) {
        index--;
        if(index > size) {
            throw new IndexOutOfBoundsException("Arrays size: " + size);
        }
        Node current;
        if(index <= size/2) {
            current = first;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for(int i = size; i > index; i -- ) {
                current = current.prev;
            }
        } return current;
    }

    @Override
    public T get(int i) {
        return (T) getNode(i).getElement();
    }

    @Override
    public void removeElementByIndex(int index) {
        Node current = getNode(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addLast(T t) {
        add(t);
    }

    @Override
    public void addFirst(T t) {
        Node node = new Node(t);
        node.next=first;
        node.prev=null;

        if(first != null) {
            first.prev = node;
        }else {
            first = last = node;
            first.prev = null;
            last.next =  null;
        }
        first = node;
        size++;
    }

    @Override
    public void removeLast() {
        Node current  = last.prev;
        current.next = null;
        last = current;
        size--;
    }

    @Override
    public void removeFirst() {
        Node current = first.next;
        current.prev = null;
        first = current;
        size--;
    }



    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(T element) {
            this.element = element;
        }

        Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(first == null) {
            return "Empty";
        }
        Node current = first;
        LOG.info("first node: " + current);
        while(current != null) {
            sb.append(current.getElement()  + "; ");
            current =current.next;
        }
        return "MyLinkedList{" + sb + "} size: " + size;
    }
}
