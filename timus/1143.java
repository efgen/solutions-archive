import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	//static final String FileName = "test";
	double inf = 1e+100;
	int n;
	double[][] a;
	double[][][] d;
	int next(int x) {
		return (x+n-1)%n;
	}
	int prev(int x) {
		return (x+1)%n;
	}
	double go(int i, int j, int k) {
		if (d[i][j][k]==inf) {
			if (i==j) return d[i][j][k] = 0;
			double res = inf;
			if (k==0) {
				res = Math.min(res, a[i][next(i)]+go(next(i), j, 0));
				res = Math.min(res, a[i][j]+go(next(i), j, 1));
			} else {
				res = Math.min(res, a[j][prev(j)]+go(i, prev(j), 1));
				res = Math.min(res, a[j][i]+go(i, prev(j), 0));
			}	
			return d[i][j][k] = res;
		}
		return d[i][j][k];
	}
	void solve() throws IOException {
		n = nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i=0; i<n; i++) {
			x[i] = nextDouble();
			y[i] = nextDouble();
		}
		a = new double[n][n];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				a[i][j] = Math.hypot(x[i]-x[j], y[i]-y[j]);
		d = new double[n][n][2];
		for (double[][] dd:d) for (double[] ddd:dd) Arrays.fill(ddd, inf);		
		
		double res = inf;
		for (int i=0; i<n; i++) {
			res = Math.min(res, go(i, prev(i), 0));
			res = Math.min(res, go(i, prev(i), 1));
		}
		out.printf(Locale.US, "%1.3f", res);
		  
	}
	
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
		new Main().run();
	}
}
