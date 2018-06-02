import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable {

    static final int sq(int x) {
        return x * x;
    }

    void solve() throws IOException {
        int n = nextInt();
        boolean[][] a = new boolean[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            String s = next();
            for (int j = 0; j < n; j++)
                a[i + 1][j + 1] = s.charAt(j) == '.';
        }
        int maxBad = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                int minBad = sq(n + 1);
                for (int x = 0; x <= n + 1; x++)
                    for (int y = 0; y <= n + 1; y++) {
                        if (!a[x][y]) {
                            minBad = Math.min(sq(x - i) + sq(y - j), minBad);
                        }
                    }
                if (minBad > maxBad) maxBad = minBad;
            }
        int res = 0;
        while (sq(res) < maxBad) res++;
        out.print(res - 1);
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
