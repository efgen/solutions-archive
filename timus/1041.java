import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable{
static BufferedReader br;
static Scanner in;
static StreamTokenizer inST;
static PrintWriter out;

public static void main(String[] args) throws IOException {
	br = new BufferedReader(new InputStreamReader(System.in));
	in = new Scanner(br);
	inST = new StreamTokenizer(br);
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	new Thread(new Main()).start();
}
static int nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return (int)inST.nval;
}
class Frac implements Cloneable{
	long p,q;
	long gcd(long a, long b) {
		if (b==0) return a; else return gcd(b,a%b);
	}
	Frac(long p,long q) {
		long d = gcd(p,q);
		if (d!=1) {
		this.p = p/d;
		this.q = q/d;	
		if (this.q<0) {
			this.p *= -1;
			this.q *= -1;
		}
		} else {
			this.p = p;
			this.q = q;
		}
	}
	Frac(long p,long q,boolean f) {		
		this.p = p;
		this.q = q;
	}	
	Frac(int x) {
		p = x;
		q = 1;
	}
	Frac mult(Frac x) {	
		return new Frac(p*x.p,q*x.q);	
	}
	Frac div(Frac x) {
		return new Frac(p*x.q,q*x.p);	
	}
	Frac add(Frac x) {
		return new Frac(p*x.q+x.p*q,q*x.q);
	}
	Frac sub(Frac x) {		
		return new Frac(p*x.q-x.p*q,q*x.q);
	}
	boolean isZero() {
		return p==0;
	}
	boolean isOne() {
		return p==1 && q==1;
	}
	public Frac clone() {
		return new Frac(p,q,true);
	}
	public String toString() {
		return p+"/"+q;
	}
}
class Point implements Comparable {
	int price, x;
	Point(int k, int p) {
		price = p;
		x = k;
	}
	public int compareTo(Object arg0) {
		int X =  price-((Point)arg0).price;
		if (X==0) return x-((Point)arg0).x; else return X;	
	}
}
public void run() {
	int n = nextInt();
	int m = nextInt();
	Frac[][] a = new Frac[n][m];
	for (int i=0; i<n; i++) 
		for (int j=0; j<m; j++) 
			a[i][j] = new Frac(nextInt());
	Point[] sort = new Point[n];
	for (int i=0; i<n; i++) sort[i] = new Point(i,in.nextInt());
	Arrays.sort(sort);
	int[] ind = new int[m];
	for (int i=0; i<m; i++) ind[i] = i;
	boolean[] f = new boolean[n];
	Vector<Integer> res = new Vector<Integer>();
	long ans = 0;
	int step = 0;
	for (int iPrime=0; step<m && iPrime<n; iPrime++,step++) {
		int i = sort[iPrime].x;
		int k = step;
		while (k<m && a[i][ind[k]].isZero()) k++;
		if (k>=m) {
			f[i] = true;
			step--;
			continue;
		}
		int q = ind[k]; 
		ind[k] = ind[step]; 
		ind[step] = q;
		Frac X = a[i][ind[step]].clone();
		if (!X.isOne())
			for (k=step; k<m; k++) a[i][ind[k]] = a[i][ind[k]].div(X);
		f[i] = true;
		ans += sort[iPrime].price;
		res.add(sort[iPrime].x);
		for (int ii=0; ii<n; ii++)
			if (!f[ii]) {
				Frac x = a[ii][ind[step]].clone();
				if (x.isZero()) continue;
				for (k=step; k<m; k++)
					a[ii][ind[k]] = a[ii][ind[k]].sub(a[i][ind[k]].mult(x));
			}
	}
	if (res.size()<m) out.print(0); else {
		out.println(ans);
		Integer[] r = res.toArray(new Integer[0]); Arrays.sort(r);
		for (int x:r) out.println((x+1));
	}
	out.flush();
}
}


