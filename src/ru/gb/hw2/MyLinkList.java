package ru.gb.hw2;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size;

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private class MyLinkedListIterator implements Iterator {
        private int index = 0;

        public boolean hasNext() {
            if (index < size()) {
                return true;
            }
            return false;
        }

        public T next() {
            T o = get(index++);
            return o;
        }

        public void remove() {
            throw new RuntimeException("Not implemented");
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T o) {
        if (isEmpty()) {
            return false;
        }
        Node<T> p;
        for (p = head; p != null; p = p.next) {
            if (p.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public Iterator iterator() {
        return new MyLinkedListIterator();
    }

    public Object[] toArray() {
        if (isEmpty()) {
            return null;
        }
        int length = size();
        int i = 0;
        Object[] array = new Object[length];
        Node<T> p;
        for (p = head; p != null; p = p.next) {
            array[i] = p.value;
            i++;
        }
        return array;
    }

    public boolean add(T o) {
        if (isEmpty()) {
            head = new Node<T>(o);
            tail = head;
        } else {
            Node<T> p = head;
            Node<T> node = new Node<T>(o);
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
            node.next = null;
            node.prev = p;
        }
        size++;
        return true;
    }

    public boolean add(int index, T o) {
        if (size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addLast(o);
        } else {
            int counter = 0;
            Node<T> p = head;
            Node<T> node = new Node<T>(o);
            while (counter != index) {
                p = p.next;
            }
            p.prev = node;
            p.prev.next = node;
            node.prev = p.prev;
            node.next = p;
        }
        size++;
        return true;
    }

    public void addFirst(T o) {
        Node<T> first = head;
        head = new Node<>(o);
        if (first != null) {
            head.next = first;
            head.next.prev = head;
        }
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(T o) {
        Node<T> last = tail;
        tail = new Node<>(o);
        if (last != null) {
            tail.prev = last;
            tail.prev.next = tail;
        }
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public boolean addAll(Collection c) {
        if (c == null || c.size() == 0) {
            return false;
        }
        Iterator it = c.iterator();
        while (it.hasNext()) {
            T o = (T) it.next();
            add(o);
        }
        return true;
    }

    public boolean addAll(int index, Collection c) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (c == null || c.size() == 0) {
            return false;
        }
        if (size == 0 || index == size) {
            addAll(c);
            return true;
        } else {
            int i = index;
            Iterator it = c.iterator();
            while (it.hasNext()) {
                T o = (T) it.next();
                add(i, o);
                i++;
            }
            return true;
        }
    }

    public Node<T> remove() {
        Node<T> temp = head;
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        }
        if (--size == 0) {
            tail = head;
        }
        return temp;
    }

    public boolean remove(T o) {
        Node<T> p = head, p1 = null;
        boolean existed = false;
        if (isEmpty()) {
            return false;
        }
        while (p != null) {
            if (p.value.equals(o)) {
                if (p1 == null) {
                    head = head.next;
                } else {
                    p1.next = p.next;
                }
                existed = true;
            }
            p1 = p;
            p = p.next;
        }
        if (--size == 0) {
            tail = head;
        }
        return existed;
    }

    public T remove(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> p = head, p1 = null;
        int i = -1;
        while (p != null) {
            i++;
            if (i == index) {
                if (p1 == null) {
                    head = head.next;
                    head.prev = null;
                } else {
                    p1.next = p.next;
                    p1.prev = p.prev;
                }
                size --;
                return p.value;
            }
            p1 = p;
            p = p.next;
        }
        return null;
    }

    public boolean removeAll(Collection c) {
        if (c == null || c.size() == 0) {
            return false;
        }
        if (isEmpty()) {
            return false;
        }
        Node<T> p;
        Iterator it = c.iterator();
        while (it.hasNext()) {
            T o = (T) it.next();
            remove(o);
        }
        return true;
    }

    public boolean containsAll(Collection c) {
        if (isEmpty()) {
            return false;
        }
        if (c.size() == 0) {
            return false;
        }

        if (c == null || c.size() > size()) {
            return false;
        }

        Iterator it = c.iterator();
        while (it.hasNext()) {
            T o = (T) it.next();
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public T get(int index) {
        int i = -1;
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<T> p = head;
        while (p != null) {
            i++;
            if (i == index) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public T set(int index, T element) {
        int i = -1;
        if (isEmpty()) {
            add(element);
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<T> p = head;
        T o = null;
        while (p != null) {
            i++;
            if (i == index) {
                o = p.value;
                p.value = element;
                return o;
            }
            p = p.next;
        }
        return null;
    }

    public int indexOf(T o) {
        int i = -1;
        if (isEmpty()) {
            return -1;
        }
        Node<T> p = head;
        while (p != null) {
            i++;
            if (p.value.equals(o)) {
                return i;
            }
            p = p.next;
        }
        return -1;
    }

}