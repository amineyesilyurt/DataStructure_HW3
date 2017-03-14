/*
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 THIS CLASS COPIED FROM BOOK AND ADDED ITERATOR AND ADDED A LIST WHICH KEEPS DELETED NODES
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
package edu.gtu.amine;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Amine
 */
public class SingleLinkedList<E> implements Iterable<E> {

    // Data fields
    /**
     * A reference to the head of the list
     */
    private Node<E> head = null;
    private Node<E> deletedHead = null; //reference to head of list of deleted elements
    /**
     * The size of the list
     */
    private int size = 0;
    private int deletedSize = 0;//size of list of deleted elements

    // Nested Class
    /*<listing chapter="2" number="1">*/
    /**
     * A Node is the building block for the SingleLinkedList
     */
    private static class Node<E> {

        /**
         * The data value.
         */
        private E data;
        /**
         * The link
         */
        private Node<E> next = null;

        /**
         * Construct a node with the given data value and link
         *
         * @param data - The data value
         * @param next - The link
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Construct a node with the given data value
         *
         * @param data - The data value
         */
        public Node(E data) {
            this(data, null);
        }

        public void setNode(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public void setNode(E data) {
            this.data = data;
        }
    }

    // Helper Methods
    /**
     * Insert an item as the first item of the list.
     *
     * @param item The item to be inserted
     */
    private void addFirst(E item) {

        if (deletedSize <= 0) {
            head = new Node<E>(item, head);
        } else {
            head = getNodeFromDeletedList(0);
            head.setNode(item);
            removeFirstFromDeletedList();

        }
        size++;
    }

    /**
     * Insert an item as the first item of the list.
     *
     * @param item The item to be inserted
     */
    private void addFirsttToDeletedList(E item) {
        deletedHead = new Node<E>(item, deletedHead);
        deletedSize++;
    }

    /**
     * Add a node after a given node
     *
     * @param node The node which the new item is inserted after
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item) {
        if (deletedSize <= 0) {
            node.next = new Node<E>(item, node.next);
        } else {
            node.next = getNodeFromDeletedList(0);
            node.next.setNode(item);
            removeFirstFromDeletedList();
        }
        size++;
    }

    /**
     * Add a node after a given node
     *
     * @param node The node which the new item is inserted after
     * @param item The item to insert
     */
    private void addAfterToDeletedList(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        deletedSize++;
    }

    /**
     * Remove the first node from the list
     *
     * @return The removed node's data or null if the list is empty
     */
    public E removeFirst() {
        Node<E> temp = head;
        addtoDeletedList(temp.data); //added deleted item garbage list
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the first node from the list
     *
     * @return The removed node's data or null if the list is empty
     */
    private E removeFirstFromDeletedList() {
        Node<E> temp = deletedHead;
        if (deletedHead != null) {
            deletedHead = deletedHead.next;
        }
        if (temp != null) {
            deletedSize--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     *
     * @param node The node before the one to be removed
     * @return The data from the removed node, or null if there is no node to
     * remove
     */
    public E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        addtoDeletedList(temp.data); //added deleted item garbage list
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     *
     * @param node The node before the one to be removed
     * @return The data from the removed node, or null if there is no node to
     * remove
     */
    private E removeAfterFromDeletedList(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            deletedSize--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Find the node at a specified index
     *
     * @param index The index of the node sought
     * @return The node at index or null if it does not exist
     */
    public Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Find the node at a specified index
     *
     * @param index The index of the node sought
     * @return The node at index or null if it does not exist
     */
    private Node<E> getNodeFromDeletedList(int index) {
        Node<E> node = deletedHead;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // Public Methods
    /**
     * Get the data value at index
     *
     * @param index The index of the element to return
     * @return The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Get the data value at index
     *
     * @param index The index of the element to return
     * @return The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E getFromDeletedList(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNodeFromDeletedList(index);
        return node.data;
    }

    /**
     * Set the data value at index
     *
     * @param index The index of the item to change
     * @param newValue The new value
     * @return The data value priviously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * Set the data value at index
     *
     * @param index The index of the item to change
     * @param newValue The new value
     * @return The data value priviously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E setToDeletedList(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNodeFromDeletedList(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * Insert the specified item at the specified position in the list. Shifts
     * the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indicies)
     *
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is invalid!");
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Insert the specified item at the specified position in the list. Shifts
     * the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indicies)
     *
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void addtoDeletedList(int index, E item) {

        if (index < 0 || index > deletedSize) {
            throw new IndexOutOfBoundsException("Index is invalid!");
        }
        if (index == 0) {
            addFirsttToDeletedList(item);
        } else {
            Node<E> node = getNodeFromDeletedList(index - 1);
            addAfterToDeletedList(node, item);
        }
    }

    /**
     * Append the specified item to the end of the list
     *
     * @param item The item to be appended
     * @return true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    /**
     * Append the specified item to the end of the list
     *
     * @param item The item to be appended
     * @return true (as specified by the Collection interface)
     */
    public boolean addtoDeletedList(E item) {
        addtoDeletedList(deletedSize, item);
        return true;
    }

// Insert solution to programming exercise 1, section 5, chapter 2 here
    /**
     * Query the size of the list
     *
     * @return The number of objects in the list
     */
    int size() {
        return size;
    }

    /**
     * Query the size of the list
     *
     * @return The number of objects in the list
     */
    int sizeDeletedList() {
        return deletedSize;
    }

    /**
     * Obtain a string representation of the list
     *
     * @return A String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        return sb.toString();
    }

    /**
     *
     * @return iterator of single linked list
     */
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<E> implements Iterator<E> {

        private Node<E> current;

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
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else if (current == null) {
                current = (Node<E>) head;
                return current.data;
            } else {
                current = current.next;
                return (E) current.data;
            }
        }

        @Override
        public void remove() {
            //this is not required
        }
    }

    /**
     * Obtain a string representation of the list
     *
     * @return A String representation of the list
     */
    public String deletedToString() {
        StringBuilder sb = new StringBuilder();
        Node p = deletedHead;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        return sb.toString();
    }

}