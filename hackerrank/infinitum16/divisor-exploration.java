import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable {
    static final int maxn = 100000*2+10;
    static final long mod = 1000000000+7;
    long pow(long x, long n) {
        long a = 1, b = x;
        while (n>0) {
            if (n%2==1) {
                a = a*b%mod;
            }
            b = b*b%mod;
            n >>= 1;
        }
        return a;
    }

    long inv(long x) {
        return pow(x, mod-2);
    }
    void solve() throws IOException {
        long[] f = new long[maxn];
        long[] p = new long[maxn];
        f[0] = p[0] = 1;
        for (int i=1; i<maxn; i++) {
            f[i] = f[i-1]*i%mod;
            p[i] = p[i-1]*2%mod;
        }
        int d = nextInt();
        while (d-->0) {
            int n = nextInt();
            int a = nextInt()+2;
            long res = f[a+n] * inv(f[a-1]) % mod;
            res = res * res % mod;
            res = res * inv(a) % mod;
            res = res * inv(a+n) % mod;
            res = res * inv(p[n]) % mod;
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
