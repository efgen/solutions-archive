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

long[] ans = new long[20];
long f(long x, int cif) {
	long res = 0;
	long d = 1;
	int k = 0;
	long xx = x;
	while (xx>9) {
		d *= 10;
		k++;
		xx /= 10;
	}
	while (k>=0) {
		long c = x/d;
		res += c*ans[k];
		x %= d;
		if (c==cif) res += x+1;
		if (c>cif) res += d;
		k--; d /= 10;
	}
	return res;
}
long cif(long x) {
	long res = 0;
	long d = 1;
	int k = 0;
	long xx = x;
	while (xx>9) {
		d *= 10;
		k++;
		xx /= 10;
	}
	while (k>=0) {
		res += x-d+1;
		d /= 10; k--;
	}
	return res;
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  ans[1] = 1;
  long d = 10;
  for (int i=2; i<20; i++, d *= 10) 
	  ans[i] = ans[i-1]*10+d;  

  long n = in.nextLong();
  long[] a = new long[10]; a[0] = cif(n);
  for (int i=1; i<10; i++) {
	  a[i] = f(n,i); a[0] -= a[i];	  
  }
  for (long x:a) out.println(x);
  in.close(); out.close();  
}
}
