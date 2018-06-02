import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
    // static final String FileName = "test";


    void solve() throws IOException {
    	int n = 13;
    	int[][] a = new int[4][13];
    	for (int i=0; i<4; i++) {
    		for (int j=0; j<n; j++) {
    			a[i][j] = (int)(next().charAt(1));
    		}
    	}
    	int[] rf = new int[4];
    	boolean[] f = new boolean[4];
    	int[] p = new int[4];
    	int res = 0;
    	for(int t=0; t<12; t++) {    
    		for (int i=0; i<4; i++)
    			for (int j=0; j<4; j++)
    				if (a[i][t]==a[j][t+1]) p[i] = j;
    		Arrays.fill(f, false);
    		for (int i=0; i<4; i++) if (!f[i]) {
    			int k = 0;
    			int x = i;
    			while (!f[x]) {
    				f[x] = true;
    				k++;
    				x = p[x];
    			}
    			if (k>1) res += k+1;
    		}
    		
    	}
    	out.println(res);
    	
    }
   
    


    static final int inf = 1000000000;
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
            new Task().run();
    
    }
}