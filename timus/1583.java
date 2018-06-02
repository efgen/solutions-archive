import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
StreamTokenizer in;
PrintWriter out;
int inf = 1000000000;

public static void main(String[] args) throws IOException {
new Main().run();
}
double[] x,r;
int n;
double nextInt() throws IOException {
	in.nextToken();
	return in.nval;
}
double calc(double A, double B) {
	double res = 0;
	for (int i=0; i<n; i++) {
		double a = A-x[i];
		if (a<-r[i]) a = -r[i]; else
			if (a>r[i]) continue;
		double b = B-x[i];
		if (b>r[i]) b = r[i]; else
			if (b<-r[i]) continue;
		res += b*(r[i]*r[i]-b*b/3); 
		res -= a*(r[i]*r[i]-a*a/3); 
	}
	return (B-A)*1e10-Math.PI*res;	
}
public void run() throws IOException {
 // in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  out = new PrintWriter(System.out);
  n = (int)nextInt();
  x = new double[n];
  r = new double[n];
  for (int i=0; i<n; i++) {
	  nextInt();
	  x[i] = nextInt()*10000;	 
	  nextInt();
	  r[i] = nextInt()*10000;
  }
  Vector<Integer> RES = new Vector<Integer>();
  int last = 0;
  double need = 5e+14;
  while (true) {
	  double L = last, R = 1e+6, V = 0;
	  while (R-L>1e-6) {
		  double mid = (L+R)/2;
		  V = calc(last,mid);
		  if (V>need) R = mid; else L = mid;
	  }		 
	  last = (int)Math.round(R);
	  if (last==1000000) break;
	  RES.add(last);	 
  }
  out.println(RES.size());
  for (int x:RES) out.println(x);
  out.close();  
}
}
