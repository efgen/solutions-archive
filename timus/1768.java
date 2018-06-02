import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	//static final String FileName = "test";
	double sq(double x) {
		return x*x;
	}
	void solve() throws IOException {
		int n = nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		double x0 = 0, y0 = 0;
		for (int i=0; i<n; i++) {
			x[i] = nextDouble();
			y[i] = nextDouble();
			x0 += x[i];
			y0 += y[i];
		}
		x0 /= n; y0 /= n;
		double R = 0;
		for (int i=0; i<n; i++) R += Math.sqrt(sq(x[i]-x0)+sq(y[i]-y0));
		R /= n;
		double eps = 1e-6;
		boolean ok = true;
		for (int i=0; i<n; i++) ok &= Math.abs(Math.hypot(x[i]-x0, y[i]-y0)-R)<eps;
		double a0 = Math.atan2(y[0]-y0, x[0]-x0);
		boolean ok1 = true;
		boolean ok2 = true;
		for (int i=0; i<n; i++) {
			ok1 &= Math.abs(x0+R*Math.cos(a0+2*i*Math.PI/n)-x[i])<eps;
			ok1 &= Math.abs(y0+R*Math.sin(a0+2*i*Math.PI/n)-y[i])<eps;
			
			ok2 &= Math.abs(x0+R*Math.cos(a0-2*i*Math.PI/n)-x[i])<eps;
			ok2 &= Math.abs(y0+R*Math.sin(a0-2*i*Math.PI/n)-y[i])<eps;
		}
		ok &= ok1 || ok2;
		if (ok) out.println("YES"); else out.println("NO");
		  
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
