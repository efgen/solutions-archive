import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {
    Vector<Integer>[] a;
    int n;
    int[] Q, d, p;
    int qs, qt;

    void bfs(int v) {
        Arrays.fill(d, -1);
        qs = qt = 0;
        Q[qt++] = v;
        d[v] = 0;
        p[v] = -1;
        while (qs < qt) {
            v = Q[qs++];
            for (int x : a[v]) {
                if (d[x] == -1) {
                    p[x] = v;
                    d[x] = d[v] + 1;
                    Q[qt++] = x;
                }
            }
        }
    }

    void solve() throws IOException {
        n = nextInt();
        a = new Vector[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Vector<>();
        }
        for (int i = 1; i < n; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            a[x].add(y);
            a[y].add(x);
        }
        d = new int[n];
        Q = new int[n];
        p = new int[n];


        bfs(n / 2);
        int distV = Q[n - 1];
        bfs(distV);

        int last = Q[n - 1];
        int[] sz = new int[d[last] + 1];
        int k = 0;
        int v = last;
        Arrays.fill(d, -1);
        while (v >= 0) {
            d[v] = 0;
            v = p[v];
        }

        v = last;
        qs = qt = 0;

        while (v >= 0) {
            Q[qt++] = v;
            int longest = 0;
            while (qs < qt) {
                int next = Q[qs++];
                for (int x : a[next]) {
                    if (d[x] == -1) {
                        d[x] = d[next] + 1;
                        Q[qt++] = x;
                        longest = Math.max(longest, d[x]);
                    }
                }
            }
            sz[k++] = longest;
            v = p[v];
        }

        int res = 0;
        for (int x : sz) {
            res = Math.max(res, x);
        }
        res += sz.length - 1;
        int d = sz.length;
        if (d < 30000) {
            for (int i = 0; i < d; i++) {
                int tmp = sz[i];
                for (int j = i + 1; j < d; j++) {
                    int kk = j-i;
                    res = Math.max(res, tmp + sz[j] + Math.max(d - kk, kk));
                }
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
