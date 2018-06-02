import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
double A,B,C,R,vx,vy,vz,k1,k2,k3,a,b,c,d,Cx,Cy,Cz,Sx,Sy,Sz;
public static void main(String[] args) throws IOException {
new Main().run();
}
boolean Check(double t) {
	if (t<=0) return false;
	double x = Sx+vx*t-Cx;
	double y = Sy+vy*t-Cy;
	double z = Sz+vz*t-5*t*t-Cz;
	if (x*x+y*y+z*z<R*R) return true; else return false;
}
boolean solve(){
	if (a==0) 
		if (b!=0) return Check(-c/b); else {
			if (c!=0) return false; else { 
				//for (int i=1; i<=3; i++) i--;
				return false;
			}
		}	
	if (d<0) return false; else
	return Check((-b+Math.sqrt(d))/(2*a))|| Check((-b-Math.sqrt(d))/(2*a));  
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  Cx = in.nextDouble();
  Cy = in.nextDouble();
  Cz = in.nextDouble();
  A = in.nextDouble();
  B = in.nextDouble();
  C = in.nextDouble();
  R = in.nextDouble();
  Sx = in.nextDouble();
  Sy = in.nextDouble();
  Sz = in.nextDouble();
  vx = in.nextDouble();
  vy = in.nextDouble();
  vz = in.nextDouble();
  k1 = Sx-Cx;
  k2 = Sy-Cy;
  k3 = Sz-Cz;
  a = 5*C;
  b = -(A*vx+B*vy+C*vz);
  c = -(A*k1+B*k2+C*k3);
  d = b*b-4*a*c;
  if (solve()) out.print("HIT");
  else out.print("MISSED");  
  in.close(); out.close();
}

}


