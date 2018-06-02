import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main implements Runnable {

    class SuffixAutomata {
        private final Node root;
        private Node last;

        private class Node {
            Node link;
            final Node[] next;
            final int len;

            Node(Node o, int len) {
                next = o.next.clone();
                this.len = len;
            }

            Node(int len) {
                next = new Node[26];
                this.len = len;
            }
        }

        public SuffixAutomata(char[] s) {
            last = root = new Node(0);
            for (char c : s) {
                addChar(c);
            }
        }

        private void addChar(char symbol) {
            int c = symbol - 'a';
            Node cur = last;
            last = new Node(cur.len + 1);
            while (cur != null && cur.next[c] == null) {
                cur.next[c] = last;
                cur = cur.link;
            }

            if (cur != null) {
                Node q = cur.next[c];
                if (q.len == cur.len + 1) {
                    last.link = q;
                } else {
                    Node r = new Node(q, cur.len + 1);
                    r.link = q.link;
                    q.link = r;
                    last.link = r;
                    while (cur != null && cur.next[c] == q) {
                        cur.next[c] = r;
                        cur = cur.link;
                    }
                }
            } else {
                last.link = root;
            }
        }

        int LCS(char[] t) {
            Node cur = root;
            int l = 0, best = 0;
            for (char c : t) {
                c -= 'a';
                while (cur != root && cur.next[c] == null) {
                    cur = cur.link;
                    l = cur.len;
                }
                if (cur.next[c] != null) {
                    cur = cur.next[c];
                    l++;
                }
                if (l > best)
                    best = l;
            }
            return best;
        }
    }

    void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        char[][] a = new char[n][];
        SuffixAutomata[] sa = new SuffixAutomata[n];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        while (q-- > 0) {
            int x = nextInt();
            int y = nextInt();
            if (a[x].length < a[y].length || (a[x].length == a[y].length && sa[y] != null)) {
                int t = x;
                x = y;
                y = t;
            }
            if (sa[x] == null) {
                sa[x] = new SuffixAutomata(a[x]);
            }
            out.println(sa[x].LCS(a[y]));
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
