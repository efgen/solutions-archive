import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
    static final int inf = 1000000000;

    class Efge {
        int x, w;
        public Efge(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
    class Point implements Comparable<Point>{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return y-o.y;
        }
    }
    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int sz = 1<<k;
        int[] color = new int[n];
        for (int i=0; i<n; i++) {
            int t = nextInt();
            while (t-->0) {
                int x = nextInt();
                color[i] |= 1<<(x-1);
            }
        }
        Vector<Efge>[] a = new Vector[n];
        for (int i=0; i<n; i++) {
            a[i] = new Vector<Efge>();
        }
        while (m-->0) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            int w = nextInt();
            a[x].add(new Efge(y, w));
            a[y].add(new Efge(x, w));
        }
        int[] d = new int[sz*n];
        Arrays.fill(d, inf);
        PriorityQueue<Point> Q = new PriorityQueue<Point>();
        Q.add(new Point(color[0], 0));
        d[color[0]] = 0;
        while (!Q.isEmpty()) {
            Point cur = Q.poll();
            if (cur.y > d[cur.x]) continue;
            int v = cur.x;
            int realV = v/sz;
         //   out.println(v/sz+" "+v%sz+" "+d[v]);

            int curMsk = v & (sz-1);
            for (Efge e : a[realV]) {
                int u = e.x * sz + (curMsk|color[e.x]);
                if (d[v] + e.w < d[u]) {
                    d[u] = d[v] + e.w;
                    Q.add(new Point(u, d[u]));
                }
            }
        }
        int res = inf;
        for (int msk1=0; msk1<sz; msk1++) {
            for (int msk2=0; msk2<sz; msk2++) {
                if ((msk1 | msk2) == sz - 1) {
                    res = Math.min(res, Math.max(d[(n-1)*sz+msk1], d[(n-1)*sz+msk2]));
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
