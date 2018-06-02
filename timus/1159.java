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
//	in = new Scanner(br);
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
static String nextS() {
	try {
		return br.readLine();
	}
	catch (IOException e) {}
	return null;
}


public void run() {
	int n =(int) nextInt();
	double[] a = new double[n+1];
	for (int i=1; i<=n; i++) a[i] = nextInt();
	Arrays.sort(a,1,n+1);
	double sum = 0;
	for (int i=1; i<n; i++) sum += a[i];
	sum -= a[n];
	if (sum<=0) {
		out.println("0.00");
		out.close();
		System.exit(0);
	}
	double l = a[n], r = 1e+10, d = a[n], s = 0;
	double eps = 1e-12;
	double res = 0;
	while (l+eps<=r) {
		d = (l+r)/2;
		s = 0;
		for (int i=1; i<=n; i++) s += Math.asin(a[i]/d);
		if (s<Math.PI) r = d; else l = d;
	}
//	out.println(s);
	if (Math.abs(Math.PI-s)<1e-6) {	
		for (int i=1; i<=n; i++) res += a[i]*Math.sqrt(r*r-a[i]*a[i]);
		res /= 4;
		out.printf(Locale.US, "%1.2f",res); out.flush();
	} else {
		l = a[n]; r = 1e+10;
		while (l+eps<=r) {
			d = (l+r)/2;
			s = 0;
			for (int i=1; i<n; i++) s += Math.asin(a[i]/d);
			s -= Math.asin(a[n]/d);
			if (s>0) r = d; else l = d;
		}
		if (Math.abs(s)<1e-6) {		
			for (int i=1; i<n; i++) res += a[i]*Math.sqrt(r*r-a[i]*a[i]);
			res -= a[n]*Math.sqrt(r*r-a[n]*a[n]);
			res /= 4;
			out.printf(Locale.US, "%1.2f",res);		
		} else out.printf(Locale.US, "%1.2f",res);		
	}	

	out.flush();
}
}


