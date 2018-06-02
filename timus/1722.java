import java.io.*;
import java.security.AllPermission;
import java.util.*;
import java.math.*;

import javax.swing.text.html.HTML;

public class Main{
	//static final String FileName = "test";
	double sq(double x) {
		return x*x;
	}
	void solve() throws IOException {
		double RR = nextDouble();
		double r = nextDouble();
		double R = nextDouble();		
		double d = Math.hypot(nextDouble(), nextDouble());
		double Rr = R-r;
		double sina = Rr/d;
		double alf = Math.asin(sina);
		double d2 = r/sina;
		
		double D = sina*sina*((sina*sina-1)*d2*d2-RR*RR)+RR*RR;
		double x = Math.sqrt(D)-sina*sina*d2;
		double y = Math.sqrt(RR*RR-x*x);
		double bet = Math.acos(x/RR);
		double S1 = (d2+x)*y;
		double SSec = R*R*(Math.PI/2+alf);
		double kat = Math.sqrt(sq(d2+d)-sq(R));
		double S2 = kat*R;
		S1 -= S2;
		S1 -= SSec;
		double SSeg = bet*RR*RR-x*y;
		S1 += SSeg;
		S1 += Math.PI*R*R;
		double SS = Math.PI*RR*RR;
		double res = S1/SS;
		out.printf(Locale.US, "%1.10f", res*100);
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
