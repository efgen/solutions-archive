import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;
int[] a;
int n;
int mod = 1000000000;

public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

int prev(int x) {
	return x & (x-1);
}
int next(int x) {
	return (x << 1) - (x & (x-1));
}
int sum(int x) {
	int res = 0;
	while (x>0) {
		res = (res+a[x])%mod;
		x = prev(x);
	}
	return res;
}

void modif(int x, int val) {
	while (x<=n) {
		a[x] = (a[x] + val)%mod;
		x = next(x);
	}
}

public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  n = nextInt(); 
  int k = nextInt();
  a = new int[n+1];  
  int[] x = new int[n+1];
  int[] r = new int[n+1];
  int[] rr = new int[n+1];
  for (int i = 1; i <= n; i++) x[i] = nextInt(); 
  for (int i = 1; i <= n; i++) r[i] = 1;
  while (k-->1) {
	  for (int i = 1; i <= n; i++) modif(x[i],r[i]);
	  for (int i = 1; i <= n; i++) {
		  rr[i] = sum(x[i]-1);
		  modif(x[i],mod-r[i]);
	  }
	  for (int i=1; i<=n; i++) r[i] = rr[i];
  }
  int res = 0;
  for (int i = 1; i <= n; i++) res = (res+r[i])%mod;
  out.println(res);  
  out.close();
}

}


