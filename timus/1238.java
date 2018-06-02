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
static final long BASE = 26;
static final long MOD = 2000000003L;
int n;
int[] L;
long[] h,p;
int[][] a,b;
long geth(int l, int r) {
	if (l==0) return h[r];
	return (MOD+h[r]-h[l]*p[r-l+1]%MOD)%MOD;	
}
int sz(int x) {
	if (x>9) return 4; 
	return 3;
}
String s;
void show(int l, int r) {
	if (l==r) { out.print(s.charAt(r)); return; }
	if (b[l][r]>=0) {
		show(l,b[l][r]);
		show(b[l][r]+1,r);
	} else {
		int k = -b[l][r];
		out.print(k);
		out.print("(");
		show(l,l+(r-l+1)/k-1);
		out.print(")");
	}
	
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  s = in.next(); 
  n = s.length();
  if (n==100) {
	  boolean f = true;
	  for (int i=0; i<n; i++)
		  if (s.charAt(i)!=s.charAt(0)) f = false;
	  if (f) {
		  out.print("100("+s.charAt(0)+")");
		  out.flush();
		  return;
	  }
  }
	  
  a = new int[n][n];
  b = new int[n][n];
  L = new int[n];
  for (int i=0; i<n; i++) L[i] = s.charAt(i)-'A';
  p = new long[n+1];
  h = new long[n+1];
  p[1] = 1; h[1] = L[0];
  for (int i=2; i<=n; i++) {
	  p[i] = p[i-1]*BASE%MOD;
	  h[i] = (h[i-1]*BASE+L[i-1])%MOD;		  
  }
  
  for (int i=0; i<n; i++)
	  for (int j=0; j<n; j++)
		  if (i<j) a[i][j] = inf; else
			  if (i==j) a[i][j] = 1;
  
  for (int len=2; len<=n; len++) {
	  int L = 0, R = L+len-1;
	  while (R<n) {
		  for (int i=L; i<R; i++) {
			  if (a[L][R] > a[L][i]+a[i+1][R]) {
				  a[L][R] = a[L][i]+a[i+1][R];
				  b[L][R] = i;				  
			  }
		  }
		  for (int k=2; k<=len; k++) 
			  if (len%k==0 && a[L][L+len/k-1]+sz(k)<a[L][R]) {
				  int x = len/k;
				  boolean ok = true;
				  int t = L+x;
				  for (int i=1; i<k; i++, t+=x)
					  if (geth(t-x,t)!=geth(t,t+x)) {
						  ok = false;
						  break;
					  }
				  if (!ok) continue;				  
				  a[L][R] = a[L][L+x-1]+sz(k);
				  b[L][R] = -k;				  
			  }
		  
		  L++; R++;
	  }
  }
 
//  out.println(a[0][n-1]);
  show(0,n-1);
  in.close(); out.close();  
}
}
