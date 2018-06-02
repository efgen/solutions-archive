import java.io.*;
import java.util.*;

public class Main implements Runnable {

    void solve() throws IOException {
        int t = nextInt();
        while (t-->0) {
            String s1 = next();
            String s2 = next();
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (char c:s2.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c)+1);
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean ok = true;
            for (char c:s1.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    if (!map.containsKey(c)) {
                        ok = false;
                        continue;
                    }
                    sb.append(c);
                    if (!map2.containsKey(c)) {
                        map2.put(c, 1);
                    } else {
                        map2.put(c, map2.get(c)+1);
                    }
                } else {
                    c = Character.toUpperCase(c);
                    if (map.containsKey(c)) {
                        sb.append(c);
                    }
                }
            }
            for (Character c:map2.keySet()) {
                if (map2.get(c) > map.get(c)) {
                    ok = false;
                }
            }
            int cnt = 0;
            for (char c:sb.toString().toCharArray()) {
                if (cnt<s2.length() && c == s2.charAt(cnt)) {
                    cnt++;
                }
            }
            ok &= cnt == s2.length();
            if (ok) {
                out.println("YES");
            } else {
                out.println("NO");
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
