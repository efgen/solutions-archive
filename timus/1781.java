import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";  
 
    		
    
    void solve() throws IOException {   
    	ArrayList<Integer> rx = new ArrayList<Integer>();
    	ArrayList<Integer> ry = new ArrayList<Integer>();
    	int n = nextInt();
    	boolean[][] a = new boolean[n][n];
    	for (int i=0; i<n; i++)
    		for (int j=0; j<n; j++)
    			a[i][j] = nextInt()==1;
    	for (int k=0; k<n; k++) {
    	/*	for (int i=0; i<n; i++) {
    			for (int j=0; j<n; j++)
    				if (a[i][j]) out.print(1); else out.print(0);
    			out.println();
    		}
    		out.println(); */
    		int bz = -1;
    		for (int j=k; j<n; j++) {
    			boolean z = true;
    			for (int i=k; i<n; i++) if (a[i][j] && i!=j) {
    				z = false;
    				break;
    			}
    			if (z) {
    				bz = j;
    				break;
    			}
    		}
    		//out.println(bz);
    		if (bz<0) {
    			out.print(-1);
    			return;
    		}
    		if (bz!=k) {
    			rx.add(k+1);
    			ry.add(bz+1);
    			for (int i=k; i<n; i++) {
    				boolean q = a[i][k]; a[i][k] = a[i][bz]; a[i][bz] = q;
    			}
    			for (int j=k; j<n; j++) {
    				boolean q = a[k][j]; a[k][j] = a[bz][j]; a[bz][j] = q; 
    			}
    		}
    	}
    	int sz = rx.size();
    	out.println(sz);
    	for (int i=0; i<sz; i++) out.println(rx.get(i)+" "+ry.get(i));
    	
    	
    }
   
    


    static final int inf = 1000000000;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
           // br = new BufferedReader(new FileReader(FileName+".in"));
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