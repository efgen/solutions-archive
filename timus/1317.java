import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.*;
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
class Point {
	double x, y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
Point per(double x1, double y1, double x2, double y2,double x3, double y3, double x4, double y4) { // In some case not work
	double a1 = x2-x1;
	double a2 = y2-y1;
	double b1 = x3-x4;
	double b2 = y3-y4;
	double c1 = x3-x1;
	double c2 = y3-y1;
	double d = a1*b2-a2*b1;
	double dx = c1*b2-c2*b1;
	double dy = a1*c2-a2*c1;
	if (Math.abs(d)<1e-8) return null;
	double x = dx/d;
	double y = dy/d;
	if (x<0 || y<0 | x>1 || y>1) return null;
	return new Point(x1+(x2-x1)*x,y1+(y2-y1)*x);		
}
double sqr(double x) {
	return x*x;
}
double dist(double x1, double y1, double x2, double y2) {
	return Math.sqrt(sqr(x1-x2)+sqr(y1-y2));
}
public void run() {
	in.useLocale(Locale.US);
	int n = in.nextInt();
	double H = in.nextDouble();
	double[] ax = new double[n+1];
	double[] ay = new double[n+1];
	for (int i=0; i<n; i++) {
		ax[i] = in.nextDouble();
		ay[i] = in.nextDouble();
	}
	ax[n] = ax[0]; ay[n] = ay[0];
	double D = in.nextDouble();
	double x0 = in.nextDouble();
	double y0 = in.nextDouble();
	int k = in.nextInt();
	int res = k;
	while (k-->0) {
		double x = in.nextDouble();
		double y = in.nextDouble();	
		for (int i=0; i<n; i++) {			
			Point  p = per(ax[i],ay[i],ax[i+1],ay[i+1],x0,y0,x,y);
			if (p!=null) {
				double r1 = dist(p.x,p.y,x0,y0);
			//	double r2 = dist(p.x,p.y,x,y);
				double R = dist(x0,y0,x,y);
				if (Math.abs(R-r1)<1e-8) continue;
				double d = R*Math.sqrt(sqr(H/r1)+1);
				if (d>D) {
					res--;
					break;
				}
			}
			
		}
	}
	out.print(res);
	out.flush();
}
}


