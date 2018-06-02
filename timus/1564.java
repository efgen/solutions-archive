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
long f(long x) {
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
		if (c==1) res += x+1;
		if (c>1) res += d;
		k--; d /= 10;
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

  long ed = in.nextLong();  
  long L = 1, R = 1000000000000000000L;
  while (L<R) {
	  long mid = (L+R)/2;
	  long E = f(mid);
	  if (E<ed) L = mid+1; else R = mid; 
  }
  if (f(R)==ed) out.println(R); else out.println("Petr lies");
  in.close(); out.close();  
}
}
