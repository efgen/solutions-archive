import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";  
	int[] dx  = {0, 0, 1, -1};
	int[] dy  = {-1, 1, 0, 0};
    void solve() throws IOException {
    	int w = nextInt();
    	int h = nextInt();
    	int y0 = nextInt();
    	int x0 = h+1-nextInt();
    
    	int D = nextInt();
    	byte[][] a = new byte[h+2][w+2];
    	for (int i=1; i<=h; i++) {
    		String s = next();
    		for (int j=0; j<w; j++) 
    			if (s.charAt(j)=='.') 
    				a[i][j+1] = 1;
    	}
    	int sz = (h+2)*(w+2);
    	int[] q = new int[sz];
    	int qs = 0, qt = 0;
    	int t = w+2;
    	for (int j=1; j<=w; j++) 
    		if (a[1][j]==1) {
    			a[1][j] = 2;
    			q[qt++] = 1*t+j;
    		}
    	
    	while (qs<qt) {
    		int v = q[qs++];
    		int xx = v/t;
    		int yy = v%t;
    		for (int i=0; i<3; i++) {    
    			int x = xx+dx[i];
    			int y = yy+dy[i];
    			if (a[x][y]==1) {
    				a[x][y] = 2;
    				int nv = x*t+y;
    				q[qt++] = nv;
    			}
    		}
    	}
    	
    	int[][] d = new int[h+2][w+2];
    	byte[] state = new byte[sz];
    	for (int[] dd:d) Arrays.fill(dd, inf);
    	qs = qt = 0;
    	for (int j=1; j<=w; j++) 
    		if (a[1][j]==2) {    			
    			q[qt++] = 1*t+j;
    			state[t+j] = 1;
    			d[1][j] = 1;
    		}
    	
    	
    	while (qs!=qt) {
    		int v = q[qs++];
    		if (qs==q.length) qs = 0;
    		int xx = v/t;
    		int yy = v%t;
    		if (d[xx][yy]==D) continue;
    		for (int i=0; i<4; i++) {
    			int x = xx+dx[i];
    			int y = yy+dy[i];
    			if (a[x][y]==1 && d[x][y]>0) {
    				d[x][y] = 0;
    				int nv = x*t+y;
    				if (state[nv]==1) continue;
    				state[nv] = 2;
    				--qs;
    				if (qs<0) qs = q.length-1;
    				q[qs] = nv;
    			}
    			if (a[x][y]==2 && d[x][y]>d[xx][yy]+1) {
    				d[x][y] = d[xx][yy]+1;
    				int nv = x*t+y;
    				if (state[nv]==1) continue;
    				if (state[nv]==0) {
    					q[qt++] = nv;
    					if (qt==q.length) qt = 0;
    				} else {
    					--qs;
        				if (qs<0) qs = q.length-1;
        				q[qs] = nv;
    				}
    				state[nv] = 2;
    					
    			}
    		}
    	}
    	/*for (int i=1; i<=h; i++) {
    		for (int j=1; j<=w; j++) out.print(d[i][j]+" ");
    		out.println();
    	}*/
    	if (d[x0][y0]==inf) out.print("Rescue operation required"); else out.print("Can be rescued by himself");
        
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