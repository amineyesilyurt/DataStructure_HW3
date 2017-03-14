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
        SingleLinkedList mylist = new SingleLinkedList<>();

        for (int i = 1; i <= 100; ++i) {
            mylist.add(i);
        }

        System.out.println("\nInserted 100 integer to list.\n");
        System.out.println("List element:");
        System.out.println(mylist.toString());

        for (int i = 0; i < 50; ++i) {
            mylist.removeFirst();
        }

        System.out.println("\nDeleted 50 integer from list.\n");
        System.out.println("List element:");
        System.out.println(mylist.toString());
        System.out.println("");

        System.out.println("Garbage list element:");
        System.out.println(mylist.deletedToString());

        for (int i = 200; i < 300; ++i) {
            mylist.add(i);
        }
        System.out.println("");

        System.out.println("\nInserted 100 integer to list again.\n");
        System.out.println("List element:");
        System.out.println(mylist.toString());

        System.out.println("");

        System.out.println("Garbage list element:");
        System.out.println(mylist.deletedToString());

        System.out.println("");




    }
}
