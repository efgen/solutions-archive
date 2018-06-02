import java.io.*;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
        int n = nextInt();
        int ign = nextInt();
        int res = 0;
        for (int i=0; i<n; i++) {
            int x = nextInt();
            if (i!=ign) res += x;
        }
        res = nextInt() - res/2;
        if (res==0) {
            out.print("Bon Appetit");
        } else {
            out.print(res);
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
