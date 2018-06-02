import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main implements Runnable {

    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[][] a = new int[m][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++)
                a[j][i] = nextInt();
        }
        for (int i=0; i<m; i++) {
            Arrays.sort(a[i]);
            int[] d = a[i];
            long res = d[0];
            for (int j=0; j<n; j++)
                res += d[j]-d[0];
            long best = res;
            int point = d[0];
            for (int j=1; j<n; j++) {
                long t = d[j]-d[j-1];
                res += t * j;
                res -= (n-j)*t;
                if (res < best) {
                    best = res;
                    point = d[j];
                }
            }
            out.print(point+" ");
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
