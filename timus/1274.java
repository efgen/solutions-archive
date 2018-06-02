import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
class Point{
	long x,y;
	Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
Point nextFr() {
	StringTokenizer st = new StringTokenizer(in.nextLine(),"- /",true);
	long zn = 1;
	long d = 0;
	long v = 0;
	long n = 1;
	String s = st.nextToken();
	if (s.equals("-")) {zn=-1; s = st.nextToken();}
	if (st.countTokens()==0) return new Point(zn*Integer.parseInt(s),1);
	if (st.countTokens()>2) { d = Integer.parseInt(s); st.nextToken(); s = st.nextToken(); }
	v = Integer.parseInt(s); st.nextToken(); n = Integer.parseInt(st.nextToken());
	return  new Point(zn*(d*n+v),n);	
}
long gcd(long a,long b) {
	if (b==0) return a; else return gcd(b,a%b);
}
Point red(Point p) {
	long d = gcd(Math.abs(p.x),Math.abs(p.y));
	if (p.y<0) d *= -1;
	return new Point(p.x/d,p.y/d);
}
void show(Point p) {
	long x = p.x, y = p.y;	
	if (x==0) {out.print(0); return;}
	if (x<0) {out.print("-"); x *= -1;}
	long d = x/y;	
	if (d!=0) out.print(d+" ");	
	if (x%y!=0) out.print(x%y+"/"+y);
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  Point p1 = nextFr();
  char c = in.nextLine().charAt(0);
  Point p2 = nextFr();
  Point p = new Point(0,0);
  switch (c) {
  case '+': {	  
	  p = new Point(p1.x*p2.y+p2.x*p1.y,p1.y*p2.y);
	  break;
  }
  case '-': {	  
	  p = new Point(p1.x*p2.y-p2.x*p1.y,p1.y*p2.y);
	  break;
  }
  case '*': {	  
	  p = new Point(p1.x*p2.x,p1.y*p2.y);
	  break;
  }
  case '/': {	  
	  p = new Point(p1.x*p2.y,p1.y*p2.x);
	  break;
  }	  
  }
  p = red(p);
  show(p);
 
  in.close(); out.close();
}

}
