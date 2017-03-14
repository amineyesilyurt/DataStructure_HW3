/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gtu.amine;

/**
 *
 * @author Amine
 */
public class MainTest {

    public static void main(String[] args) {

        SingleLinkedList myList = new SingleLinkedList<>();
        SingleLinkedList  myList2 = new SingleLinkedList<>();

        //TEST 1
        myList.add(1);
        myList.add(1.0);
        myList.add("one");
        myList.add(2);
        myList.add(2.0);
        myList.add("two");
        myList.add(3);
        myList.add(3.0);
        myList.add("three");
        myList.add(4);
        myList.add(4.0);
        myList.add("four");

        System.out.println( myList.reverseToString(myList.size()-1) );

        //TEST 2
        myList2.add("Ali");
        myList2.add("Topu");
        myList2.add("Tut");

        System.out.println( myList2.reverseToString(myList2.size()-1) );



    }

}
