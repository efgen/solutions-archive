import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Main_5 implements Runnable {
    class Query implements Comparable<Query> {
        int idx, L, R;

        @Override
        public int compareTo(Query o) {
            return L - o.L;
        }
    }

    int n;
    int[] c;
    Vector<Integer>[] a;
    Vector<Query> queries = new Vector<>();
    boolean[] f;
    int time;

    int[] t, tree, start, finish;
    int fSize;
    int[] answer;

    void dfs(int v) {
        f[v] = true;
        start[v] = time;
        tree[time++] = c[v];
        for (int x : a[v]) {
            if (!f[x]) {
                dfs(x);
            }
        }
        finish[v] = time;
        tree[time++] = c[v];

    }

    int sum(int r) {
        int res = 0;
        for (; r >= 0; r = (r & (r + 1)) - 1)
            res += t[r];
        return res;
    }

    void update(int i, int d) {
        for (; i < fSize; i = (i | (i + 1)))
            t[i] += d;
    }

    void solve() throws IOException {
        n = nextInt();
        c = new int[n];
        HashMap<Integer, Integer> cMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int color = nextInt();
            if (!cMap.containsKey(color)) {
                cMap.put(color, cMap.size());
            }
            color = cMap.get(color);
            c[i] = color;
        }
        a = new Vector[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Vector<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            a[x].add(y);
            a[y].add(x);
        }

        f = new boolean[n];
        tree = new int[2 * n];
        start = new int[n];
        finish = new int[n];
        dfs(0);

        for (int v = 0; v < n; v++) {
            Query q = new Query();
            q.idx = v;
            q.L = start[v];
            q.R = finish[v];
            queries.add(q);
            q = new Query();
            q.idx = v + n;
            q.L = finish[v] + 1;
            q.R = start[v] + 2 * n - 1;
            queries.add(q);
        }
        Collections.sort(queries);

        Queue<Integer>[] positions = new LinkedList[cMap.size()];
        for (int i = 0; i < cMap.size(); i++) {
            positions[i] = new LinkedList<>();
        }
        fSize = 4 * n;
        t = new int[fSize];


        for (int i = 0; i < 2 * n; i++) {
            int c = tree[i];
            positions[c].add(i);
        }
        for (int i = 0; i < 2 * n; i++) {
            int c = tree[i];
            positions[c].add(i + 2 * n);
        }
        for (int i = 0; i < positions.length; i++) {
            update(positions[i].poll(), 1);
        }

        answer = new int[2 * n];
        int p = 0;
        for (Query q : queries) {
            while (p < q.L) {
                int c = tree[p];
                update(p, -1);
                if (!positions[c].isEmpty()) {
                    update(positions[c].poll(), 1);
                }
                p++;
            }
            answer[q.idx] = sum(q.R);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) answer[i] * answer[i + n];
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
        new Thread(new Main_5()).start();
    }
}
