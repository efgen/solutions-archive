import java.io.*;
import java.util.*;

public class Main implements Runnable {
    class Edge {
        int x, y;
    }

    static int n;
    static Vector<Integer>[] a;
    static Vector<Integer>[] other;
    static int[] w;
    static long[] d1, d2;
    static boolean[] f, can;

    static void dfs(int v) {
        f[v] = true;
        d1[v] = w[v];
        d2[v] = 0;
        for (int x : a[v]) {
            if (!f[x]) {
                dfs(x);
                d2[v] += Math.max(d1[x], d2[x]);
                d1[v] += d2[x];
            }
        }
        if (!can[v]) {
            d1[v] = d2[v];
        }
    }

    void solve() throws IOException {
        n = nextInt();
        int m = nextInt();
        a = new Vector[n];
        other = new Vector[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = new Vector<>();
            other[i] = new Vector<>();
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            a[x].add(y);
            a[y].add(x);
        }
        int root = n / 2;
        int[] Q = new int[n];
        int[] d = new int[n];
        int[] p = new int[n];
        Arrays.fill(p, -1);
        int qs = 0, qt = 0;
        Q[qt++] = root;
        d[root] = 1;
        Vector<Edge> toRemove = new Vector<>();
        Vector<Edge> special = new Vector<>();

        while (qs < qt) {
            int v = Q[qs++];
            for (int x : a[v]) {
                if (d[x] == 0) {
                    d[x] = d[v] + 1;
                    p[x] = v;
                    Q[qt++] = x;
                } else {
                    if (x != p[v]) {
                        Edge e = new Edge();
                        e.x = x;
                        e.y = v;
                        toRemove.add(e);
                        other[x].add(v);
                        if (e.x < e.y) {
                            special.add(e);
                        }
                    }
                }
            }
        }
        for (Edge e : toRemove) {
            a[e.x].removeElement(e.y);
        }


        int N = special.size();
        int sz = 1 << N;
        long res = 0;
        f = new boolean[n];
        can = new boolean[n];
        d1 = new long[n];
        d2 = new long[n];
        for (int msk = sz - 1; msk >= 0; --msk) {
            Arrays.fill(f, false);
            Arrays.fill(can, true);
            for (int i = 0; i < N; i++) {
                if ((msk & (1 << i)) != 0) {
                    can[special.elementAt(i).x] = false;
                } else {
                    can[special.elementAt(i).y] = false;
                }
            }
            dfs(root);
            long curRes = Math.max(d1[root], d2[root]);
            if (curRes > res) {
                res = curRes;
            }
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
