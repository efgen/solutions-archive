import java.io.*;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
        int s = nextInt();
        int t = nextInt();
        int a = nextInt();
        int b = nextInt();
        int n = nextInt();
        int m = nextInt();
        int res = 0;
        while (n-->0) {
            int x = nextInt();
            x += a;
            if (x>=s && x<=t) res++;
        }
        out.println(res);
        res = 0;
        while (m-->0) {
            int x = nextInt();
            x += b;
            if (x>=s && x<=t) res++;
        }
        out.println(res);
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