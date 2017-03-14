package edu.gtu.amine;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Amine
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MyStringBuilder sb1 = new MyStringBuilder<>(); // uses get method and index
        MyStringBuilder sb2 = new MyStringBuilder<>(); //uses iterator
        MyStringBuilder sb3 = new MyStringBuilder<>(); //uses toString method of the linked list

        Path filePath = Paths.get("numbers.txt");
        Scanner scanner = null;
        Writer writer = null;
        //
        //
        //
        /*------------------------- TEST 1 ------------------------------*/
        System.out.println("Testing toString1() method: This method uses get and index");
        try {
            scanner = new Scanner(filePath);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        while (scanner.hasNext()) {

            sb1.append(scanner.nextInt());

        }
        scanner.close();

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("result1.txt"), "utf-8"));
            writer.write(sb1.toString1());
        } catch (IOException ex) {

        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/

            }
        }
        /*-------------------END OF  TEST 1 ------------------------------*/
        //
        //
        //
        //
        //
        //
        /*------------------------- TEST 2 ------------------------------*/
        System.out.println("Testing toString2() method: This method uses iterator.");
        try {
            scanner = new Scanner(filePath);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        while (scanner.hasNext()) {

            sb2.append(scanner.nextInt());

        }
        scanner.close();

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("result2.txt"), "utf-8"));
            writer.write(sb2.toString2());
        } catch (IOException ex) {

        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/

            }
        }
        /*-------------------END OF  TEST 2 ------------------------------*/
        //
        //
        //
        //
        //
        //
        /*------------------------- TEST 3 ------------------------------*/
        System.out.println("Testing toString3() method: This method uses toString method of linked list.");
        try {
            scanner = new Scanner(filePath);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        while (scanner.hasNext()) {

            sb3.append(scanner.nextInt());

        }
        scanner.close();

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("result3.txt"), "utf-8"));
            writer.write(sb3.toString3());
        } catch (IOException ex) {

        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/

            }
        }
        /*-------------------END OF  TEST 3 ------------------------------*/


    }

}
