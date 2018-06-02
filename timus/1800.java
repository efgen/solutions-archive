import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	
	void solve() throws IOException {
		double L = nextDouble()/2;
		double h = nextDouble();
		double w = nextDouble()/60;
		double W = Math.PI*2*w;
		double g = 981*0.5;
	
		double dt = 1e-8;
		double t = Math.sqrt(Math.max(h-L, 0)/g);
		if (t<0) t = 0;
		
		double fi = w*t;
		fi = fi-Math.floor(fi+1e-10);
		while (fi>=1.0) fi -= 1.0;
		while (fi<0) fi += 1;
		if (fi>0.25 && fi<0.75) out.println("bread"); else
			if (fi<0.25 || fi>0.75) out.println("butter"); else {
				out.println(1/0);
			}
		
		
		
    }    

	
    static final int inf = 1000000000+10;
    static final double eps = 1e-5;
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