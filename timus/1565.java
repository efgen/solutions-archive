import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	double f2(double p, double q) {
		return p/(1-(1-p)*(1-q));
	}
	double[] f(double p1, double p2, double p3) {
		double[] res = new double[3];
		if (p1==1) {
			if (p2<p3) {
				res[2] = 0;
				res[1] = p2;
				res[0] = 1-p2;
			} else {
				res[2] = p3;
				res[1] = 0;
				res[0] = 1-p3;
			}
		} else {
			double[] rr = f(p2,p3,p1);
			
			double v1 = rr[2];
			
			double v2 = p1*(1-f2(p2+p3-1,p1))+(1-p1)*v1;
			if (v1>v2) {
				res[0] = rr[2];
				res[1] = rr[0];
				res[2] = rr[1];
			} else {
				res[0] = v2;
				if (p2==1) res[1] = (1-p1)*rr[0]; else res[1] = p1*f2(p2,p1)+(1-p1)*rr[0];
				res[2] = 1-res[0]-res[1];
			}			
			
		}
		return res;
	}
	void solve() throws IOException	{
		double a = nextInt();
		double b = nextInt();
		double c = nextInt();
		double[][] r = new double[6][3];
		r[0] = f(a,b,c);
		r[1] = f(a,c,b);
		r[2] = f(b,a,c);
		r[3] = f(b,c,a);
		r[4] = f(c,a,b);
		r[5] = f(c,b,a);
		
		double r1 = r[0][0]+r[1][0]+r[2][1]+r[3][2]+r[4][1]+r[5][2];
		
		double r2 = r[0][1]+r[1][2]+r[2][0]+r[3][0]+r[4][2]+r[5][1];
		
		double r3 = r[0][2]+r[1][1]+r[2][2]+r[3][1]+r[4][0]+r[5][0];
		
		out.printf(Locale.US,"%1.5f %1.5f %1.5f",r1/6,r2/6,r3/6);

	
	}

	StreamTokenizer in;
	PrintWriter out;
	double nextInt() throws IOException {
		in.nextToken();
		return in.nval;
	}
	
	public void run(){
		try
		{
			in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}


