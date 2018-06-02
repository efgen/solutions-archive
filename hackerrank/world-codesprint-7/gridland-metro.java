import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {
    class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.x) {
                return o.y - y;
            } else return x - o.x;
        }
    }

    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        HashMap<Integer, Vector<Point>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int r = nextInt();
            int x = nextInt();
            int y = nextInt();
            Point p = new Point(x, y);
            if (!map.containsKey(r)) {
                map.put(r, new Vector<>());
            }
            map.get(r).add(p);
        }
        long res = 0;

        res = (long) (n - map.size()) * m;

        for (Map.Entry<Integer, Vector<Point>> en : map.entrySet()) {
            Vector<Point> segments = new Vector<>();
            //segments.add(new Point(0, -1));
            segments.add(new Point(m + 1, 1));
            for (Point p : en.getValue()) {
                segments.add(new Point(p.x, 1));
                segments.add(new Point(p.y, -1));
            }
            Collections.sort(segments);
            int cnt = 0;
            int lastZero = 0;
            int add = 0;
            for (Point p : segments) {
                if (cnt == 0) {
                    add += p.x - lastZero - 1;
                }
                cnt += p.y;
                if (cnt == 0) {
                    lastZero = p.x;
                }
            }
            res += add;
            //out.println(en.getKey() + " " + add);
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
