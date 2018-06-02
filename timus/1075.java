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
double dist(Point a, Point b) {
	return Math.sqrt(Sqr(a.x-b.x)+Sqr(a.y-b.y)+Sqr(a.z-b.z));
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
  double res = 0;
  Point A = new Point(in.nextDouble(),in.nextDouble(),in.nextDouble());
  Point B = new Point(in.nextDouble(),in.nextDouble(),in.nextDouble());
  Point O = new Point(in.nextDouble(),in.nextDouble(),in.nextDouble());  
  double R = in.nextDouble();  
  
  double d1 = dist(A,O);
  double d2 = dist(B,O);
  double d3 = dist(A,B);
  
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