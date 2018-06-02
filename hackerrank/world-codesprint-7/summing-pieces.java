import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {
    long mod = 1000000000 + 7;
    long[] cp2;

    long p2(int k) {
        if (k < 1) return 1;
        return cp2[k];
    }

    void solve() throws IOException {
        int n = nextInt();
        cp2 = new long[n];
        long[] sq = new long[n];
        cp2[0] = 1;
        for (int i = 1; i < n; i++) {
            cp2[i] = cp2[i - 1] * 2 % mod;
            sq[i] = (long) i * i % mod;
        }

        long[] a = new long[n];
        long[] c = new long[n + 1];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = i * p2(n - 2 - i) + sum[i - 1];
            sum[i] %= mod;
        }
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
           // a[i] = i;
        }

        long res = 0;
        long res2 = 0, mul2 = 0;
        int bound = (n + 1) / 2;

        long cathTwoRabbits = -1;

        for (int p = 1; p <= Math.min(bound, 3); p++) {
            //for (int p = 1; p <= bound; p++) {
            long mul = n + (p == 1 ? 1 : 2) * (n - 1);
            c[n] = 1;
            c[n - 1] = (p == 1 ? 1 : 2);
            for (int k = 1; k < p; k++) {
                mul += sq[k] * p2(n - k - 2);
                mul %= mod;
                c[k] = k;
            }
            for (int k = p; k < n - 1; k++) {
                int add = 1;
                if (p + k > n) add++;
                long t = Math.min(n - k + 1, p) + add;
                mul += (k * t % mod) * p2(n - k - 2);
                mul %= mod;
                c[k] = t;
            }
            res = res + mul * ((2 * p > n) ? a[p - 1] : a[p - 1] + a[n - p]);
            res %= mod;
            mul2 = 0;
            for (int i = 1; i <= n; i++) {
                mul2 += c[i] * i % mod * p2(n - i - 2);
                mul2 %= mod;
            }
            if (p <= 3) {
                res2 = res2 + mul2 * ((2 * p > n) ? a[p - 1] : a[p - 1] + a[n - p]);
                res2 %= mod;
            }

//            out.print(p + ": ");
//            for (int i = 1; i <= n; i++) {
//                out.print(c[i] + " ");
//            }
//            out.println();
            if (p == 3) cathTwoRabbits = mul2;
        }
        mul2 = cathTwoRabbits;
        for (int p = 3; p <= bound; p++) {
            mul2 -= (sum[n - p] - sum[p - 1]) * (p + 1);
            mul2 %= mod;
            mul2 += (sum[n - p - 1] - sum[p]) * (p + 2);
            mul2 %= mod;
            mul2 += p * (sum[p] - sum[p - 1]);
            mul2 %= mod;
            mul2 += (p + 3) * (sum[n - p] - sum[n - p - 1]);
            mul2 = (mod + mul2 % mod) % mod;

            int np = p + 1;
            if (np <= bound) {
                res2 = res2 + mul2 * ((2 * np > n) ? a[np - 1] : a[np - 1] + a[n - np]);
                res2 %= mod;
            }
        }
        out.println(res2);
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
