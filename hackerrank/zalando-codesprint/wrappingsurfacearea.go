import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class Main implements Runnable {

    long surf(long a, long b, long c) {
        return 2*(a*b+a*c+b*c);
    }

    void solve() throws IOException {
        int boxes = nextInt();
        long res = Long.MAX_VALUE;
        int[] a = new int[3];
        for (int i=0; i<3; i++)
            a[i] = nextInt();
        for (int d=1; d<=boxes; d++) {
            for (int e=1; e*d<=boxes; e++) {
                int f = (boxes+d*e-1)/(d*e);
                res = Math.min(res, surf(a[0]*d, a[1]*e, a[2]*f));
                res = Math.min(res, surf(a[0]*d, a[1]*f, a[2]*e));
                res = Math.min(res, surf(a[0]*e, a[1]*d, a[2]*f));
                res = Math.min(res, surf(a[0]*e, a[1]*f, a[2]*d));
                res = Math.min(res, surf(a[0]*f, a[1]*d, a[2]*e));
                res = Math.min(res, surf(a[0]*f, a[1]*e, a[2]*d));
            }
        }
        out.print(res);

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
