import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	class Point implements Comparable<Point> {
		int id;
		int v;
		public Point(int xx, int vv) {
			id = xx; v = vv;
		}
		public int compareTo(Point o) {
			if (v==o.v) return id-o.id;
			if (v<o.v) return -1; else return 1;
		}
		public String toString() {
			return Integer.toString(id);
			//return id+" "+v+", ";
		}
	}
    void solve() throws IOException {
    	int k = nextInt();
    	int sz = k*k*k*k*k*k;
    	int[] ans = new int[sz];
    	for (int i=0; i<sz; i++) {    		
    		ans[i] = i%k+ans[i/k];
    		
    	}
    	k = sz;
    	int n = nextInt();
    	int[] a = new int[n+1];
    	int[] b = new int[n+1];
    	int[] c = new int[n+1];
    	a[0] = a[1] = 1;
    	b[0] = b[1] = 1;
    	Point[] res = new Point[n];
    	res[0] = new Point(1, 1);
    	res[1] = new Point(2, 1);
    	for (int i=2; i<n; i++) {
    		int len = b[0];    	
    		int x = 0;
    		int cnt = 0;
    		for (int j=1; j<=len; j++) {
    			x += a[j]+b[j];
    			int xx = x/k;
    			c[j] = x-xx*k;
    			cnt += ans[c[j]];
    			x = xx;
    		}
    		if (x>0) {
    			c[++len] = x;
    			cnt += ans[x];
    		}
    		c[0] = len;
    		a = b; b = c; c = a;
    		res[i] = new Point(i+1, cnt);
    	}
    	Arrays.sort(res);
    	for (Point p:res) out.print(p+" ");
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