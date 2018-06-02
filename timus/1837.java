import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {


    void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashMap<String, HashSet<String>> g = new HashMap<String, HashSet<String>>();
        TreeMap<String, Integer> res = new TreeMap<String, Integer>();
        while (n-->0) {
            String[] s = br.readLine().split(" ");
            for (int i=0; i<s.length; i++)
                for (int j=0; j<s.length; j++){
                    if (!res.containsKey(s[i])) {
                        res.put(s[i], -1);
                        g.put(s[i], new HashSet<String>());
                    }
                    g.get(s[i]).add(s[j]);
                }
        }
        
        String root = "Isenbaev";        
        if (res.containsKey(root)){
            res.put(root, 0);
            Queue<String> q = new LinkedList<String>();
            q.add(root);
            while (!q.isEmpty()) {
                String cur = q.poll();
                int d = res.get(cur)+1;
                for (String s:g.get(cur)) {
                    if (res.get(s) < 0) {
                        res.put(s, d);
                        q.add(s);
                    }
                }
            }
        }
        for (String s:res.keySet()) {
            out.println(s+" "+(res.get(s)<0?"undefined":res.get(s)));
        }
        


    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            // br = new BufferedReader(new FileReader("input.txt"));
            // out = new PrintWriter("output.txt");
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
