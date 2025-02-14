package fr.epita.assistants.linkedlist;

import java.util.Comparator;

public class LinkedList<T extends Comparable<T>> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Initializes the list
     **/
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * Null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        Node<T> newNode = new Node<>(e);

        if (head == null || (e != null && head.data == null) || (e != null && head.data.compareTo(e) > 0)) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && (current.next.data == null || (e != null && current.next.data.compareTo(e) <= 0))) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this index.
     **/
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }

        Node<T> current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (head == null) return null;

        if (head.data == e || (e != null && e.equals(head.data))) {
            T removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data == e || (e != null && e.equals(current.next.data))) {
                T removedData = current.next.data;
                current.next = current.next.next;
                size--;
                return removedData;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        head = null;
        size = 0;
    }
}