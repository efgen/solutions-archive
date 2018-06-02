import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
double x,y;

public static void main(String[] args) throws IOException {
new Main().run();
}
double dist(double x1, double y1,double x2, double y2) {
	return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
double Kos(double x1, double y1,double x2, double y2) {
	return x1*y2-x2*y1;
}
boolean inTrian(double x1, double y1,double x2, double y2, double x3, double y3) {
	double a = Kos(x-x1,y-y1,x2-x1,y2-y1);
	double b = Kos(x-x2,y-y2,x3-x2,y3-y2);
	double c = Kos(x-x3,y-y3,x1-x3,y1-y3);	
	return ((a>=0) && (b>=0) && (c>=0)) || ((a<=0) && (b<=0) && (c<=0));
}
double distRev(double x1, double y1,double x2, double y2) {
	double res = Math.min(dist(x,y,x1,y1), dist(x,y,x2,y2));
	if (((x-x1)*(x2-x1)+(y-y1)*(y2-y1)>0) && ((x-x2)*(x1-x2)+(y-y2)*(y1-y2)>0)) 
		res = Math.abs(Kos(x-x1,y-y1,x2-x1,y2-y1))/dist(x1,y1,x2,y2);	
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  boolean[] f = new boolean[n+1];
  double[] x1 = new double[n+1];
  double[] x2 = new double[n+1];
  double[] x3 = new double[n+1];
  double[] x4 = new double[n+1];
  double[] y1 = new double[n+1];
  double[] y2 = new double[n+1];
  double[] y3 = new double[n+1];
  double[] y4 = new double[n+1];
  for (int i=1; i<=n; i++) {
	  x1[i] = in.nextDouble();
	  y1[i] = in.nextDouble();
	  x3[i] = in.nextDouble();
	  y3[i] = in.nextDouble();
	  f[i] = (x1[i]==x3[i]) && (y1[i]==y3[i]);
	  double px = (x1[i]+x3[i])/2;
	  double py = (y1[i]+y3[i])/2;
	  double d = dist(x1[i],y1[i],x3[i],y3[i])/2;
	  double a = y3[i]-y1[i];
	  double b = x1[i]-x3[i];
	  double ab = Math.sqrt(a*a+b*b);
	  x2[i] = px + a*d/ab;
	  x4[i] = px - a*d/ab;
	  y2[i] = py + b*d/ab;
	  y4[i] = py - b*d/ab;
  }
  x = in.nextDouble();
  y = in.nextDouble();
  double[] a = new double[n+1];
  for (int i=1; i<=n; i++) 
	  if (f[i]) a[i] = dist(x,y,x1[i],y1[i]); else 
		  if ((inTrian(x1[i],y1[i],x2[i],y2[i],x3[i],y3[i])) ||(inTrian(x1[i],y1[i],x4[i],y4[i],x3[i],y3[i])))  a[i] = 0; else {
			  a[i] = Math.min(distRev(x1[i],y1[i],x2[i],y2[i]), distRev(x2[i],y2[i],x3[i],y3[i]));
			  a[i] = Math.min(a[i], distRev(x3[i],y3[i],x4[i],y4[i]));
			  a[i] = Math.min(a[i], distRev(x1[i],y1[i],x4[i],y4[i]));
		  }
 // for (int i=1; i<=n; i++) out.println(a[i]);
  int[] ind = new int[n+1];
  for (int i=1; i<=n; i++) ind[i] = i;
  for (int i=1; i<=n; i++) {
	  int min = i;
	  for (int j=i+1; j<=n; j++)
		  if (Math.abs(a[ind[j]]-a[ind[min]])<1e-14) { if (ind[j]<ind[min]) min = j; } else
		  if (a[ind[j]]<a[ind[min]]) min = j;
	  int q = ind[i]; ind[i] = ind[min]; ind[min] = q; 
  }
  for (int i=1; i<=n; i++) out.print(ind[i]+" "); 	  
  
  in.close(); out.close();
}

}