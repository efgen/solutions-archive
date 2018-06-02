import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable {


    void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = nextInt();
        }
        if (n>25) {
            out.print(0);
            out.flush();
            System.exit(0);
        }
        int sz = 1<<n;

        long[] d = new long[sz];

        for (int msk=0; msk<sz; msk++) {
            for (int i=0; i<n; i++)
                if ((msk&(1<<i))!=0) {
                    for (int j=i+1; j<n; j++)
                        if ((msk&(1<<j))!=0)
                            d[msk] += Math.abs(a[i]-a[j]);
                    d[msk] += d[msk^(1<<i)];
                    break;
                }
        }
        long all = d[sz-1];
        long res = Long.MAX_VALUE;
        for (int msk=0; msk<sz; msk++)
            if (Integer.bitCount(msk) == k) {
                res = Math.min(res, all-d[msk]-d[(sz-1)^msk]);
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
