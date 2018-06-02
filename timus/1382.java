import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {	
		int n;
		int[] comp;
		int time = 0;
		boolean[] a;
		boolean[] b;
		int[] ord;
		boolean[] f;		
		
		
		
		void dfs(int v) {
			f[v] = true;
			int vv = v*n;
			for (int i=0; i<n; i++)
				if (a[vv+i] && !f[i])
					dfs(i);
			ord[time++] = v;
		}
		
		void dfs2(int v) {			
			comp[v] = time;
			v *= n;
			for (int i=0; i<n; i++)
				if (b[v+i] && comp[i]==0) dfs2(i);
		}
		void add(int x, int y) {
			a[x*n+y] = true;
			b[y*n+x] = true;
		}
		
		void solveSAT() {
			f = new boolean[n];
			ord = new int[n];
			for (int i=0; i<n; i++)
				if (!f[i]) dfs(i);
			comp = new int[n];
			time = 0;
			for (int i=n-1; i>=0; --i) {
				int v = ord[i];
				if (comp[v]==0) {
					time++;
					dfs2(v);	
				}				
			}
		}
	
	
	class Point {
		int id, a, b;
		public Point (int ii, int aa , int bb) {
			a = aa; b = bb; id = ii;
		}
		
	}	
	
	void solve() throws IOException {
		int n = nextInt();
		this.n = 2*n;
		a = new boolean[2*n*2*n];
		b = new boolean[2*n*2*n];
		
		Vector<Point> all = new Vector<Point>();
		for (int i=1; i<=n; i++) {
			all.add(new Point(i-1, i, nextInt()));
			all.add(new Point(i-1+n, nextInt(), nextInt()));
		}
		
		for (Point p:all)
			for(Point q:all)
				if (p.id!=q.id && Math.abs(p.id-q.id)!=n) {
					if (p.a==q.a ^ p.b==q.b)
						add(p.id, q.id<n?q.id+n:q.id-n);
				}
		solveSAT();
		
		for (int i=0; i<n; i++)
			if (comp[i]>comp[i+n]) out.print("1 "); else out.print("2 ");
		
		
    }    

		
    static final int inf = 1000000000+10;
    static final double eps = 1e-8;
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