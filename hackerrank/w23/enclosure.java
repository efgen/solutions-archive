import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main implements Runnable {
    double eps = 1e-9;

    void solve() throws IOException {
        int n = nextInt();
        int[] len = new int[n];
        double l = 0, r = 1e+9;
        for (int i = 0; i < n; i++) {
            len[i] = nextInt();
            l = Math.max(l, len[i] / 2.0);
        }
        while (r - l > eps) {
            double R = (l + r);
            double ang = 0;
            for (int x : len) {
                ang += Math.asin(x / R);
            }
            if (ang > Math.PI) {
                l = R / 2;
            } else {
                r = R / 2;
            }
        }
        r = (l + r) / 2;
        //out.println(r);

        double x = 0, y = 0;
        double cx = Math.sqrt(r * r - (len[0] * len[0]) / 4.0);
        double cy = len[0] / 2.0;
        double ang = -Math.acos(len[0] / (2 * r)) - Math.PI / 2;

        for (int a : len) {
            out.printf("%1.6f\n%1.6f\n\n", x, y);
            ang -= 2 * Math.asin(a / (2 * r));
            x = r * Math.cos(ang) + cx;
            y = r * Math.sin(ang) + cy;
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
