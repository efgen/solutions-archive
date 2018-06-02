import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {
    void solve() throws IOException {
        int n = nextInt();
        int sz = 2 * n - 1;
        int h = 0;
        while ((1 << h) < n) {
            h++;
        }
        h++;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < sz; i++) {
            int x = nextInt();
            if (!map.containsKey(x)) {
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
        }
        boolean ok = map.size() == n;
        TreeSet<Integer>[] f = new TreeSet[h + 1];
        for (int i = 1; i <= h; i++) {
            f[i] = new TreeSet<>();
        }
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            ok &= kv.getValue() <= h;
            if (!ok) break;
            f[kv.getValue()].add(kv.getKey());
        }
        ok &= f[h].size() == 1;
        if (!ok) {
            out.print("NO");
            return;
        }
        int[] t = new int[sz];
        t[0] = f[h].first();

        int pos = 0;
        int levelSize = 1;
        for (int l = h - 1; l > 0; l--) {
            ok &= levelSize == f[l].size();
            if (!ok) break;
            for (int i = pos; i < pos + levelSize; i++) {
                t[2 * i + 1] = t[i];
                int x = f[l].ceiling(t[i]);
                f[l].remove(x);
                t[2 * i + 2] = x;
            }
           
            pos += levelSize;
            levelSize *= 2;
        }


        if (ok) {
            for (int i = 0; i < n-1; i++)
                ok &= t[i] <= t[2 * i + 1] && t[i] <= t[2 * i + 2];
            if (!ok) {
                System.exit(123);
            }
//            for (int i = n - 2; i >= 0; i--) {
//                t[i] = Math.min(t[2 * i + 1], t[2 * i + 2]);
//            }
            out.println("YES");
            for (int x : t) {
                out.print(x);
                out.print(" ");
            }
        } else {
            out.println("NO");
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
