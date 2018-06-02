import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
	
	void solve() throws IOException {
		int n = nextInt();
		double[] res = new double[n];
		int sz = 1<<n;
		double[] p = new double[sz];
		p[0] = 1;
		for (int msk=0; msk < sz-1; msk++) {
			double P = p[msk] / n;
			for (int i=0; i<n; i++) {
				int r = 0;
				int k = i;
				for (int j=0; j<n; j++, k++) {
					if (k==n) k = 0;
					int t = 1<<k;
					if ((msk & t)==0) {
						p[msk|t] += P;
						break;
					} else r++;
				}
				res[Integer.bitCount(msk)] += r*P;
			}
		}
		for (int i=0; i<n; i++) out.printf(Locale.US, "%1.6f\n", res[i]);
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
