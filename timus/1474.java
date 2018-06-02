import java.io.*;
import java.util.*;
//import java.math.*;

public class Solution {

	
	void solve() throws IOException {
		int n = nextInt();
		
		if (n==0) {
			out.println(3);
			out.print("2 0 1");
		} else {
			out.println((n+1)*(n+1)-1);
			int d = -1;
			int p = n;
			for (int k=1; k<=n; k++) {
				p += d;
				out.print(p); out.print(" ");
				d *= -1;
				for (int i=1; i<=k; i++) {
					p += d; p += d;
					out.print(p); out.print(" ");
				}
			}
		//	out.println();
			for (int k=n; k>0; k--) {
				d *= -1;	
				p += d;
				out.print(p); out.print(" ");
			
				for (int i=1; i<k; i++) {
					p += d; p += d;
					out.print(p); out.print(" ");
				}
				
				
			
				
			}
		}
		
    }    

	
    static final int inf = 1000000000+10;
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