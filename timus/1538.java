import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.geom.*;
public class Main {
Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}
int n;
int[] a;
boolean[] f;
long[] x,y;
void test() {	
	a[0] = a[5];
	for (int i=0; i<5; i++) {
		long x1 = x[a[(i+1)%5]]-x[a[i]];
		long y1 = y[a[(i+1)%5]]-y[a[i]];
		long x2 = x[a[(i+2)%5]]-x[a[i]];
		long y2 = y[a[(i+2)%5]]-y[a[i]];
		if (x1*y2-x2*y1<0) return;
	}
	for (int i=0; i<5; i++) {
		Line2D.Double L = new Line2D.Double(x[a[i]],y[a[i]],x[a[(i+1)%5]],y[a[(i+1)%5]]);		
		Line2D.Double L1 = new Line2D.Double(x[a[(i+2)%5]],y[a[(i+2)%5]],x[a[(i+3)%5]],y[a[(i+3)%5]]);
		Line2D.Double L2 = new Line2D.Double(x[a[(i+3)%5]],y[a[(i+3)%5]],x[a[(i+4)%5]],y[a[(i+4)%5]]);
		if (L.intersectsLine(L1)) return;
		if (L.intersectsLine(L2)) return;
		
	}
		
	out.println("Yes");
	for (int i=1; i<=5; i++)
		out.print(a[i]+" ");
	in.close(); out.close();
	System.exit(0);
}
void gen(int k) {
	if (k>5) test(); else
	for (int i=1; i<=n; i++)
		if (!f[i]) {
			f[i] = true;
			a[k] = i;
			gen(k+1);
			f[i] = false;
		}
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  n = Math.min(9,in.nextInt());
  f = new boolean[n+1];
  a = new int[n+3];
  x = new long[n+1];
  y = new long[n+1];
  for (int i=1; i<=n; i++) {
	  x[i] = in.nextLong();
	  y[i] = in.nextLong();
  }
  gen(1);  
  out.println("No");
  in.close(); out.close();
}
}


