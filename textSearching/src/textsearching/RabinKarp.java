/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textsearching;

/**
 *
 * @author daniel
 */
public class RabinKarp {
// Following program is a Java implementation 
// of Rabin Karp Algorithm given in the CLRS book
 
    // d is the number of characters in input alphabet
    public final static int d = 256;
     
    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    static int search(String txt, String pat, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash of pattern
        int t = 0; // hash of txt
        int h = 1;
        int count = 0;
     
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;
     
        //hash of pattern and first
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }
     
        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {
     
            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }
     
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    count++;
            }
     
            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
     
                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                t = (t + q);
            }
        }
        return count;
        //System.out.println("Alice is found " + count + " times");
    }
}
 
// This code is contributed by nuclode