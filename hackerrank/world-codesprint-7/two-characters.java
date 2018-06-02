import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
        int n = nextInt();
        char[] s = next().toCharArray();
        int res = 0;
        for (char x = 'a'; x <= 'z'; x++) {
            for (char y = 'a'; y <= 'z'; y++) {
                if (x == y) continue;
                boolean ok = true;
                boolean needX = true;
                int len = 0;
                for (char c : s) {
                    if (c == x || c == y) {
                        if (needX) {
                            ok &= c == x;
                        } else {
                            ok &= c == y;
                        }
                        needX ^= true;
                        if (!ok) {
                            break;
                        }
                        len++;
                    }
                }
                if (ok && len > res) {
                    res = len;
                }
            }
        }
        if (res == 1) res = 0;
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
