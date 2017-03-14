package edu.gtu.amine;

import java.util.Iterator;
import javax.print.attribute.standard.Sides;

/**
 *
 * @author Amine
 * @param <E>
 */
public class MyStringBuilder<E> {

    private SingleLinkedList mylist; // single linked list

    /**
     * No parameter constructor
     */
    public MyStringBuilder() {
        mylist = new SingleLinkedList<>();
    }

    /**
     *
     * append method to append anything to list
     * @param theElement the element which will append to list
     * @return myStringBuilder object
     */
    public MyStringBuilder append(E theElement) {

        try {
            int size = mylist.size();
            mylist.add(size, theElement);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return this;
    }

    /**
     * Uses indexes and get method
     * @return result is a string which contains the all of the list elements
     */
    public String toString1() {

        String result = "";
        for (int i = 0; i < mylist.size(); ++i) {
            result += mylist.get(i) + " ";
        }
        return result;

    }

    /**
     * Uses iterator
     * @return result is a string which contains the all of the list elements
     */
    public String toString2() {
        Iterator<E> iter = mylist.iterator();
        String result = "";
        while (iter.hasNext()) {
            result += (iter.next().toString() + " ");

        }
        return result;

    }

    /**
     * Uses toString method of the linked list
     * @return result is a string which contains the all of the list elements
     */
    public String toString3() {
        return mylist.toString();
    }

}
