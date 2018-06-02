import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable {

    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[m];
        int min = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            a[i] = nextInt();
            if (a[i] < min) {
                min = a[i];
            }
        }
        long l = 1, r = ((long)n)*min;
        while (l < r) {
            long mid = (l+r)/2;
            long count = 0;
            for (int x:a) {
                count += mid / x;
            }
            if (count >= n) r = mid; else l = mid+1;
        }
        out.print(r);
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
