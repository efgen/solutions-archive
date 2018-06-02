import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	//static final String FileName = "test";
	double A, B, C;
	double f(double x) {
		return (A*x*x+B*x+C)/(1+x*x);
	}
	void solve() throws IOException {
		double a1 = nextDouble();
		double b1 = nextDouble();
		double a2 = nextDouble();
		double b2 = nextDouble();
		A = (a1*a1+a2*a2);
		B = 2*(a1*b1+a2*b2);
		C = (b1*b1+b2*b2);
		double l = 0, r = 1;
		for (int i=0; i<400; i++) {
			double x1 = l+(r-l)/3;
			double x2 = r-(r-l)/3;
			if (f(x1)<f(x2)) l = x1; else r = x2;			
		}
		double res = f((l+r)/2);
		C = (a1*a1+a2*a2);
		B = 2*(a1*b1+a2*b2);
		A = (b1*b1+b2*b2);
		l = 0; r = 1;
		for (int i=0; i<400; i++) {
			double x1 = l+(r-l)/3;
			double x2 = r-(r-l)/3;
			if (f(x1)<f(x2)) l = x1; else r = x2;			
		}
		res = Math.max(f((l+r)/2), res);
		out.printf(Locale.US, "%1.20f", Math.sqrt(res));
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
