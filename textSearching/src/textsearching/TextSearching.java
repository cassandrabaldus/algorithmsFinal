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
        naive.search(txt, pattern);
    }
    
}
