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
public class naive {
    public static void search(String txt, String pattern){
        int M = pattern.length();
        int N = txt.length();
        int count = 0;
 
        /*iterate through text*/
        for (int i = 0; i <= N - M; i++) {
 
            int j;
 
            /* For current index i, check for pattern 
              match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pattern.charAt(j))
                    break;
 
            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                count++;
        }
        System.out.println("Alice is found " + count++ + " times.");
    }
}
