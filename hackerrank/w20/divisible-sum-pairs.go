import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if ((a[i]+a[j])%k==0) res++;
            }
        }
        out.println(res);
        out.flush();
        out.close();
    }
}
