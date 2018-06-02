import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;

public class Main implements Runnable {
    static final long mod = 1000000000 + 7;

    long pow(long x, long n) {
        long a = 1, b = x % mod;
        while (n > 0) {
            if (n % 2 == 1) {
                a = a * b % mod;
            }
            b = b * b % mod;
            n >>= 1;
        }
        return a;
    }

    char[] s;
    int pos;

    long parseLong() throws ParseException {
        int st = pos;
        long t = 0;
        while (pos < s.length && Character.isDigit(s[pos])) {
            t = 10 * t + s[pos++] - '0';
        }
        if (st == pos) throw new ParseException("syntax", pos);
        return t;
    }

    long parseMultiple() throws ParseException {
        long current = parseLong();
        while (pos < s.length - 1 && s[pos] == '*' && s[pos + 1] == '*') {
            pos += 2;
            long power = parseLong();
            current = pow(current, power);
        }
        return current % mod;
    }

    long parseMul() throws ParseException {
        long res = parseMultiple();
        while (pos < s.length && s[pos] == '*') {
            pos++;
            res = res * parseMultiple() % mod;
        }
        return res;
    }

    void solve() throws IOException {
        int tests = nextInt();
        while (tests-- > 0) {
            s = next().toCharArray();
            pos = 0;
            long res;
            try {
                res = parseMul();
            } catch (ParseException e) {
                res = -1;
            }
            if (res < 0 || pos != s.length) {
                out.println("Syntax Error");
            } else {
                out.println(res);
            }
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
