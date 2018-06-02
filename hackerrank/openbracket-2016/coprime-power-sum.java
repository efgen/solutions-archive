import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Bern implements Runnable {
    int[] nc = {1, 1, 1, 1, 3, 2, 0, 1, 2, 1, -1, 0, 10, 15, 6, 0, -1, 0, 5, 6, 2, 1,
            0, -7, 0, 21, 21, 6, 0, 2, 0, -7, 0, 14, 12, 3, -3, 0, 20, 0, -42, 0,
            60, 45, 10, 0, -3, 0, 10, 0, -14, 0, 15, 10, 2, 5, 0, -33, 0, 66, 0,
            -66, 0, 55, 33, 6};
    long[] dc = {1, 2, 6, 4, 30, 12, 42, 24, 90, 20, 66};
    long[] s, sm;
    int K;
    long res = 0;

    long mod = 1000000000 + 7;

    long pow(long x, long n) {
        long a = 1, b = x % mod;
        while (n > 0) {
            if (n % 2 == 1) {
                a = a * b % mod;
            }
            b = b * b % mod;
            n >>= 1;
        }
        return a;
    }

    long inv(long x) {
        return pow(x, mod - 2);
    }

    long f(long n) {
        n %= mod;
        long res = 0;
        long p = n;
        int st = K * (K + 1) / 2;
        int end = st + K;
        for (int i = st; i <= end; i++) {
            res = (res + nc[i] * p) % mod;
            p = p * n % mod;
        }

        return res;
    }

    void go(int k, long n, long mult, int sigum) {
        if (n <= 0) return;
        if (k == s.length) {
            res = (res + f(n) * pow(mult, K) * sigum) % mod;
            return;
        }
        go(k + 1, n, mult, sigum);
        go(k + 1, n / s[k], mult * sm[k] % mod, -sigum);
    }

    void solve() throws IOException {
        for (int i = 0; i < dc.length; i++) {
            dc[i] = inv(dc[i]);
        }
        int q = nextInt();
        while (q-- > 0) {
            int n = nextInt();
            K = nextInt();
            long m = nextLong();
            s = new long[n];
            sm = new long[n];
            for (int i = 0; i < n; i++) {
                s[i] = nextLong();

            }
            Arrays.sort(s);
            for (int i = 0; i < n; i++) {
                sm[i] = s[i] % mod;
            }
            res = 0;
            go(0, m, 1, 1);
            if (res < 0) {
                res += mod;
            }
            res = res * dc[K] % mod;
            out.println(res);
        }
//        res = 0;
//        for (int i = 1; i <= 1000; i++) {
//            res += pow(i, 10);
//            res %= mod;
//        }
//        out.print(res);


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
        new Thread(new Main_Bern()).start();
    }
}