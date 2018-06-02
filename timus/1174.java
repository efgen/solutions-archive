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


BigInteger solve(int[] a, int n) {
	if (n==1) return BigInteger.valueOf(1);
	int[] b = a.clone();
	boolean f = false;
	int k = 0;
	for (int i=1; i<=n; i++)
		if (a[i]==n) {
			f = true;
			k = i;
		} else
		if (f) b[i-1] = a[i]; else b[i] = a[i];
	BigInteger res = solve(b,n-1);
	if (res.testBit(0)) {
		res = res.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(n)).add(BigInteger.valueOf(n-k+1));
	} else {
		res = res.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(n)).add(BigInteger.valueOf(k));
	}
	return res;
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);

  int n = in.nextInt();
  int[] a = new int[n+1];
  for (int i=1; i<=n; i++) a[i] = in.nextInt();
  out.println(solve(a,n)); 
  in.close(); out.close();  
}
}
