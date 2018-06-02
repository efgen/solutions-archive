import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

long gcd(long a, long b) {
	if (b==0) return a; else return gcd(b,a%b);
}
class EData {
	long x,y,d;
	EData(long d,long x, long y) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
EData euqlid(long a, long b) {
	if (b==0) return new EData(a,1,0);
	EData q = euqlid(b,a%b);
	return new EData(q.d,q.y,q.x-(a/b)*q.y);
}
long T = 0;
long solvUr(long a, long b, long n) {
	while (b<0) b += n;
	EData q = euqlid(a,n);
	if (b%q.d!=0) return -1;
	long t = n/q.d;
	long r = q.x*(b/q.d);
	r %= t;
	while (r<0) r += t;
	T = t;
	return r;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int n = nextInt();
  int[] l = new int[n+1];
  int[] r = new int[n+1];
  int[] a = new int[n+1];
  int[] b = new int[n+1];
  boolean[] fa = new boolean[n+1];
  boolean[] fb = new boolean[n+1];
  for (int i=1; i<=n; i++) {
	  l[i] = nextInt();
	  r[i] = l[i];
	  while (true) {
		  int x = nextInt();
		  if (x>0) r[i] = x; else break;
	  }
  }
  int p1 = nextInt();
  int p2 = nextInt();
  long c1 = 0, c2 = 0;
  int k = 1;
  while (a[p1]==0) {
	  a[p1] = k++;
	  p1 = l[p1];
  }
  for (;!fa[p1];p1 = l[p1]) fa[p1] = true;
  c1 = k - a[p1];
  k = 1;
  while (b[p2]==0) {
	  b[p2] = k++;
	  p2 = r[p2];
  }
  for (;!fb[p2];p2 = r[p2]) fb[p2] = true;
  c2 = k - b[p2];
//  for (int i=1; i<=n; i++) out.print(a[i]+" ");
 // long d = gcd(c1,c2);  
//  long K = BigInteger.valueOf(c2/d).modInverse(BigInteger.valueOf(c1/d)).longValue();
  long inf = (1L<<63)-1;
  long res = inf;
  for (int i=1; i<=n; i++) {
	  if (a[i]==0 || b[i]==0) continue;
	  if (a[i]==b[i]) res = Math.min(res, a[i]);	  
	  if (fa[i] && fb[i]) {
		  long y = solvUr(c2%c1,(a[i]-b[i])%c1,c1);		  
		  if (y>=0) { 
			  long K = Math.max((long)Math.ceil((a[i]-b[i]-c2*y)*1.0/(c2*T)),0);
			  y += K*T;
			  res = Math.min(res, c2*y+b[i]);
		  }
		 /* long c = (100000*c1+a[i]-b[i])%c1;
		  if (c%d>0) continue;
		  long x = K*(c/d)%c1;
		  res = Math.min(res, c2*x+b[i]);	*/	 
	  } else
	  if (fa[i] && !fb[i]) {
		  if (b[i]>=a[i] && (b[i]-a[i])%c1==0) res = Math.min(res, b[i]);
	  } else
	  if (!fa[i] && fb[i]) {
		  if (a[i]>=b[i] && (a[i]-b[i])%c2==0) res = Math.min(res, a[i]);
	  }
  
  }
  if (res==inf) out.print(-1); else out.print(res-1);  
  out.close();
}

}


