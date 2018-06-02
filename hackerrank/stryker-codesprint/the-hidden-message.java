import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Main implements Runnable {
    void solve() throws IOException {
        char[] t = br.readLine().toCharArray();
        String[] ps = br.readLine().trim().split(" ");
        int w = 0;
        char[] p;
        p = ps[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        int start = -1, finish = 0;
        int cost = ps.length-1;
        boolean ok = false;
        for (int i = 0; i < t.length; i++) {
            int l = 0;
            while (l < p.length && i + l < t.length && p[l] == t[i + l]) {
                l++;
            }
            if (l == p.length) {
                if (w > 0) {
                    sb.append(" ");
                } else {
                    start = i;
                }
                sb.append(ps[w]);
                sb.append(" " + i + " " + (i + ps[w].length() - 1));
                if (i<=finish) {
                    cost += finish-i;
                } else {
                    cost += i - finish;
                }
                finish = i + ps[w].length();
                w++;
                if (w < ps.length) {
                    p = ps[w].toCharArray();
                } else {
                    ok = true;
                    cost += t.length-finish;
                    break;
                }
            }
        }
        if (ok) {
            out.println("YES");
            out.println(sb);
            out.print(cost);
        } else {
            out.println("NO");
            out.println(sb.length() > 0 ? sb : 0);
            out.print(0);
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
