import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
BigInteger[][] a = new BigInteger[1000][1000];

public static void main(String[] args) throws IOException {
new Main().run();
}
BigInteger solv(int n, int s) {
	if (s<0) return BigInteger.ZERO;
	if (a[n][s]!=null) return a[n][s];
	BigInteger res = BigInteger.ZERO;
	if (n==1) {
		if (s<10) res = BigInteger.ONE;
		a[n][s] = res;
		return res;
	}
	for (int c = 0; c<10; c++)
		res = res.add(solv(n-1,s-c));
	a[n][s] = res;
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int s = in.nextInt();
  if (s%2>0) out.print(0); else {
	  s /= 2;
	  out.print(solv(n,s).multiply(solv(n,s)));	  
  }
  in.close(); out.close();
}

}