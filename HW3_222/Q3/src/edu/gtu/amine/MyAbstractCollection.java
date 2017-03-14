/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gtu.amine;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Amine
 */
public class MyAbstractCollection<Object> extends AbstractCollection<Object> {

    private Node<Object> head = null;

    private int size = 0;

    private Node<Object> getNode(int index) {
        Node<Object> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // Helper Methods
    /**
     * Insert an item as the first item of the list.
     *
     * @param item The item to be inserted
     */
    private void addFirst(Object item) {
        head = new Node<Object>(item, head);
        size++;
    }

    /**
     * Add a node after a given node
     *
     * @param node The node which the new item is inserted after
     * @param item The item to insert
     */
    private void addAfter(Node<Object> node, Object item) {
        node.next = new Node<Object>(item, node.next);
        size++;
    }

    public void add(int index, Object item) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is invalid!");
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<Object> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Append the specified item to the end of the list
     *
     * @param item The item to be appended
     * @return true (as specified by the Collection interface)
     */
    @Override
    public boolean add(Object item) {
        add(size, item);
        return true;
    }

    // Nested Class
    /*<listing chapter="2" number="1">*/
    /**
     * A Node is the building block for the SingleLinkedList
     */
    private static class Node<Object> {

        /**
         * The data value.
         */
        private Object data;
        /**
         * The link
         */
        private Node<Object> next = null;

        /**
         * Construct a node with the given data value and link
         *
         * @param data - The data value
         * @param next - The link
         */
        public Node(Object data, Node<Object> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Construct a node with the given data value
         *
         * @param data - The data value
         */
        public Node(Object data) {
            this(data, null);
        }
    }

    /**
     * appends any AbstractCollection object to any
     * other AbstractCollection object by concatenating them
     * @param theOther MyAbstractCollection object to concataneta
     */
    public void appendAnything(MyAbstractCollection theOther) {

        Iterator<Object> iter = theOther.iterator();
        while (iter.hasNext()) {
            add(iter.next());
        }

    }

    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return iterator of single linked list
     */
    @Override
    public Iterator<Object> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<Object> implements Iterator<Object> {

        private Node<Object> current;

        public MyIterator() {
            current = null;
        }

        @Override
        public boolean hasNext() {
            if (current == null) {
                return (head != null);
            } else {
                return (current.next != null);
            }
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else if (current == null) {
                current = (Node<Object>) head;
                return current.data;
            } else {
                current = current.next;
                return (Object) current.data;
            }
        }

        @Override
        public void remove() {
            //this is not required
        }
    }

}
