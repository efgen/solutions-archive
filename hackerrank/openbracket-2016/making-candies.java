import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {


    void solve() throws IOException {

        BigInteger m = BigInteger.valueOf(nextLong());
        BigInteger w = BigInteger.valueOf(nextLong());
        BigInteger p = BigInteger.valueOf(nextLong());
        BigInteger n = BigInteger.valueOf(nextLong());
        m = m.multiply(w);
        BigInteger[] r = n.divideAndRemainder(m);
        if (!r[1].equals(BigInteger.ZERO)) {
            r[0] = r[0].add(BigInteger.ONE);
        }
        out.print(r[0]);


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