import java.io.*;
import java.util.*;

public class Main implements Runnable {



    void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[10000000];
        int[] b = new int[10000000];
        for (int i=0; i<n; i++) {
            a[i] = nextInt();
        }
        int res = 0;
        while (n>0) {
            int sz = 0;
            for (int i=0; i<n; i++)
                for (int j=0; j<n; j++)
                    if (a[i]!=a[j]) {
                        b[sz++] = Math.abs(a[i]-a[j]);
                    }
            int[] q = a; a = b; b = q;
            res++;
            n = sz;
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