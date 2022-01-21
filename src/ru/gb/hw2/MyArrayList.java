package ru.gb.hw2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//The simplest version without Iterator and other stuff
public class MyArrayList<T> {
    private T[] internalArray;
    int size;

    private class MyArrayListIterator implements Iterator {
        private int index = 0;

        public boolean hasNext() {
            if (index < size) {
                return true;
            }
            return false;
        }

        public T next() {
            T o = internalArray[++index];
            return o;
        }

        public void remove() {
            throw new RuntimeException("Not implemented");
        }

    }

    public boolean add(T o) {
        if (size++ > internalArray.length / 2) {
            grow();
        }
        internalArray[size] = o;
        return true;
    }

    public boolean add(int index, T o) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            return add(o);
        } else {
            System.arraycopy(internalArray, index, internalArray, index + 1, size - index);
            internalArray[index] = o;
        }
        if (size++ > internalArray.length / 2) {
            grow();
        }
        return true;
    }

    public boolean addAll(Collection c) {
        if (c == null || c.size() == 0) {
            return false;
        }
        if (internalArray.length < size + c.size()) {
            resize((internalArray.length + c.size()) * 2);
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

        if (internalArray.length < size + c.size()) {
            resize((internalArray.length + c.size()) * 2);
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

    public int size() {
        return size;
    }

    private int indexOf(T o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(internalArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    public void remove(T o) {
        int index = indexOf(o);
        if (index > 0) {
            remove(index);
        }
    }

    public void remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            internalArray[index] = null;
        } else {
            internalArray[index] = null;
            System.arraycopy(internalArray, index + 1, internalArray, index, size - index);
        }
        size--;

        if (size < internalArray.length / 3) {
            shrink();
        }

    }

    public void removeAll(Collection c) {
        int i = 0;
        Iterator it = c.iterator();
        while (it.hasNext()) {
            T o = (T) it.next();
            remove(o);
            i++;
        }
    }

    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    private void grow() {
        resize(internalArray.length * 2);
    }

    private void shrink() {
        resize(internalArray.length / 2);
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(internalArray, 0, newArray, 0, internalArray.length);
        internalArray = (T[]) newArray;
    }

    private T get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return internalArray[index];
    }
}
