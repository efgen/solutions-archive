    import java.io.*;
    import java.util.*;
    import java.math.*;

    public class Main implements Runnable {
        static final long e = 1;
        void solve() throws IOException {
            int n = nextInt();
            int m = nextInt();
            Vector<Integer>[] a = new Vector[n];
            long[][] f = new long[n][n/64+1];
            int[][] val = new int[n][];
            for (int i=0; i<n; i++) {
                a[i] = new Vector<Integer>();
            }
            while (m-->0) {
                int x = nextInt()-1;
                int y = nextInt()-1;
                a[x].add(y);
                a[y].add(x);
                f[x][y>>6] |= e<<(y&63);
                f[y][x>>6] |= e<<(x&63);
            }
            for (int i=0; i<n; i++) {
                val[i] = new int[a[i].size()];
                for (int j=0; j<a[i].size(); j++) {
                    val[i][j] = a[i].get(j);
                }
                Arrays.sort(val[i]);
            }
            long res = 0;
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    int t = j;
                    int[] v = val[i];
                    if (val[i].length > val[j].length) {
                        t = i;
                        v = val[j];
                    }
                    int sz = 0;
                    for (int x:v)
                        if ((f[t][x>>6] & e<<(x&63)) !=0 ) {
                            sz++;
                        }
                    res += ((long)sz)*(sz-1);



                }
            }
            out.print(res/4);



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
