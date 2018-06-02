import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main implements Runnable {

    int[] cnt;

    int med(int d) {
        int[] a = Arrays.copyOf(cnt, cnt.length);
        int r = d / 2;
        if (d % 2 == 1) {
            r++;
        }
        int res = 0;
        boolean odd = d % 2 == 1;
        for (int k = 0; k <= 200; k++) {
            while (r > 0 && a[k] > 0) {
                a[k]--;
                r--;
            }
            if (r == 0) {
                res += k;
                if (d % 2 == 0) {
                    d--;
                    r++;
                    if (a[k] > 0) {
                        return 2 * k;
                    }
                } else {
                    break;
                }
            }
        }
        return res * (odd ? 2 : 1);
    }

    void solve() throws IOException {
        int n = nextInt();
        int d = nextInt();
        cnt = new int[201];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < d; i++) {
            cnt[a[i]]++;
        }
        int res = 0;
        for (int i = d; i < n; i++) {
            int m = med(d);
            //out.println(m);
            if (a[i] >= m) {
                res++;
            }
            cnt[a[i - d]]--;
            cnt[a[i]]++;
        }
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