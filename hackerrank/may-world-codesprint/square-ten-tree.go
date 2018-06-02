import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
    Vector<String> ans = new Vector<String>();
    Vector<Integer> ansCount = new Vector<Integer>();

    void append(StringBuilder sb, int k) {
        String s = sb.reverse().toString();
        boolean isNull = true;
        for (char c:s.toCharArray()) {
            if (c!='0') isNull = false;
        }
        if (!isNull) {
            ans.add(s);
            ansCount.add(k);
        }


    }
    void solve() throws IOException {


        String ll = br.readLine();
        String rr = br.readLine();
        int n = 1;
        while (n<=rr.length()) {
            n <<= 1;
        }
        int[] L = new int[n];
        int[] R = new int[n];

        for (int i=0; i<ll.length(); i++) {
            L[i] = ll.charAt(ll.length()-1-i) - '0';
        }
        for (int i=0; i<rr.length(); i++) {
            R[i] = rr.charAt(rr.length()-1-i) - '0';
        }

        //for (int x:L) out.print(x); out.println();
        //for (int x:R) out.print(x);

   /*     int k;


        for (k=1; k<n; k *= 2) {
            int s = k/2;
            int e = k;
            boolean isOk = true;
            for (int i=k; isOk && i<n; i++) {
                if (L[i] != R[i]) isOk = false;
            }
            if (isOk) break;

            StringBuilder res = new StringBuilder();
            int cifra = 0;
            for (int i=s; i<e; i++) {
                if (L[i]<=cifra) {
                    res.append((char) (cifra-L[i]+'0'));
                } else {
                    res.append((char) (10-L[i]+'0'));
                    cifra = 9;
                }

            }

            append(res, k/2);

            int pos = k;
            while (L[pos] == 9) {
                L[pos] = 0;
                pos++;
            }
            L[pos]++;
        }

        int s = k/2;
        int e = k;
        StringBuilder res = new StringBuilder();
        for (int i=s; i<e; i++) {

            if (R[i] >= L[i]) {
                res.append((char) (R[i]-L[i]+'0'));
            } else {
                res.append((char) (10+R[i]-L[i]+'0'));
                L[i+1]++;
            }
        }

        append(res, k/2);
*/

        int k = n/2;

        while (k>0) {
            int s = k/2;
            int e = k;
            StringBuilder res = new StringBuilder();
            for (int i=s; i<e; i++) {
               res.append(R[i]);
            }
            append(res, k/2);
            k/=2;
        }



        out.println(ans.size());
        for (int i=0; i<ans.size(); i++) {
            out.println(ansCount.get(i) + " " + ans.get(i));
        }





    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(123);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }
}
/*
9013452
98543278



 */