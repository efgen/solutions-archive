import java.io.*;
import java.util.*;

public class Main implements Runnable {

    static int lps(String seq) {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }

        return L[0][n - 1];
    }

    void solve() throws IOException {
        int q = nextInt();
        while (q-- > 0) {
            int n = nextInt();
            int k = nextInt();
            String s = next();
            int L = lps(s);
            int res = 0;
            for (int p = 0; p <= n; p++) {
                String prefix = s.substring(0, p);
                String suffix = s.substring(p, n);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (lps(prefix + c + suffix) >= L + k) {
                        res++;
                    }
                }
            }
            out.println(res);

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
        new Thread(new Main()).start();
    }
}
