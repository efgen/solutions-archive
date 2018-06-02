import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main_CS7_6 implements Runnable {
    class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return y - o.y;
        }

        boolean intersect(Point p) {
            if (x <= p.x) {
                return p.x <= y;
            } else {
                return x <= p.y;
            }
        }
    }

    static int N;
    static boolean[][] a;
    static int[] comp, ord;
    static int cnt = 0;
    static boolean[] f;
    static int left, right;

    static void dfs1(int v) {
        f[v] = true;
        for (int x = left; x < right; x++) {
            if (a[v][x] && !f[x]) {
                dfs1(x);
            }
        }
        ord[cnt++] = v;
    }

    static void dfs2(int v, int c) {
        comp[v] = c;
        for (int x = left; x < right; x++) {
            if (a[x][v] && comp[x] == 0) {
                dfs2(x, c);
            }
        }
    }

    void solve() throws IOException {
        int q = nextInt();
        while (q-- > 0) {
            int n = nextInt();

            Point[] live = new Point[n];
            Point[] repeat = new Point[n];
            for (int i = 0; i < n; i++) {
                live[i] = new Point(nextInt(), nextInt());
                repeat[i] = new Point(nextInt(), nextInt());
            }
            N = 2 * n;
            a = new boolean[N][N];
            for (int i = 0; i < N; i += 2)
                for (int j = 0; j < N; j += 2) {
                    if (i == j) continue;
                    a[i][j ^ 1] = live[i / 2].intersect(live[j / 2]);
                    a[i][j] = live[i / 2].intersect(repeat[j / 2]);
                    a[i ^ 1][j ^ 1] = repeat[i / 2].intersect(live[j / 2]);
                    a[i ^ 1][j] = repeat[i / 2].intersect(repeat[j / 2]);
                }

            int bl = 0, br = 0;
            int L = 1, R = n;
            f = new boolean[N];
            comp = new int[N];
            ord = new int[N];
            while (L < R) {
                int len = (L + R + 1) / 2;
                boolean ok = false;
                for (int st = 0; !ok && st <= n - len; st++) {
                    left = 2 * st;
                    right = 2 * (st + len);
                    Arrays.fill(f, left, right, false);
                    Arrays.fill(comp, left, right, 0);
                    cnt = 0;
                    for (int v = left; v < right; v++) {
                        if (!f[v]) {
                            dfs1(v);
                        }
                    }
                    int compCnt = 0;
                    for (int i = cnt - 1; i >= 0; --i) {
                        int v = ord[i];
                        if (comp[v] == 0) {
                            dfs2(v, ++compCnt);
                        }
                    }

                    ok = true;
                    for (int i = left; i < right; i += 2)
                        ok &= comp[i] != comp[i ^ 1];

                    if (ok) {
                        bl = st;
                        br = st + len - 1;
                        break;
                    }

                }

                if (!ok) {
                    R = len - 1;
                } else {
                    L = len;
                }
            }

            bl++;
            br++;
            out.println(bl + " " + br);
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
        new Thread(new Main_CS7_6()).start();
    }
}
