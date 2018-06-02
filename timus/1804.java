import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	
	void solve() throws IOException {
		int tt  = nextInt();
		while (tt-->0) {
			for (int i=0; i<3; i++) next();
			String where = next();
			for (int i=0; i<2; i++) next();
			int x = nextInt();
			for (int i=0; i<3; i++) next();
			int y = nextInt();
			next();
			int rx = 0 , ry = 0;
			if (where.charAt(0)=='h') {
				for (int i=0; i<=30; i++)
					if (x+i>y || ((x+i)==y && i>=y)) {
						rx = i; break;
					}				
				for (int i=0; i<=30; i++)
					if (x+i<y+30 || ((x+i)==(y+30) && i<=y)) {
						ry = i; 
					}
			} else {
				for (int i=0; i<=30; i++)
					if (x+i>y || ((x+i)==y && x>=0)) {
						rx = i; break;
					}				
				for (int i=0; i<=30; i++)
					if (x+i<y+30 || ((x+i)==(y+30) && x<=30)) {
						ry = i; 
					}	
			}
			out.println(rx+" "+ry);
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