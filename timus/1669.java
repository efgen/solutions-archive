import java.io.*;
import java.util.*;
//import java.math.*;

public class Solution {

	
	void solve() throws IOException {
		int n = nextInt();
		if (n>18) {
			out.println("NO");
			return;
		}
		char[] s = next().toCharArray();
		int[][] a = new int[n][s.length+2];
		for (int i=0; i<s.length; i++) {
			int x = s[i]-'a';
			a[x][++a[x][0]] = i;
		}
		for (int i=0; i<n; i++) a[i][++a[i][0]] = s.length;
		
		int sz = 1<<n;
		int[] d = new int[sz]; 
		d[0] = -1;
		for (int msk=1; msk<sz; msk++) {
			for (int i=0; i<n; i++)
				if ((msk&(1<<i))!=0) {
					int prev = msk^(1<<i);
					int[] ar = a[i];
					int l = 1, r = ar[0];
					int key = d[prev];
					while (l<r) {
						int mid = (l+r)>>1;
						if (ar[mid]<key) l = mid+1; else r = mid;
					}
					key = ar[l];
					if (key==s.length) {
						//out.println(prev);
						out.println("NO");
						return;
					}
					if (key>d[msk]) d[msk] = key;
				}
		}
		//for (int i=0; i<sz; i++) out.println(i+" "+d[i]);
		out.println("YES");
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