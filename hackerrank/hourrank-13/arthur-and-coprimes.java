import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main implements Runnable {

    int n = (int) Math.floor(Math.sqrt(1000000000)) + 1;
    int[] minPrime = new int[n];

    int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    long req(int L, int R, int x) {
        L--;
        if (L >= R) {
            return 0;
        }
        TreeSet<Integer> divs = new TreeSet<>();
        while (x > 1) {
            int d = minPrime[x];
            divs.add(d);
            x /= d;
        }
        int n = divs.size();
        int sz = 1 << n;
        Integer[] a = divs.toArray(new Integer[0]);
        long resL = 0, resR = 0;
        for (int msk = 0; msk < sz; msk++) {
            int mul = 1, sign = 1;
            for (int i = 0; i < n; i++) {
                if ((msk & (1 << i)) != 0) {
                    mul *= a[i];
                    sign *= -1;
                }
            }
            resL += L / mul * sign;
            resR += R / mul * sign;
        }
        return (resR - resL);
    }


    void solve() throws IOException {
        for (int i = 1; i < n; i++) minPrime[i] = i;
        for (int i = 2; i < n; i++) {
            if (minPrime[i] == i) {
                for (int j = i * i; j < n; j += i)
                    minPrime[j] = i;
            }
        }
        int K = nextInt();
       
        int sq = (int) Math.floor(Math.sqrt(K) + 1e-10);
        long resL = 0;
        for (int p = 2; p <= sq; p++) {
            resL += req(p + 1, K / p, p);
        }
        out.print(resL);

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
