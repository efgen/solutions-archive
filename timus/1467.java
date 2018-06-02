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
long gcd(long a, long b) {
	if (b==0) return a; else return gcd(b,a%b);
}
class Frac {
	long x,y;
	Frac socr() {
		long d = Math.abs(gcd(x,y));
		return new Frac(x/d,y/d);
	}
	Frac(long xx, long yy) { x = xx; y = yy; }
	Frac add(Frac f) {
		return new Frac(x*f.y+y*f.x,y*f.y).socr();
	}
	Frac sub(Frac f) {
		return new Frac(x*f.y-y*f.x,y*f.y).socr();
	}
	Frac mult(Frac f) {
		return new Frac(x*f.x,y*f.y).socr();
	}
	Frac mult(long X) {
		return new Frac(x*X,y).socr();
	}
	Frac div(long X) {
		return new Frac(x,y*X).socr();
	}
	public String toString() {
		return x+"/"+y;
	}
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int N = in.nextInt();
  long[][] C = new long[N+2][N+2];
  for (int i=0; i<=N+1; i++) { C[i][0] = 1; C[i][i] = 1; }
  for (int i=1; i<=N+1; i++) 
	  for (int j=1; j<i; j++)
		  C[i][j] = C[i-1][j-1]+C[i-1][j];

  Frac[][] a = new Frac[N+2][N+2];
  a[0][0] = new Frac(0,1);
  a[0][1] = new Frac(1,1);
  for (int n=1; n<=N; n++) {
	  for (int k=0; k<=n+1; k++) 
		  a[n][k] = new Frac(C[n+1][k],1);
	  for (int k=0; k<n; k++) 
		  for (int i=0; i<=k+1; i++)
			  a[n][i] = a[n][i].sub(a[k][i].mult(C[n+1][k])); 
	  
	  a[n][0] = a[n][0].sub(new Frac(1,1));
	  for (int k=0; k<=n+1; k++) a[n][k] = a[n][k].div(n+1); 
  }
  for (int i=0; i<=N+1; i++) out.print(a[N][N+1-i]+" ");
  in.close(); out.close();  
}
}


