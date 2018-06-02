import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	class Point implements Comparable<Point> {
		int x, val;
		public Point(int xx, int vv) {
			x = xx; val = vv;
		}
		public int compareTo(Point o) {
			if (val==o.val) return x-o.x; else return val-o.val;
		}
	}
	int[] cost;
	long[] pow;
	int val(long x, long y) {
		for (int i=10; i>=0; i--) {
			if (x==y) return cost[i];
			x /= 10; y /= 10;
		}
		return -1;
	}
	void solve() throws IOException {
		int n = nextInt();
		cost = new int[10];
		pow = new long[10]; pow[0] = 1;
		for (int i=1; i<10; i++) pow[i] = 10*pow[i-1];
		for (int i=0; i<10; i++) cost[i] = nextInt();
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		long[] val = new long[n];
		for (int i=0; i<n; i++) {
			char[] s = next().toCharArray();
			long x = 0;
			for (char c:s) x = 10*x+c-'0';
			val[i] = x;
			map.put(x, i);
		}
		PriorityQueue<Point> Q = new PriorityQueue<Point>();
		Q.add(new Point(0, 0));
		int[] d = new int[n];
		int[] pr = new int[n];
		Arrays.fill(d, inf); d[0] = 0;
		Arrays.fill(pr, -1);
		while (!Q.isEmpty()) {			
			Point cur = Q.poll();
			while (!Q.isEmpty() && cur.val>d[cur.x]) cur = Q.poll();
			//out.println(cur.x);
			int v = cur.x;
			if (v==n-1) break;
			long x = val[v];
			long p = 1000000000;
			for (int i=0; i<10; i++) {
				long xp = x/p;
				long x2 = x-xp*p;				
				for (int c=0; c<10; c++) {
					long y = (xp-xp%10+c)*p+x2;
					if (y==x) continue;
					Integer u = map.get(y);
					if (u==null) continue;
					int w = cost[i];
					if (d[u]>d[v]+w) {
						d[u] = d[v]+w;
						pr[u] = v;
						Q.add(new Point(u, d[u]));
					}					
				}
				p /= 10;
			}
			
			for (int i=0; i<9; i++) {
				long c1 = x/pow[i]%10;
				long xx = x-c1*pow[i];
				for (int j=i+1; j<10; j++) {
					long c2 = x/pow[j]%10;
					if (c2==c1) continue;
					long y = xx-c2*pow[j]+c1*pow[j]+c2*pow[i];
					if (y==x) continue;
					Integer u = map.get(y);
					if (u==null) continue;
					//int w = val(x, y);
					int w = cost[10-j-1];
					if (d[u]>d[v]+w) {
						d[u] = d[v]+w;
						pr[u] = v;
						Q.add(new Point(u, d[u]));
					}					
				}
				
				
			}
		}
		if (d[n-1]==inf) out.println(-1); else {
			out.println(d[n-1]);
			Stack<Integer> res = new Stack<Integer>();
			int v = n-1;			
			while (v>=0) {
				res.push(v);
				v = pr[v];
			}
			out.println(res.size());
			while (!res.isEmpty()) out.print((res.pop()+1)+" ");
		}
		
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
            st = new StringTokenizer(s,",.\t ");
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