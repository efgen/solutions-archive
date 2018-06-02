import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
int[] x,y;
int px,py;

public static void main(String[] args) throws IOException {
new Main().run();
}
long zn (long x1, long y1, long x2, long y2) {
	return x1*y2-x2*y1;
}
boolean test(int i, int j, int k) {
	if ((zn(px-x[i],py-y[i],x[j]-x[i],y[j]-y[i])<=0 && 
		zn(px-x[j],py-y[j],x[k]-x[j],y[k]-y[j])<=0 &&
		zn(px-x[k],py-y[k],x[i]-x[k],y[i]-y[k])<=0) ||
		(zn(px-x[i],py-y[i],x[j]-x[i],y[j]-y[i])>=0 && 
		 zn(px-x[j],py-y[j],x[k]-x[j],y[k]-y[j])>=0 &&
		 zn(px-x[k],py-y[k],x[i]-x[k],y[i]-y[k])>=0))
		return true; else return false;
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  px = in.nextInt();
  py = in.nextInt();
  int n = in.nextInt();
  x = new int[n+1];
  y = new int[n+1];
  for (int i=1; i<=n; i++) {
	  x[i] = in.nextInt();
	  y[i] = in.nextInt();
  }
  x[0] = x[n]; y[0] = y[n];  
  boolean f = false;
  for (int i=2; i<n && !f; i++)
	  f = test(1,i,i+1);
  if (f) out.print("0.000"); else {  
	  double best = Double.POSITIVE_INFINITY;
	  for (int i=1; i<=n; i++)
		  best = Math.min(best, Math.sqrt((x[i]-px)*(x[i]-px)+(y[i]-py)*(y[i]-py)));
	  for (int i=0; i<n; i++)
		  if ((px-x[i])*(x[i+1]-x[i])+(py-y[i])*(y[i+1]-y[i])>0 &&
			  (px-x[i+1])*(x[i]-x[i+1])+(py-y[i+1])*(y[i]-y[i+1])>0) {
			  double a = y[i+1]-y[i];
			  double b = x[i]-x[i+1];
			  double c = -a*x[i]-b*y[i];
			  double d = Math.abs(a*px+b*py+c)/Math.sqrt(a*a+b*b);
			  best = Math.min(best, d);
		  }
	  best *= 2;
	  out.printf(Locale.US,"%1.3f",best);
  }
  
  in.close(); out.close();
}

}


