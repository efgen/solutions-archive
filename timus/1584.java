import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	int f(char c1, int c2) {
		return (c1-'a')==c2?0:1;
	}
	int[] Q, state;
	int qs, qt;
	void push(int v) {
		state[v] = 1;
		Q[qt++] = v;
		if (qt==Q.length) qt = 0;
	}
	int pop() {		
		int res = Q[qs++];
		state[res] = 2;
		if (qs==Q.length) qs = 0;
		return res;
	}
	void pushF(int v) {
		state[v] = 1;
		if (qs==0) qs = Q.length;
		qs--;
		Q[qs] = v;		 
	}
    void solve() throws IOException {
    	int h = nextInt();
    	int w = nextInt();
    	char[][] s = new char[h][];
    	
    	for (int i=0; i<h; i++)
    		s[i] = next().toCharArray();
    	int[] cnt = new int[26];
    	for (int i=0; i<h; i++)
    		for (int j=0; j<w; j++)
    			cnt[s[i][j]-'a']++;
    	int sz = w*h/4;
    	int n = w*h/4+26+2;
    	int S = n-2, T = n-1;
    	int[][] f = new int[n][n];
    	int[][] c = new int[n][n];
    	int[][] cost = new int[n][n];
    	for (int i=0; i<h/2; i++)
    		for (int j=0; j<w/2; j++)
    			for (int t=0; t<26; t++) {
    				cost[i*w/2+j][t+sz] = 
    					f(s[i][j], t)+f(s[h-i-1][j], t)+f(s[h-i-1][w-j-1], t)+f(s[i][w-j-1], t);
    				cost[t+sz][i*w/2+j] = -cost[i*w/2+j][t+sz];
    				c[i*w/2+j][t+sz] = 1;
    			}
    	for (int i=0; i<sz; i++) c[S][i] = 1;
    	for (int i=0; i<26; i++) c[i+sz][T] = cnt[i]/4;
    	int[] d = new int[n];
    	int[] pr = new int[n];
    	Q = new int[n];
    	state = new int[n];
    	int res = 0;
    	while (true) {
    		Arrays.fill(d, inf); d[S] = 0;
    		Arrays.fill(pr, -1);
    		qs = qt = 0;
    		push(S);
    		while (qs!=qt) {
    			int v = pop();
    			for (int i=0; i<n; i++)
    				if (f[v][i]<c[v][i]) {
    					if (d[i]>d[v]+cost[v][i]) {
    						d[i] = d[v]+cost[v][i];
    						if (state[i]==0) push(i);
    						if (state[i]==2) pushF(i);    						
    						pr[i] = v;
    					}
    				}
    		}
    		if (d[T]!=inf) {
    			int v = T;
    			while (v!=S) {
    				int u = pr[v];
    				f[u][v]++;
    				f[v][u]--;
    				res += cost[u][v];
    				v = u;
    			}
    		} else break;    		
    	}
    	out.println(res);
    	
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