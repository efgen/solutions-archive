import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main implements Runnable {

    void solve() throws IOException {
        int W = nextInt();
        int B = nextInt();
        int P = nextInt();
        int[][] a = new int[W][P];
        int[][] b = new int[B][P];
        for (int i=0; i<W; i++)
            for (int j=0; j<P; j++)
                a[i][j] = nextInt();
        for (int i=0; i<B; i++)
            for (int j=0; j<P; j++)
                b[i][j] = nextInt();

        int sz = 1<<W;
        long[] products = new long[P];
        int[] res = new int[B];
        Arrays.fill(res, Integer.MAX_VALUE);

        for (int msk=1; msk<sz; msk++) {
            Arrays.fill(products, 0);
            int cnt = 0;
            for (int i=0; i<W; i++)
                if ((msk & (1<<i)) != 0) {
                    cnt++;
                    for (int k=0; k<P; k++) {
                        products[k] += a[i][k];
                    }
                }

            for (int i=0; i<B; i++) {
                boolean ok = true;
                for (int j=0; j<P; j++)
                    if (b[i][j] > products[j]) {
                        ok = false;
                        break;
                    }
                if (ok) {
                    res[i] = Math.min(res[i], cnt);
                }
            }
        }

        for (int i=0; i<B; i++)
            if (res[i] == Integer.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println(res[i]);
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
