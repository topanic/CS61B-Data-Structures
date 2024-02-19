package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;
        public Node(Node p, T v, Node n) {
            prev = p;
            item = v;
            next = n;
        }
    }

    private Node sentinelF;
    private Node sentinelB;
    private int size;

    public LinkedListDeque() {
        sentinelF = new Node(null, null, null);
        sentinelB = new Node(null, null, null);
        sentinelF.next = sentinelB;
        sentinelB.prev = sentinelF;
        size = 0;
    }

    public void addFirst(T item) {
        Node temp = new Node(sentinelF, item, sentinelF.next);
        sentinelF.next.prev = temp;
        sentinelF.next = temp;
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node temp = sentinelF.next;
        temp.next.prev = sentinelF;
        sentinelF.next = temp.next;
        size -= 1;
        return temp.item;
    }

    public void addLast(T item) {
        Node temp = new Node(sentinelB.prev, item, sentinelB);
        sentinelB.prev.next = temp;
        sentinelB.prev = temp;
        size += 1;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node temp = sentinelB.prev;
        temp.prev.next = sentinelB;
        sentinelB.prev = temp.prev;
        size -= 1;
        return temp.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node temp = sentinelF.next;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node pointer = sentinelF;
        int temp = 0;
        while (temp<=index){
            pointer = pointer.next;
            temp = temp+1;
        }
        return pointer.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        class getHelper{
            public T helper(Node curentNode,int currIndex){
                if (currIndex == index) {
                    return curentNode.item;
                } else {
                    return helper(curentNode.next,currIndex+1);
                }
            }
        }
        getHelper thisHelp = new getHelper();
        return thisHelp.helper(sentinelF.next,0);
    }

    @Override
    public Iterator<T> iterator() {
        return new LLDIterator();
    }

    private class LLDIterator implements Iterator<T> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return  currentIndex < size && get(currentIndex) != null;
        }

        @Override
        public T next() {
            T temp = get(currentIndex);
            currentIndex = currentIndex + 1;
            return temp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (!(o instanceof Deque)) {
            return  false;
        }
        Deque<T> other = (Deque<T>) o;
        if (this.size() != other.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!other.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }

}
