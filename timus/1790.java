import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";	
    void solve() throws IOException {
    	int n = nextInt();
    	int m  = nextInt();
    	int l1 = 1, r1 = n, l2 = 2, r2 = n;
    	if (n%2==0) r1--; else r2--;    	
    	while (m-->0) {
    		int x = nextInt();
    		if (l1==x) l1 += 2;
    		if (l2==x) l2 += 2;
    		if (r1==x) r1 -= 2;
    		if (r2==x) r2 -= 2;
    		if (r1<l1) r1 = -inf;
    		if (r2<l2) r2 = -inf;
    		int q1 = l1==1?2:l1-1;
    		int q2 = r1==n?n-1:r1+1;
    		l1 = l2==1?2:l2-1;
    		r1 = r2==n?n-1:r2+1;
    		l2 = q1; r2 = q2;
    		if (r1<l1) r1 = -inf;
    		if (r2<l2) r2 = -inf;
    	}
    	if (l1>r1 && l2>r2) out.println("YES"); else out.println("NO");
    }
    
    


    static final int inf = 1000000000;
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
            new Task().run();
    
    }
}