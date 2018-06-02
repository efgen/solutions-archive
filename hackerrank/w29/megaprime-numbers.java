import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;


public class Main implements Runnable {
    //    TreeSet<Long> hs = new TreeSet<>();
    int res = 0;

    void gen(long n, int len) {
        if (len == 13) return;
        if (BigInteger.valueOf(n).isProbablePrime(10)) {
            //out.println(n);;
            //hs.add(n);
            res++;
        }
        n *= 10;
        len++;
        gen(n + 2, len);
        gen(n + 3, len);
        gen(n + 5, len);
        gen(n + 7, len);
    }

    //1078313
    //2, 4130806001517, 149795463772692060, 186635894390467037, 3967304179347715805
    int sz = 17;
    int[] a = new int[sz];
    long x;
    int[] nextD = {2, 2, 3, 5, 5, 7, 7, 2, 2, 2};

    void increment(int i, long d) {
        while (a[i] >= 7) {
            x -= (a[i] - 2) * d;
            a[i] = 2;
            d *= 10;
            i++;
        }
        int nd = nextD[a[i]];
        x -= (a[i] - nd) * d;
        a[i] = nd;
    }

    void init() {
        int i = sz - 1;

        while (a[i] == 0) i--;
        while (i >= 0 && (a[i] == 2 || a[i] == 3 || a[i] == 5 || a[i] == 7)) {
            i--;
        }
        if (i < 0) {
            increment(0, 1);
        } else {
            long d = BigInteger.TEN.pow(i).longValue();
            increment(i, d);
            while (i > 0) {
                i--;
                d /= 10;
                x -= (a[i] - 2) * d;
                a[i] = 2;
            }
        }

    }

    void solve() throws IOException {
        long L = nextLong() - 1;
        if (L == 0) L++;
        long R = nextLong();
        x = L;
        for (int i = 0; L > 0 && i < 16; i++) {
            a[i] = (int) (L % 10);
            L /= 10;
        }
        init();
        int res = 0;
        while (x <= R) {
            if (BigInteger.valueOf(x).isProbablePrime(20)) res++;
            increment(0, 1);
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
