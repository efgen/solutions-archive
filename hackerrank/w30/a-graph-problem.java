import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main implements Runnable {

    int n;
    boolean[][] a;
    boolean[] f;
    Vector<Integer> res = new Vector<>();
    long bestV = 0, bestSz = 2;

    void go(int val, int sz) {
        int best = -1, bestCnt = 0;
        for (int x = 0; x < n; x++)
            if (!f[x]) {
                int cnt = 0;
                for (int i = 0; i < n; i++)
                    if (f[i]) {
                        for (int j = i + 1; j < n; j++)
                            if (f[j] && a[i][j] && a[x][i] && a[x][j]) cnt++;
                    }

                if (cnt > bestCnt) {
                    bestCnt = cnt;
                    best = x;
                }
            }
        if (bestCnt == 0) return;
        f[best] = true;
        val += bestCnt;
        sz++;
        if (val * bestSz > bestV * sz) {
            bestSz = sz;
            bestV = val;
            res.clear();
            for (int i = 0; i < n; i++) if (f[i]) res.add(i);
        }
        go(val, sz);
        f[best] = false;

    }

    void solve() throws IOException {
        n = nextInt();
        a = new boolean[n][n];
        f = new boolean[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt() == 1;
            }
        res.add(0);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (a[i][j]) {
                    f[i] = true;
                    f[j] = true;
                    go(0, 2);
                    f[i] = false;
                    f[j] = false;
                }
            }
        out.println(res.size());
        for (int x : res) out.print((x + 1) + " ");


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
