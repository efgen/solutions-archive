import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Main implements Runnable {
    class Point implements Comparable<Point> {
        int id;
        double x, y, z;

        public Point(int id, double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.id = id;
        }

        public int compareTo(Point o) {
            return Double.valueOf(o.z).compareTo(z);
        }

    }

    void solve() throws IOException {
        int n = nextInt();
        int b = nextInt();
        Point[] a = new Point[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Point(nextInt(), nextDouble(), nextDouble(), nextDouble());
        }

        Arrays.sort(a);
        HashMap<Integer, Point> map = new HashMap<>();

        for (int i = 0; i < b; i++) {
            map.put(a[i].id, a[i]);
        }
        int nextPoint = b;
        while (true) {
            String req = next();
            if (req == null) break;
            if (req.toUpperCase().equals("F")) {
                int id = nextInt();
                if (map.containsKey(id)) {
                    Point p = map.get(id);
                    out.printf("%d = (%.3f,%.3f,%.3f)\n", id, p.x, p.y, p.z);
                } else {
                    out.println("Point doesn't exist in the bucket.");
                }
            } else {
                int id = nextInt();
                if (map.containsKey(id)) {
                    Point p = map.get(id);
                    if (nextPoint < n) {
                        out.printf("Point id %d removed.\n", id);
                        map.remove(id);
                        map.put(a[nextPoint].id, a[nextPoint]);
                        nextPoint++;
                    } else {
                        out.println("No more points can be deleted.");
                    }

                } else {
                    out.println("Point doesn't exist in the bucket.");
                }
            }
            out.flush();

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
