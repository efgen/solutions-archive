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
static double nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return inST.nval;
}

public void run() {	
	int n = in.nextInt();
	int m = in.nextInt();
	double[] a = new double[m+1];
	double[] b = new double[m+1];
	Arrays.fill(a, 1e+50); a[0] = 0;
	int K, P, Q;
	double dx,price;
	K = in.nextInt();
	P = in.nextInt();
	Q = in.nextInt();
	dx = 0;
	if (K>1) dx = (Q-P)*1.0/(K-1);
	price = P;
	int sz = Math.min(K,m);
	for (int k=1; k<=sz; k++, price += dx) a[k] = a[k-1] + price;
	for (int i=1; i<n; i++) {
		K = in.nextInt();
		P = in.nextInt();
		Q = in.nextInt();
		dx = 0;
		if (K>1) dx = (Q-P)*1.0/(K-1);
		price = P;
		b = a.clone();
		sz = Math.min(m, sz+K);
		/*for (int j=0; j<=sz; j++) {
			price = P;
			for (int k=1; k<=K; k++, price += dx)  {	
				a[j] = Math.min(a[j], b[j-k]+price);					
			}
		}*/
		double z  = price;
		for (int k=1; k<=K; k++, price += dx, z += price)  {		
			for (int j=sz; j>=k; j--)
			a[j] = Math.min(a[j], b[j-k]+z);
		}	
	}

	if (sz<m) out.println("Maximum possible amount: "+sz); 
	out.printf(Locale.US, "Minimum possible cost: %1.2f\n",a[sz]);
	out.flush();
}
}


