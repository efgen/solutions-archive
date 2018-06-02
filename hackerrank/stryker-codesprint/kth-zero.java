import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {
    int[] t;
    int n;

    int sum(int r) {
        int res = 0;
        for (; r >= 0; r = (r & (r + 1)) - 1)
            res += t[r];
        return res;
    }

    void update(int i, int d) {
        for (; i < n; i = (i | (i + 1)))
            t[i] += d;
    }


    void solve() throws IOException {
        n = nextInt();
        int m = nextInt();
        boolean[] arr = new boolean[n];
        t = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt() == 0;
            if (arr[i]) update(i, 1);
        }
        while (m-- > 0) {
            int t = nextInt();
            if (t == 1) {
                int k = nextInt();
                int L = 0, R = n;
                while (L < R) {
                    int mid = (L + R) / 2;
                    if (sum(mid) >= k) {
                        R = mid;
                    } else {
                        L = mid + 1;
                    }
                }
                out.println(L== n || sum(L) != k ? "NO" : L);
            } else {
                int p = nextInt();
                boolean x = nextInt() == 0;
                if (x != arr[p]) {
                    arr[p] = x;
                    update(p, x ? 1 : -1);
                }
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
