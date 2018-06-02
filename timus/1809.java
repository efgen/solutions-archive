import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	static final String FileName = "test";
	static int[] x = new int[4];
	static int[] y = new int[4];
	static int[] bx = new int[4];
	static int[] by = new int[4];
	
	static boolean ok() {
		for (int i=0; i<4; i++)
			for (int j=i+1; j<4; j++)
				if (x[i]==x[j] && y[i]==y[j]) 
					return false;
		int cnt = 0, t = -1;
		for (int i=1; i<4; i++)
			if (x[0]==x[i] || y[0]==y[i]) {
				cnt++;
				t = i;
			}
		if (cnt!=1) return false;
		for (int i=1; i<4; i++) if (i!=t)
			if (x[t]==x[i] || y[t]==y[i]) {
				return false;
			}
		for (int i=1; i<4; i++) if (i!=t)
			for(int j=i+1; j<4; j++) if (j!=t)
				if (x[i]==x[j] || y[i]==y[j]) 
					return true;
		return false;
	}
	
	boolean gen(int k, int msk) {
		if (k==4) {
			if (ok()) {
				for (int i=0; i<4; i++) {
					bx[i] = x[i];
					by[i] = y[i];
				}
				return true;
			} else return false;
		}
		if ((msk&(1<<k))!=0) {
			int xx = x[k];
			int yy = y[k];			
			for (int i=1; i<=20; i++) {
				x[k] = i;
				for (int j=1; j<=20; j++) {					 
					y[k] = j; 
					if (gen(k+1, msk)) {
						x[k] = xx;
						y[k] = yy;

						return true;
					}
				}
			}
			x[k] = xx;
			y[k] = yy;
			return false;
		} else return gen(k+1, msk);
	}
	void solve() throws IOException {
		for (int i=0; i<4; i++) {
			x[i] = nextInt();
			y[i] = nextInt();
		}
		int[] rx = new int[4];
		int[] ry = new int[4];
		int min = 4;
		for (int msk=15; msk>=0; msk--) {			
			int t = Integer.bitCount(msk);
			if (t>2) continue;
			if (gen(0, msk)) {
				if (t<min) {
					min = t;
					rx = bx.clone();
					ry = by.clone();
				}
			}
		}
		//out.println(min);
		for (int i=0; i<4; i++) out.println(rx[i]+" "+ry[i]);
    }

	
    static final int inf = 1000000000+10;
    static final double eps = 1e-8;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
           // br = new BufferedReader(new FileReader(FileName+".in"));
           // out = new PrintWriter(FileName+".out");
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