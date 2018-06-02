import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
	int mod = 1000000000+7;
	
	void solve() throws IOException {
		int n = nextInt();
		int[] p = new int[n+1];
		for (int i=2; i<=n; i++)
			if (p[i]==0) {
				for (int j=i+i; j<=n; j+=i)
					p[j] = i;
			}
		int[] ans = new int[n+1];
		long res = 1;
		int x = 1, y = 1;
		ans[n] = ans[n-1] = 1;
		for (int i=n-2; i>1; i--) {
			int z = x+y;
			if (z>=mod) z -= mod;
			ans[i] += z;
			if (ans[i]>=mod) ans[i] -= mod;
			y = x; x = z; 
		}
		for (int i=n; i>1; --i) {
			if (p[i]>0) {
				ans[p[i]] += ans[i];
				if (ans[p[i]]>=mod) ans[p[i]] -= mod;
				ans[i/p[i]] += ans[i];
				if (ans[i/p[i]]>=mod) ans[i/p[i]] -= mod;
			} else {
				res = res*(1+ans[i])%mod;
			}
		}
		out.println(res);
		
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			// br = new BufferedReader(new FileReader("input.txt"));
			// out = new PrintWriter("output.txt");
			solve();
			br.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(123);
		}
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s,", \t");
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
		new Thread(new Main()).start();
	}
}
