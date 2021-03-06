/*

quest - Shortest Common Supersequence

example - s1 = aditya, s2 = hurditya, then ans = ahurditya

i.e., order must be maintained and commons must not be repeated

HINT - to find the length of SCS = s1+s2-LCS(i.e. common ones)

*/


import java.util.*;

public class Main {
    
    public static int LCS(String s1, String s2, int m, int n, int[][] store){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){ store[i][j]=1+store[i-1][j-1]; } // same char hence i-1 j-1 and +1
                else{
                    int op1 = store[i][j-1];         // not same hence keeping char at s1 and leaving char at s2
                    int op2 = store[i-1][j];         // vice versa of the above
                    store[i][j] = (op1>op2)?op1:op2; // storing the max length
                }
            }
        }return store[m][n];
    }
    
    public static int LCS(String s1, String s2, int m, int n){
        int[][] store = new int[m+1][n+1];
        for(int i=0; i<=m; i++){ store[i][0]=0; } // base case
        for(int j=0; j<=n; j++){ store[0][j]=0; } // base case
        return LCS(s1, s2, m, n, store);
    }
    
    public static void main(String[] args) throws Exception {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int ans = s1.length()+s2.length()-LCS(s1, s2, s1.length(), s2.length());
        System.out.println("Ans = " + ans);
    }
}

// ans = 9  (6+7-4)
