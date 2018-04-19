/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textsearching;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author S523164
 */
public class TextSearching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String txt = new String(Files.readAllBytes(Paths.get("alice.txt")));
        
        String pattern = "Alice";
        
        int q = 101; //prime number
        
        long start = System.nanoTime();
        naive.search(txt, pattern);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
        
        start = System.nanoTime();
        RabinKarp.search(txt, pattern, q);
        elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
        
        start = System.nanoTime();
        KMP.search(txt, pattern);
        elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
    }    
    
}
