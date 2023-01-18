public class CircularDoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {return element;}
        public Node<E> getPrev() {return prev;}
        public Node<E> getNext() {return next;}
        public void setPrev(Node<E> p) {prev = p;}
        public void setNext(Node<E> n) {next = n;}
    }
    private Node<E> tail;
    private int size;
    public CircularDoublyLinkedList() {}

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    //Returns the first element in linked list
    public E first() {
        if (isEmpty()) {return null;}
        return tail.getNext().getElement();
    }

    //Returns the last element in linked list
    public E last() {
        if (isEmpty()) {return null;}
        return tail.getElement();
    }

    //Adds an element at the front of the linked list
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node(e, null, null);
            tail.setNext(tail);
            tail.setPrev(tail);
            size++;
        }
        else { addBetween(e, tail, tail.getNext());}  
    }

    //Adds an element at the back of the linked list
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) {return null;}
        return remove(tail.getNext());
    }

    //Removes an element at the front of the linked list
    public E removeLast() {
        if (isEmpty()) {return null;}
        return remove(tail);
    }

    //Searchs the linked list for an element 
    //returns true if found
    public boolean contains(E e) {
        boolean exists = false;
        if (isEmpty()) {return false;}
        for (int i = 0; i < size(); i++) {
            if (tail.getElement().equals(e)) {exists = true;}
            tail = tail.getNext();
        }
        return exists;
     }

    //Generalized add method that adds between two nodes
    private void addBetween(E e, Node<E> p, Node<E> n) {
        Node<E> newest = new Node<>(e, p, n);
        p.setNext(newest);
        n.setPrev(newest);
        size++;
    }

    //Generalized remove method that removes specified node
    //at specified location
    private E remove(Node<E> node) {
        Node<E> previous = node.getPrev();
        Node<E> next = node.getNext();
        previous.setNext(next);
        next.setPrev(previous);
        tail = node.getPrev();
        size--;
        return node.getElement();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(tail.getNext().getElement() + "\n");
            tail = tail.getNext();
        }
        return sb.toString();
    }

}

