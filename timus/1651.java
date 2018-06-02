import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";
	int n;
	class Point {
		int x, id;
		public Point (int xx, int i) {
			x = xx; id = i;
		}
	}
    void solve() throws IOException {
    	int m = nextInt();	
    	int[] p = new int[m+1];
    	for (int i=1; i<=m; i++) p[i] = nextInt();
    	int[] d = new int[m+1];
    	int[] go = new int[m+1];
    	int[] last = new int[10000+1];
    	last[p[m]] = m;
    	for (int i=m-1; i>0; --i) {
    		int v = p[i];
    		d[i] = d[i+1]+1;
    		go[i] = i+1;
    		if (last[v]!=0 && d[i]>d[last[v]]) {
    			d[i] = d[last[v]];
    			go[i] = go[last[v]];
    		}
    		last[v] = i;
    	}
    	int t = 1;
    	while (t>0) {
    		out.print(p[t]);
    		out.print(" ");
    		if (p[t]==p[m]) break;
    		t = go[t];    		
    	}
     	
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