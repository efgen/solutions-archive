import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;


public class Main implements Runnable {

    void solve() throws IOException {
        long L = nextLong();
        long R = nextLong();
        BigDecimal pi = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923");
        long resn = 3, resd = 1;
        BigDecimal best = BigDecimal.ONE;
        for (long d = L; d <= R; d++) {
            BigDecimal D = BigDecimal.valueOf(d);
            BigDecimal t = pi.multiply(D);
            BigDecimal t1 = t.setScale(0, RoundingMode.FLOOR);
            BigDecimal t2 = t.setScale(0, RoundingMode.CEILING);
            BigDecimal r1 = t.subtract(t1).divide(D, 100, BigDecimal.ROUND_HALF_EVEN);
            BigDecimal r2 = t2.subtract(t).divide(D, 100, BigDecimal.ROUND_HALF_EVEN);
            if (r1.compareTo(best) < 0) {
                best = r1;
                resn = t1.longValue();
                resd = d;
            }
            if (r2.compareTo(best) < 0) {
                best = r2;
                resn = t2.longValue();
                resd = d;
            }
        }
        out.print(resn + "/" + resd);
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
