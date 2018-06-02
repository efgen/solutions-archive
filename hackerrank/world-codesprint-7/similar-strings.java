import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_CS7_7 implements Runnable {
    static final int maxn = 14900000;
    static char[] s;
    static int[] ind = new int[10];
    static int[][] automata = new int[10][maxn];
    static int[] finish = new int[maxn];
    static int sz = 1;


    void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        s = next().toCharArray();
        for (int i = 0; i < n; i++) s[i] -= 'a';

        for (int i = 0; i < n; i++) {
            int p = 0;
            Arrays.fill(ind, -1);
            int cnt = 0;
            for (int k = i; k < n; k++) {
                int c = s[k];
                if (ind[c] == -1) {
                    ind[c] = cnt++;
                }
                c = ind[c];
                if (automata[c][p] == 0) {
                    automata[c][p] = sz++;
                    if (sz==automata[0].length-1) break;
                }
                p = automata[c][p];
                finish[p]++;
            }
        }


        while (q-- > 0) {
            int l = nextInt() - 1;
            int r = nextInt() - 1;
            Arrays.fill(ind, -1);
            int cnt = 0;
            int p = 0;
            for (int k = l; k <= r; k++) {
                int c = s[k];
                if (ind[c] == -1) {
                    ind[c] = cnt++;
                }
                c = ind[c];
                p = automata[c][p];
            }
            out.println(finish[p]);
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
        new Thread(new Main_CS7_7()).start();
    }
}
