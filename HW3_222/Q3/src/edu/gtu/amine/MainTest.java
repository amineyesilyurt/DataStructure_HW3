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

        MyAbstractCollection collection_1 = new MyAbstractCollection();
        MyAbstractCollection collection_2 = new MyAbstractCollection();
        MyAbstractCollection concataneted = new MyAbstractCollection();

        collection_2.add("Asli");
        collection_2.add(2001);
        collection_2.add(1.39);

        collection_1.add("Ece");
        collection_1.add(1999);
        collection_1.add(1.45);

        concataneted.appendAnything(collection_2);
        concataneted.appendAnything(collection_1);

        System.out.println("Concataneted Collection:");
        System.out.println(concataneted.toString());

    }

}
