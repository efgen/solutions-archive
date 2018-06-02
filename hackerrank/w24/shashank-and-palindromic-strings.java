import java.io.*;
import java.util.*;

public class Main implements Runnable {
    static final int mod = 1000000000 + 7;
    static char[] s;
    static int[] c;
    static boolean[] first, last;
    static int N;
    static int[] mem;

    static int f(int L, int R, boolean needL, boolean needR) {
        if (L > R) return 0;
        if (L == R) return 1;
        boolean freeL = (c[L] == c[L + 1]) || !needL;
        boolean freeR = (c[R] == c[R - 1]) || !needR;
        if (L + 1 == R) {
            int res = 0;
            if (s[L] == s[R]) res++;
            if (freeL) res++;
            if (freeR) res++;
            return res;
        }

        int key = 0;
        if (needL) {
            if (needR) key = 3;
            else key = 2;
        } else {
            if (needR) key = 1;
            else key = 0;
        }
        key *= N * N;
        key += L * N + R;
        if (mem[key] >= 0) {
            return mem[key];
        }
        int res = 0;

        if (freeL) res += f(L + 1, R, first[L + 1] || needL, needR);
        if (freeR) res += f(L, R - 1, needL, last[R - 1] || needR);
        if (res >= mod) res -= mod;
        if (freeL && freeR) {
            int middle = f(L + 1, R - 1, first[L + 1] || needL, last[R - 1] || needR);
            res = (res + mod - middle) % mod;
        }

        if (s[L] == s[R]) {
            res += f(L + 1, R - 1, first[L + 1], last[R - 1]);
            if (c[R] - c[L] <= 1) res++;
        }
        if (res >= mod) res -= mod;
        mem[key] = res;
        return res;
    }

    void solve() throws IOException {
        int tests = nextInt();
        mem = new int[4 * 1000 * 1000];
        while (tests-- > 0) {
            int n = nextInt();
            int[] len = new int[n];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String w = next();
                sb.append(w);
                len[i] = w.length();
            }
            s = sb.toString().toCharArray();
            c = new int[s.length];
            first = new boolean[s.length];
            last = new boolean[s.length];
            int cur = 0;
            boolean isFirst = true;
            for (int i = 0; i < s.length; i++) {
                c[i] = cur;
                first[i] = isFirst;
                isFirst = false;
                len[cur]--;
                if (len[cur] == 0) {
                    last[i] = true;
                    isFirst = true;
                    cur++;
                }
            }
            N = s.length;
            Arrays.fill(mem, 0, 4 * N * N, -1);
            out.println(f(0, s.length - 1, true, true));
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