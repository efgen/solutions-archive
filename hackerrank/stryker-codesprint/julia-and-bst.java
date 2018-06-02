import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {

    class Tree {
        int key;
        Tree l, r;
    }

    void solve() throws IOException {
        int n = nextInt();
        Tree root = new Tree();
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            Tree t = root;
            int d = 0;
            while (t.key != 0) {
                if (x < t.key) {
                    t = t.l;
                } else {
                    t = t.r;
                }
                d++;
            }
            t.key = x;
            t.l = new Tree();
            t.r = new Tree();
            cnt[d]++;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += ((long) cnt[i]) * i;
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
