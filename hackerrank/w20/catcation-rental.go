    import java.io.*;
    import java.util.*;
    import java.math.*;

    public class Main implements Runnable {

        void solve() throws IOException {
            int m = nextInt();
            int n = nextInt();
            int queries = nextInt();
            int[] l = new int[m];
            int[] r = new int[m];
            for (int i=0; i<m; i++) {
                l[i] = nextInt()-1;
                r[i] = nextInt()-1;
            }
            boolean[] f = new boolean[n];

            for (int q=0; q<queries; q++) {
                int d = nextInt();
                int res = 0;
                Arrays.fill(f, false);
                for (int i=0; i<m; i++) {
                    if (r[i]-l[i]+1<d) continue;
                    boolean ok = true;
                    for (int x=l[i]; x<=r[i]; x++)
                        if (f[x]) {
                            ok = false;
                            break;
                        }
                    if (!ok) continue;;
                    res += r[i]-l[i]+1;
                    for (int x=l[i]; x<=r[i]; x++)
                        f[x] = true;
                }
                out.println(res);

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
