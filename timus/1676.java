import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
    // static final String FileName = "test";
	boolean[][] a;
	int[] pair, fight;
	boolean[] f;
	int n, m;
	boolean dfs(int v) {
		if (v<0) return true;
		if (f[v]) return false;
		f[v] = true;
		for (int i=0; i<n; i++)
			if (a[i][v] && dfs(pair[i])) {
				pair[i] = v;
				return true;
			}
		return false;
	}
	void go(int v) {
		if (f[v]) return;
		f[v] = true;
		for (int j=0; j<m; j++)
			if (a[v][j]) 
				go(fight[j]);
	}
	int[][] g;
	void set(int i, int k) {
		g[i][k>>5] |= 1<<(k&31);
	}
	boolean get(int i, int k) {
		return (g[i][k>>5] & (1<<(k&31)))!=0;
	}
    void solve() throws IOException {
    	m = nextInt();
    	n = nextInt();
    	a = new boolean[n][m];
    	for (int i=0; i<m; i++) {
    		char[] s = br.readLine().toCharArray();
    		for (int j=0; j<n; j++)
    			a[j][i] = s[j]=='1';
    	}
    	/*n = 3000;
    	m = 100;
    	Random R = new Random();
    	a = new boolean[n][m];
    	for (int i=0; i<n; i++)
    		for (int j=0; j<m; j++)
    			a[i][j] = (R.nextInt()%100+100)%100<30; */
    	pair = new int[n];
    	f = new boolean[m];
    	Arrays.fill(pair, -1);
    	
    	for (int i=0; i<m; i++) {
    		Arrays.fill(f, false);
    		if (!dfs(i)) {
    			for (int k=0; k<m; k++) {
    				for (int j=0; j<n; j++)
    					out.print(1);
    				out.println();
    			}
    			return;
    		}
    	}
    	//for (int i=0; i<n; i++) out.print(pair[i]+" "); out.println();
    	fight = new int[m];
    	for (int i=0; i<n; i++)
    		if (pair[i]>=0)
    			fight[pair[i]] = i;
    	f = new boolean[n];
    	for (int i=0; i<n; i++)
    		if (pair[i]<0) go(i);
    	//for (int i=0; i<n; i++) out.print(f[i]+" "); out.println();
    	int sz = (n+31)/32;
    	g = new int[n][sz];
    	for (int i=0; i<n; i++)
    		if (pair[i]<0) {
    			for (int j=0; j<m; j++)
    				if (a[i][j]) set(i, fight[j]);
    		} else {
    			for (int j=0; j<m; j++)
    				if (j!=pair[i] && a[i][j]) set(i, fight[j]);
    		}
    	
    	for (int k=0; k<n; k++)
    		for (int i=0; i<n; i++)
    			if (get(i, k))
    				for (int j=0; j<sz; j++)
    					g[i][j] |= g[k][j];
    	for (int j=0; j<m; j++) {
    		for (int i=0; i<n; i++)
    			if (a[i][j] && (j==pair[i] || f[i] || get(fight[j], i)))
    				out.print(0);
    			else 
    				out.print(1);
    			out.println();
    	}
            
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