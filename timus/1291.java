import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
long gcd(long a, long b) {
	if (b==0) return a; else return gcd(b,a%b);
}

public static void main(String[] args) throws IOException {
new Main().run();
}


public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US); 
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int[] k = new int[n+1];
  long[] c = new long[n+1];
  long[] d = new long[n+1];
  boolean[] zn = new boolean[n+1];
  boolean[] f = new boolean[n+1];
  Vector[] a = new Vector[n+1];
  for (int i=1; i<=n; i++) {
	  k[i] = in.nextInt();
	  a[i] = new Vector();
	  while (true) {
		  int x = in.nextInt();
		  if (x==0) break;
		  a[i].add(x);
	  }
  }
  int start = in.nextInt(); int v = in.nextInt();
  int[] Q = new int[n+1];
  int s = 0, t = 1;
  Q[1] = start;
  zn[start] = v >= 0;
  for (int i=1; i<=n; i++) d[i] = 1;
  c[start] = v;
  f[start] = true;
  while (s<t) {
	  int x = Q[++s];
	  Iterator it = a[x].iterator();
	  while (it.hasNext()) {
		  int y = (Integer)it.next();
		  if (f[y]) continue;
		  Q[++t] = y;
		  f[y] = true;
		  long cc = c[x]*k[x];
		  long dd = d[x]*k[y];
		  long del = gcd(cc,dd);
		  c[y] = cc/del; d[y] = dd/del; zn[y] = !zn[x];
	  }
  }
  for (int i=1; i<=n; i++) {
	  if (!zn[i])
		  if (c[i]>0) out.print("-");
	  out.println(c[i]+"/"+d[i]);
  }
  in.close(); out.close();
}

}


