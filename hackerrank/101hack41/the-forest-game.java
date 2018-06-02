import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main implements Runnable {

    class Tree implements Comparable<Tree> {
        int v;
        long sum;
        Vector<Tree> ch;

        public Tree(int v) {
            this.v = v;
            ch = new Vector<>();
        }

        @Override
        public int compareTo(Tree o) {
            return o.v - v;
        }
    }

    void update(Tree t) {
        for (Tree c : t.ch) {
            update(c);
            t.sum += c.v + c.sum;
        }
    }

    void solve() throws IOException {
        int n = nextInt();
        long res = 0;
        long all = 0;
        Tree[] roots = new Tree[n];
        for (int i = 0; i < n; i++) {
            roots[i] = new Tree(nextInt());
            all += roots[i].v;
        }

        for (int i = 1; i < n; i++) {
            int p = nextInt() - 1;
            roots[p].ch.add(roots[i]);
        }
        update(roots[0]);
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        pq.add(roots[0]);
        while (!pq.isEmpty()) {
            Tree t = pq.poll();
            all -= t.v;
            res += all;
            for (Tree c : t.ch) {
                pq.add(c);
            }
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
