package study.structure;

import java.sql.Array;
import java.util.*;

public class MyQueueLinkedList<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (Node<E> node = head; node != null; node = node.next){
            if (value.equals(node.data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node<E> node = head; node != null; node = node.next){
            array[index++] = (E) node.data;
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        int index = 0;

        Object[] result = a;
        for (Node<E> node = head; node != null; node = node.next) {
            result[index++] = node.data;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean remove(Object o) {
        if (o.equals(head.data)) {
            poll();
            return true;
        }

        Node<E> node = head;
        while (node.next != null) {
            if (o.equals(node.next.data)) {
                node.next = node.next.next;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Node<E> node = head; node != null; node = node.next){
            boolean step = false;
            for (Object o : c) {
                if (o.equals(node.data)) {
                    step = true;
                    break;
                }
            }
            if (!step) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ){
            Node<E> nextNode = node.next;
            node.data = null;
            node.next = null;
            node = nextNode;
        }
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E remove() {
        E element = poll();

        if (element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E poll() {

        if (this.size == 0) {
            return null;
        }

        E element = head.data;

        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        return element;
    }

    @Override
    public E element() {
        E element = peek();

        if (element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {

        if (size == 0) {
            return null;
        }

        return head.data;
    }
}

class TestMyQueueLinkedList {
    public static void main(String[] args) {
        MyQueueLinkedList<Integer> linkedList = new MyQueueLinkedList<>();
        linkedList.offer(1);
        linkedList.offer(2);
        linkedList.offer(3);
        linkedList.offer(4);

        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}