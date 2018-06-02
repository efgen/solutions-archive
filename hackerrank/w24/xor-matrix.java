import java.io.*;
import java.util.*;

public class Main implements Runnable {
    void solve() throws IOException {
        int n = nextInt();
        long m = nextLong() - 1;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        for (int k = 62; k >= 0; k--) {
            long t = ((long) 1) << k;
            if (t <= m) {
                m -= t;
                int shift = (int) (t % n);
                for (int i = 0; i < n; i++)
                    b[i] = a[i] ^ a[(i + shift) % n];
                int[] tmp = a;
                a = b;
                b = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
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
            out.flush();
            out.close();
        } catch (Exception e) {
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