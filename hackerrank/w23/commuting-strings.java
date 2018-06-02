import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main implements Runnable {
    void solve() throws IOException {
        String ss = next();
        char[] s = (ss + ss).toCharArray();
        int m = nextInt();
        int n = s.length / 2;
        int[] z = new int[2 * n];
        int l = 0, r = 0;
        for (int i = 1; i < 2 * n; i++) {
            if (i <= r) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }

            while (i + z[i] < 2 * n && s[z[i]] == s[i + z[i]])
                ++z[i];

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (z[i] >= n) {
                res = i;
                break;
            }
        }

        out.print(m / res);

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
