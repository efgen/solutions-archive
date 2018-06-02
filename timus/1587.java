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
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}
int[] d,t;
BigInteger pr(int l, int r) {
	return BigInteger.valueOf(2).pow(d[r]-d[l-1]).multiply(BigInteger.valueOf(3).pow(t[r]-t[l-1]));
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = nextInt();
  int[] a = new int[n+2];
  d = new int[n+1];
  t = new int[n+1];
  for (int i=1; i<=n; i++) a[i] = nextInt();
  for (int i=1; i<=n; i++) {
	  t[i] = t[i-1];
	  d[i] = d[i-1];
	  if (Math.abs(a[i])==2) d[i]++; else
		  if (Math.abs(a[i])==3) t[i]++; 
  }
  BigInteger res = BigInteger.valueOf(a[1]);
  int l = 1, r = 1;
  int z = -4;
  while (l<=n) {
	  r = l;
	  int lastM = 0, firstM = 0, k = 0;	
	  while (r<=n && a[r]!=0) {
		  if (a[r]<0) {
			  k++;
			  lastM = r;
			  if (firstM==0) firstM = r;
		  }				 
		  r++;  		  
	  }	  
	  if (a[r]==0) r--;
	  if (r<l) {
		  z = Math.max(z, 0);
		  l++;
		  continue;
	  } else
	  if (l==r) {
		  z = Math.max(z, a[l]);
		  l++;
		  continue;
	  }
	  
	  BigInteger x = pr(l,r);	  
	  if (k%2==0) {
		  if (x.compareTo(res)>0) res = x;
	  } else {
		  x = pr(firstM+1,r);
		  if (x.compareTo(res)>0) res = x;
		  x = pr(l,lastM-1);
		  if (x.compareTo(res)>0) res = x;
	  }
	  l = r+1;
  }
  if (res.compareTo(BigInteger.valueOf(z))<0) res = BigInteger.valueOf(z);
  out.print(res);  
  out.close();    
}   
  
}




