import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	int n;
	ArrayList<Integer>[] a;
	ArrayList<Integer>[] myck;
	int[] path, pr, G;
	int[] f;
	int time = 0;
	HashSet<Integer> isCk = new HashSet<Integer>(100000);
	void dfs(int v){
		f[v] = ++time;
		for (int x:a[v]) {
			if (x!=pr[v]) if (f[x]==0){ pr[x] = v; dfs(x); } else if (f[x]<f[v]){
				int t = v;
				G[x] ^= 1;
				while (t!=x) {
					isCk.add(pr[t]*n+t);
					isCk.add(t*n+pr[t]);
					G[x] ^= 1;
					myck[x].add(t);
					t = pr[t];
				} 
				isCk.add(x*n+v);
				isCk.add(v*n+x);
			}
		}
	}
	int calc(int v) {
		for (int x:a[v]) {
			if (x==pr[v]) continue;
			if (isCk.contains(v*n+x)) continue;
			G[v] ^= calc(x)+1;
		}
		for (int x:myck[v]) G[v] ^= calc(x);
		return G[v];
	}
    void solve() throws IOException {
    	n = nextInt();
    	int m = nextInt();
    	int r = nextInt()-1;
    	a = new ArrayList[n];
    	myck = new ArrayList[n];
    	path = new int[n];
    	pr = new int[n];
    	f = new int[n];
    	G = new int[n];
    	for (int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
    	for (int i=0; i<n; i++) myck[i] = new ArrayList<Integer>();
    	while (m-->0) {
    		int l = nextInt()-1;
    		int x = nextInt()-1;
    		while (l-->0) {
    			int y = nextInt()-1;
    			a[x].add(y);
    			a[y].add(x);
    			x = y;
    		}
    	}
    	pr[r] = -1;
    	dfs(r);
    	if (calc(r)!=0) out.println("First"); else out.println("Second");
    }
    
    


    static final int inf = 1000000000;
    static final double epd = 1e-8;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
            //br = new BufferedReader(new FileReader(FileName+".in"));
            //out = new PrintWriter(FileName+".out");
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //br = new BufferedReader(new FileReader("input.txt"));
            //out = new PrintWriter("output.txt");
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
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
            new Solution().run();
    
    }
    
}