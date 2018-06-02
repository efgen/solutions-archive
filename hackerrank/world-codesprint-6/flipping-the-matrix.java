import java.io.*;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
       int t = nextInt();
        while (t-->0) {
            int n = nextInt();
            int[][] a = new int[n*2][n*2];
            int nn = n+n;
            for (int i=0; i<nn; i++)
                for (int j=0; j<nn; j++) {
                    a[i][j] = nextInt();
                }
            int res = 0;
            for (int i=0; i<n; i++)
                for (int j=0; j<n; j++)
                    res += Math.max(a[i][j], Math.max(a[nn-i-1][j], Math.max(a[i][nn-j-1], a[nn-i-1][nn-j-1])));
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
