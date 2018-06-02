import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.StringTokenizer;

public class Main implements Runnable {


    void solve() throws IOException {
        int n = nextInt();
        SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        while (n-->0) {
            int q = nextInt();
            if (q == 1) {
                int price = nextInt();
                int time = nextInt();
                map = map.tailMap(time-59);

                if (map.containsKey(time)) {
                    map.put(time, Math.max(price, map.get(time)));
                } else {
                    map.put(time, price);
                }
            } else {
                int res = -1;
                int time = nextInt();
                map = map.tailMap(time-59);
                for (int x:map.keySet()) {
                    res = Math.max(res, map.get(x));
                }
                out.println(res);

            }
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
        } catch (IOException e) {
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
