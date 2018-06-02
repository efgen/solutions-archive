import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";
	int n;
	boolean[][] a;
	int[] d;
	boolean[] f;
	boolean ok = true;
	ArrayList<Integer> cur = new ArrayList<Integer>();
	void dfs(int v) {
		f[v] = true;
		cur.add(d[v]);
		for (int i=0; i<n; i++)
			if (!f[i] && a[v][i]) {
				dfs(i);
			}
	}
    void solve() throws IOException {
    	n = nextInt();
    	int m = nextInt();
    	a = new boolean[n][n];
    	d = new int[n];
    	while (m-->0) {
    		int x = nextInt()-1;
    		int y = nextInt()-1;
    		a[x][y] = a[y][x] = true;
    		d[x]++; d[y]++;
    	}
    	f = new boolean[n];
    	for (int i=0; i<n; i++)
    		if (!f[i]) {
    			cur.clear();
    			dfs(i);
    			boolean t1 = true, t2 = true;
    			if (cur.size()<5) {
    				for (int x:cur) if (x!=cur.size()-1) t1 = false;
    			} else t1 = false;
    			if (cur.size()>2) {
					Collections.sort(cur);
					t2 &= cur.get(0)==1;
					t2 &= cur.get(1)==1;
					for (int j=2; j<cur.size(); j++) t2 &= cur.get(j)==2;
    			} else t2 = false;
    			ok &= t1||t2;
    		}
    	if (ok) out.println("Luck is possible"); else out.println("Unlucky Petr");
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