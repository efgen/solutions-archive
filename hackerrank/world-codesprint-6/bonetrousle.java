import java.io.*;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
        int t = nextInt();
        while (t-->0) {
            long n = nextLong();
            long k = nextLong();
            long b = nextInt();
            long sum = (1L+b)*b/2;
            Vector<Long> res = new Vector<>();
            if (n<sum) {
                out.println(-1);
                continue;
            }

            for (long x=b; x>0; --x) {
                long nsum = sum + k - b;
                if (nsum<n) {
                    res.add(x + k - b);
                    sum = nsum;
                } else {
                    long addition = n-sum;
                    res.add(x+addition);
                    sum += addition;
                    while (x>1) {
                        --x;
                        res.add(x);
                    }
                }

            }
            if (sum != n) {
                out.println(-1);
            } else {
                for (int i=0; i<b; i++) {
                    if (i>0) out.print(" ");
                    out.print(res.elementAt(i));
                }
                out.println();
            }

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
