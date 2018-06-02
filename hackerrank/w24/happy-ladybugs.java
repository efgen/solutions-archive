import java.io.*;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            char[] s = ("." + next() + ".").toCharArray();
            boolean ok = true;
            boolean emptyCell = false;
            int[] cnt = new int[26];
            for (int i = 1; i <= n; i++) {
                ok &= s[i] == s[i - 1] || s[i] == s[i + 1];
                emptyCell |= s[i] == '_';
                if (s[i] != '_') {
                    cnt[s[i] - 'A']++;
                }
            }
            if (!ok && emptyCell) {
                ok = true;
                for (int i = 0; i < 26; i++)
                    ok &= cnt[i] != 1;
            }
            if (ok) {
                out.println("YES");
            } else {
                out.println("NO");
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