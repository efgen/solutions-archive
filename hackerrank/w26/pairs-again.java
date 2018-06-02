import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {
    static final int[] h = new int[300001];
    static final int[] e = new int[3529834];
    static final int[] nxt = new int[3529834];
    static int cnt;

    static void add(int x, int y) {
        e[++cnt] = y;
        nxt[cnt] = h[x];
        h[x] = cnt;
    }

    void solve() throws IOException {
        int n = nextInt();

        for (int i = n; i > 1; --i) {
            for (int j = i; j <= n; j += i)
                add(j, i);
        }

        int nn = (n + 1) / 2;
        int res = n - 2;
        for (int a = 2; a < nn; ++a) {
            for (int j = a; j <= n; j += a)
                h[j] = nxt[h[j]];

            HashSet<Integer> ALL = new HashSet<>(200);
            for (int s = n - a; s > 0; s -= a) {
                for (int t = h[s]; t > 0; t = nxt[t]) {
                    ALL.add(e[t]);
                }
            }
            
            res += ALL.size();
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