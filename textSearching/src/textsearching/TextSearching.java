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
       
        int q = 101; //prime number
        Scanner in = new Scanner(System.in);
        
        System.out.println("search for: ");
        String pattern = in.nextLine();
        System.out.println("how many iterations? : ");
        int itter = in.nextInt();
        long elapsedTimeNaive = 0;
        long elapsedTimeRabin = 0;
        long elapsedTimeKMP = 0;
        
        for(int i = 0;i < itter; i++){
            long start = System.nanoTime();
            naive.search(txt, pattern);
            elapsedTimeNaive += System.nanoTime() - start;

            start = System.nanoTime();
            RabinKarp.search(txt, pattern, q);
            elapsedTimeRabin += System.nanoTime() - start;

            start = System.nanoTime();
            KMP.search(txt, pattern);
            elapsedTimeKMP += System.nanoTime() - start;
        }
        
        elapsedTimeNaive = elapsedTimeNaive/itter;
        elapsedTimeRabin = elapsedTimeRabin/itter;
        elapsedTimeKMP = elapsedTimeKMP/itter;
            
        System.out.println(elapsedTimeNaive);
        System.out.println(elapsedTimeRabin);
        System.out.println(elapsedTimeKMP);
        
        System.out.println("Naive = " + naive.search(txt, pattern));
        System.out.println("Rabin Karp = " + RabinKarp.search(txt, pattern, q));
        System.out.println("KMP = " + KMP.search(txt, pattern));
    }    
    
}
