import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}   
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

char nextC() throws IOException {
	in.nextToken();
	return in.sval.charAt(0);
}
long mod, inv2, inv3, inv4;
long[] S = new long[5];
IntervalTree[] t;
class IntervalTree {
	long[] a;
	int n;
	IntervalTree(int n) {
		this.n = n;
		a = new long[n+1];
	}
	void add(long x, int pos) {
		while (pos<=n) {
			a[pos] = (a[pos]+x)%mod;
			pos = (pos<<1) - (pos&(pos-1));
		}
	}
	long sum(int pos) {
		long res = 0;
		while (pos>0) {
			res = (res+a[pos])%mod;
			pos &= pos-1;
		}
		return res;
	}
	long sum(int l, int r) {
		long res = sum(r)-sum(l-1);
		if (res<0) res += mod;
		if (res>=mod) res -= mod;		
		return res;
	}
}
long add(long x, long y, int k) { // x^k-y^k;
	x %= mod; y %= mod;
	if (x<0) x += mod;
	if (y<0) y += mod;
	long xx = 1, yy = 1;
	for (int i=1; i<=k; i++) {
		xx = xx*x%mod;
		yy = yy*y%mod;
	}
	xx -= yy;
	if (xx<0) xx += mod;
	if (xx>=mod) xx -= mod;
	return xx;
}
void sum(int l, int r) {
	long s1 = t[1].sum(l,r);
	long s2 = t[2].sum(l,r);
	long s3 = t[3].sum(l,r);
	long s4 = t[4].sum(l,r);
	S[1] = s1;
	
	S[2] = (S[1]*s1%mod - s2 + mod)%mod;
	S[2] = S[2]*inv2%mod;
	
	S[3] = (S[2]*s1%mod - S[1]*s2%mod + s3 + mod)%mod;
	S[3] = S[3]*inv3%mod;
	
	S[4] = (S[3]*s1%mod - S[2]*s2%mod + S[1]*s3%mod - s4 + 2*mod)%mod;
	S[4] = S[4]*inv4%mod;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = nextInt();
  int m = nextInt();
  mod = nextInt();
  long[] el = new long[n+1];
  t = new IntervalTree[5];
  for (int i=1; i<=4; i++)
	  t[i] = new IntervalTree(n);
  for (int i=1; i<=n; i++) {
	  el[i] = nextInt()%mod;
	  if (el[i]<0) el[i] += mod;
	  long x = 1;
	  for (int j=1; j<=4; j++) {
		  x = x*el[i]%mod;
		  t[j].add(x, i);
	  }	
  }
  inv2 = BigInteger.valueOf(2).modInverse(BigInteger.valueOf(mod)).intValue();
  inv3 = BigInteger.valueOf(3).modInverse(BigInteger.valueOf(mod)).intValue();
  inv4 = BigInteger.valueOf(4).modInverse(BigInteger.valueOf(mod)).intValue();
  while (m-->0) {
	  if (nextC()=='I') {
		  int ind = nextInt();
		  int d = nextInt();
		  for (int i=1; i<=4; i++) 
			  t[i].add(add(el[ind]+d,el[ind],i), ind);		  
		  el[ind] = (el[ind]+d)%mod;
		  if (el[ind]<0) el[ind] += mod;
	  } else {
		  int l = nextInt();
		  int r = nextInt();
		  int k = nextInt();
		  out.print(1);
		  sum(l,r);
		  for (int i=1; i<=k; i++) out.print(" "+S[i]);
		  out.println();
	  }
  }
  out.close();    
}   
  
}




