/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textsearching;

/**
 *
 * @author S523164
 */
public class TextSearching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String txt = "AABAACAADAABAAABAA";
        String pattern = "AABA";
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
