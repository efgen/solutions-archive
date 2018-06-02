import java.io.*;
import java.util.*;

public class Main implements Runnable {
    static final int mod = 1000000000 + 7;
    static boolean[][] a;
    static int n, m;

    static boolean isOk(int x, int y) {

        if (x < 2 || y < 2) {
            int cnt = 0;
            for (int i=0; i<Math.min(x+1, 3); i++)
                for (int j=0; j<Math.min(y+1, 3); j++)
                    if (a[x - i][y - j]) cnt++;
            return cnt<=2;
        }
        int cnt = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (a[x - i][y - j]) cnt++;
        return cnt == 2;
    }

    static int res = 0;

    static void go(int x, int y) {
        if (y == m) {
            y = 0;
            x++;
            if (x == n) {
                res++;
                return;
            }
        }
        if (isOk(x, y)) go(x, y + 1);
        a[x][y] = true;
        if (isOk(x, y)) go(x, y + 1);
        a[x][y] = false;
    }

    void solve() throws IOException {
        int c = nextInt();
        while (c-->0) {
            n = nextInt();
            m = nextInt();
            a = new boolean[n][m];
            res = 0;
            go(0, 0);
            out.println(res);
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