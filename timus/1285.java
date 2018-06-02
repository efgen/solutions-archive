import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}
double Sqr(double x) { return x*x; } 
double dist(double[] a, double[] b) {
	double res = 0;
	for (int i=0; i<8; i++) 
		res += Sqr(a[i]-b[i]);
	return Math.sqrt(res);
}
class Point {	
	double x,y,z;
	Point(double x, double y, double z) {
		this.x = x; this.y = y; this.z = z;
	}
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  double[] a = new double[8];
  double[] b = new double[8];
  double[] c = new double[8];
  double res = 0;
  for (int i=0; i<8; i++) a[i] = in.nextDouble();
  for (int i=0; i<8; i++) b[i] = in.nextDouble();
  for (int i=0; i<8; i++) c[i] = in.nextDouble();
  double R = in.nextDouble();  
  
  double d1 = dist(a,c);
  double d2 = dist(b,c);
  double d3 = dist(a,b);
  
  if (d3>0) {
	//  double cosf = (A.x-O.x)*(B.x-O.x)+(A.y-O.y)*(B.y-O.y)+(A.z-O.z)*(B.z-O.z);	 
	//  cosf /= d1*d2;
	  double cosf = (d1*d1+d2*d2-d3*d3)/(2*d1*d2);
	  if (cosf>1) cosf = 1; else if (cosf<-1) cosf = -1;
	  double sinf = Math.sqrt(1-Sqr(cosf));
	  double h = d1*d2*sinf/d3;
	  res = d3;
	  if (h<R) {
		  double f = Math.acos(cosf);	
		  f -= Math.acos(R/d1);
		  f -= Math.acos(R/d2);		
		  if (f>=0)
			  res = f*R + Math.sqrt(d1*d1-R*R) + Math.sqrt(d2*d2-R*R);
	  }  
  }
  out.printf(Locale.US, "%1.2f",res);
  in.close(); out.close();
}
}