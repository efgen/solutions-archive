import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
    static final int mod = 1000000000+7;
    TreeSet<Integer> t = new TreeSet<Integer>();
    int[] g;
    void go(int n, int k, int last, int gr) {
        if (n==0) return;
        if (k==1) {
            if (last == 0) return;
            t.add(gr^g[n]);
            return;
        }
        for (int x=last; x<=n; x++) {
            go(n-x, k-1, x, gr^g[x]);
        }
    }
    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        g = new int[n+1];
        if (k==2) {
            for (int i=1; i<=n; i++) g[i] = (i+1)%2;
        } else
        if (k==3) {
            for (int v = 1; v <= n; v++) {
                t.clear();
                ;
                go(v, k, 0, 0);
                for (int x = 0; x <= n; x++)
                    if (!t.contains(x)) {
                        g[v] = x;
                        break;
                    }
              //  out.println(v + " " + g[v]);
            }
        } else {
            for (int i=1; i<=n; i++) g[i] = i-1;
        }
        int[][] a = new int[n+1][n+1];
        int[][] b = new int[n+1][n+1];
       
        for (int i=0; i<=n; i++) a[i][g[i]] = 1;
        while (m-->1) {
            for (int i=1; i<n; i++)
                for (int j=1; i+j<=n; j++)
                        for (int gr=0; gr<=i; gr++) {
                            b[i+j][gr^g[j]] += a[i][gr];
                            if (b[i+j][gr^g[j]] >= mod) {
                                b[i+j][gr^g[j]] -= mod;
                            }
                        }


            for (int i=0; i<=n; i++)
                for (int j=0; j<=i; j++) {
                    a[i][j] = b[i][j];
                    b[i][j] = 0;
                }
        }

        long res = 0;
        for (int i=1; i<=n; i++) res += a[n][i];
        out.println(res%mod);




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
        } catch (IOException e) {
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
