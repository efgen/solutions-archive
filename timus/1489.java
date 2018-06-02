import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;

public static void main(String[] args) throws IOException {
new Main().run();
}

class Point {
	double x,y,z;
	Point(double a, double b, double c) {
		x = a; y = b; z = c;
	}
}
Point gen(double a, double b, double c, double x, double y) {
	Point P = new Point(0,0,0);
	x -= c;
	y -= c+b;
	if (x<0) {
		P.x = 0;
		P.y = y;
		P.z = -x;		
	} else
	if (x>a) {
		P.x = a;
		P.y = y;
		P.z = x-a;
	} else {
		if (y>b) {
			P.x = x;
			P.y = b;
			P.z = y-b;
		} else
		if (y<0) {
			if (y>=-c) {
				P.x = x;
				P.y = 0;
				P.z = -y;
			} else {
				P.x = x;
				y += c+b;
				P.y = b-y;
				P.z = c;
			}
		} else {
			P.x = x;
			P.y = y;
			P.z = 0;
		}
	}
	return P;
}
double sqr(double x) { return x*x; }
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  double a = in.nextDouble();
  double b = in.nextDouble();
  double c = in.nextDouble();
  Point P1 = gen(a,b,c,in.nextDouble(),in.nextDouble());
  Point P2 = gen(a,b,c,in.nextDouble(),in.nextDouble());
  double d = Math.sqrt(sqr(P1.x-P2.x)+sqr(P1.y-P2.y)+sqr(P1.z-P2.z));
  out.printf(Locale.US, "%1.6f",d);
  in.close(); out.close();  
}
}
