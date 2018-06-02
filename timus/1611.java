import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    void solve() throws IOException {
    	int n = nextInt();
    	int k = nextInt();
    	char[] s = next().toCharArray();
    	int[][] d = new int[k+1][n+1];
    	for (int[] dd:d) Arrays.fill(dd, inf);
    	boolean[][] p = new boolean[k+1][n+1];
    	d[k][0] = 0;
    	for (int i=0; i<=n; i++) {
    		int cnt = i+1;
    		for (int j=k; j>=0; ++cnt, --j) {
    			 if (i<n && d[j][i+1]>d[j][i]+(cnt%10==0?s[i]-'0':0)) {
    				 d[j][i+1]=d[j][i]+(cnt%10==0?s[i]-'0':0);
    				 p[j][i+1] = false;
    			 }
    			 if (j>0 && d[j-1][i]>d[j][i]+(cnt%10==0?1:0)) {
    				 d[j-1][i]=d[j][i]+(cnt%10==0?1:0);
    				 p[j-1][i] = true;
    			 }
    		}
    	}
    	int bk = 0;
    	for (int i=0; i<=k; i++) if (d[i][n]<d[bk][n]) bk = i;
    	out.println(d[bk][n]);
    	Stack<Integer> res = new Stack<Integer>();
    	int cnt = n+k-bk;
    	while (n>0 && bk<k) {
    		if (p[bk][n]) {
    			bk++;
    			res.add(cnt);
    		} else n--;
    		cnt--;
    	}
    	while (bk<k) {
    		res.add(cnt);
    		bk++;
    		cnt--;
    	}
    	out.print(res.size());
    	while (!res.isEmpty()) out.print(" "+res.pop());
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