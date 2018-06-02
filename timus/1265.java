import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {	
	Frac zer = new Frac(0,1);
	void solve() throws IOException	{
		
		Frac x1 = next();
		Frac y1 = next();
		Frac x2 = next();
		Frac y2 = next();
		Frac x3 = next();
		Frac y3 = next();
		Frac x4 = next();
		Frac y4 = next();
  
		Frac a1 = y4.sub(y3);
		Frac b1 = x3.sub(x4);
		Frac c1 = a1.mul(x3).add(b1.mul(y3));
  
		Frac a2 = b1.neg();
		Frac b2 = new Frac(a1);
		Frac c2 = a2.mul(x2).add(b2.mul(y2));  
		
  
		Frac d =  a1.mul(b2).sub(a2.mul(b1));
		Frac dx = c1.mul(b2).sub(c2.mul(b1));
		Frac dy = a1.mul(c2).sub(a2.mul(c1));
  
		Frac x = dx.div(d);
		Frac y = dy.div(d);
		
	//	out.println(x);
	//	out.println(y);
		
		x = x.add(x.sub(x2));
		y = y.add(y.sub(y2));
		
		if (intersect(x,y,x1,y1,x3,y3,x4,y4)) out.print("VISIBLE"); else out.print("INVISIBLE");

	
	}
	boolean intersect(Frac x1, Frac y1, Frac x2, Frac y2, Frac x3, Frac y3, Frac x4, Frac y4) {
		Frac xmax1 = x1.max(x2);
		Frac xmax2 = x3.max(x4);
		Frac xmin1 = x1.min(x2);
		Frac xmin2 = x3.min(x4);
		
		Frac ymax1 = y1.max(y2);
		Frac ymax2 = y3.max(y4);
		Frac ymin1 = y1.min(y2);
		Frac ymin2 = y3.min(y4);
		
		if (xmax1.cmp(xmin2)<0) return false;
		if (xmax2.cmp(xmin1)<0) return false;
		
		if (ymax1.cmp(ymin2)<0) return false;
		if (ymax2.cmp(ymin1)<0) return false;
		
		
		Frac z1 = kos(x1,y1,x2,y2,x3,y3).mul(kos(x1,y1,x2,y2,x4,y4));
		Frac z2 = kos(x3,y3,x4,y4,x1,y1).mul(kos(x3,y3,x4,y4,x2,y2));
		return z1.cmp(zer)<=0 && z2.cmp(zer)<=0;
	}
	Frac kos(Frac x0, Frac y0, Frac x1, Frac y1, Frac x2, Frac y2) {
		return kos2(x1.sub(x0),y1.sub(y0),x2.sub(x0),y2.sub(y0));
	}
	Frac kos2(Frac x1, Frac y1, Frac x2, Frac y2) {
		return x1.mul(y2).sub(x2.mul(y1));
	}
	
	Frac next() throws IOException {
		double a = nextInt();
		long d = 1;
		while (a*d-Math.floor(a*d)>1e-10) d *= 10;
		return new Frac(BigInteger.valueOf((long)(a*d)),BigInteger.valueOf(d));
	}
	class Frac {
		BigInteger x,y;
		Frac(long a, long b) {
			x = BigInteger.valueOf(a);
			y = BigInteger.valueOf(b);
			BigInteger d = x.gcd(y);			
			if (!d.equals(BigInteger.ONE)) {
				x = x.divide(d);
				y = y.divide(d);
			}
		}
		Frac(Frac a) {
			x = a.x;
			y = a.y;
		}
		Frac(BigInteger xx, BigInteger yy) {
			BigInteger d = xx.gcd(yy);
			x = xx; y = yy;
			if (!d.equals(BigInteger.ONE)) {
				x = x.divide(d);
				y = y.divide(d);
			}
		}
		Frac neg() {
			return new Frac(x.negate(),y);
		}
		Frac add(Frac a) {
			return new Frac(x.multiply(a.y).add(a.x.multiply(y)),y.multiply(a.y));
		}	
		Frac sub(Frac a) {
			return new Frac(x.multiply(a.y).subtract(a.x.multiply(y)),y.multiply(a.y));
		}
		Frac mul(Frac a) {
			return new Frac(x.multiply(a.x),y.multiply(a.y));
		}
		Frac div(Frac a) {
			return new Frac(x.multiply(a.y),y.multiply(a.x));
		}
		Frac min(Frac a) {
			if (this.cmp(a)>=0) return a; else return this;
		}		
		Frac max(Frac a) {
			if (this.cmp(a)<=0) return a; else return this;
		}
		int cmp(Frac a) {
			return x.multiply(a.y).compareTo(a.x.multiply(y));
		}
		public String toString() {
			return x+"/"+y;
		}
		
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

