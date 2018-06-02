import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	
	int[] getPrimes(int n) {
		Vector<Integer> res = new Vector<Integer>();
		boolean[] f = new boolean[n+1];
		for (int i=2; i<=n; i++)
			if (!f[i]) {
				res.add(i);
				for (int j=i+i; j<n; j+=i) 
					f[j] = true;
			}
		int[] r = new int[res.size()];
		for (int i=0; i<res.size(); i++) r[i] = res.get(i);
		return r;
	}
	void solve() throws IOException {
		int N = nextInt();
		int n = 2;
		while (N%n!=0) n++;
		N /= n; 
		int[] primes = getPrimes(1000);
		///out.println(primes.length);
		double[][] d = new double[primes.length+1][n+1];
		byte[][] go = new byte[primes.length+1][n+1];
		for (int k=0; k<primes.length; k++) {
			double val = Math.log(primes[k]);
			for (int x=1; x<=n; x++) {
				d[k+1][x] = d[k][x];
				int p = primes[k];
				
				int cnt = 0;
				while (p<=x) {
					cnt++;
					double t = d[k][x-p]+val*cnt;
					if (d[k+1][x]<t) {
						d[k+1][x] = t;
						go[k+1][x] = (byte)cnt;
					}
					p *= primes[k];
				}
			}
		}
		Vector<Integer> res = new Vector<Integer>();
		if (n<5) {
			res.clear();
			res.add(1);
			res.add(n-1);
			n = 0;
		}
		int k = primes.length;
		while (k>0 && n>0) {
			int cnt = go[k][n];
			if (cnt>0){
				int t = 1;
				while (cnt>0) {
					cnt--;
					t *= primes[k-1];
				}
				n -= t;
				res.add(t);
			}
			k--;
		}
		while (n-->0) res.add(1);
		Collections.sort(res);		
		for (int x:res) out.print((x*N)+" ");
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
            st = new StringTokenizer(s,",.\t ");
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