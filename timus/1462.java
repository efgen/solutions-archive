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
BigInteger[][] a = new BigInteger[2][2];
BigInteger[][] mul(BigInteger[][] a, BigInteger[][] b) {
	BigInteger[][] r = new BigInteger[2][2];
	r[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
	r[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
	r[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
	r[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
	return r;
}
BigInteger[] pow(BigInteger[] x, int n) {
	BigInteger[] a = new BigInteger[4];
	BigInteger[]b = new BigInteger[4];
	a[0] = BigInteger.ONE; a[3] = BigInteger.ONE;
	a[1] = BigInteger.ZERO; a[2] = BigInteger.ZERO;
	b = x.clone();
	BigInteger[] r = new BigInteger[4];
	while (n>0) {
		if ((n&1)>0) {
			r[0] = a[0].multiply(b[0]).add(a[1].multiply(b[2]));
			r[1] = a[0].multiply(b[1]).add(a[1].multiply(b[3]));
			r[2] = a[2].multiply(b[0]).add(a[3].multiply(b[2]));
			r[3] = a[2].multiply(b[1]).add(a[3].multiply(b[3]));
			a = r.clone();
		} 
		{
			r[0] = b[0].multiply(b[0]).add(b[1].multiply(b[2]));
			r[1] = b[0].multiply(b[1]).add(b[1].multiply(b[3]));
			r[2] = b[2].multiply(b[0]).add(b[3].multiply(b[2]));
			r[3] = b[2].multiply(b[1]).add(b[3].multiply(b[3]));
			/*r[0][0] = b[0][0].multiply(b[0][0]).add(b[0][1].multiply(b[1][0]));
			r[0][1] = b[0][0].multiply(b[0][1]).add(b[0][1].multiply(b[1][1]));
			r[1][0] = b[1][0].multiply(b[0][0]).add(b[1][1].multiply(b[1][0]));
			r[1][1] = b[1][0].multiply(b[0][1]).add(b[1][1].multiply(b[1][1]));*/
			b  = r.clone();
		//	b[0] = r[0].clone();
		//	b[1] = r[1].clone();
		}
		n >>= 1;
	}
/*	while (n>0) {
		if ((n&1)>0) a = mul(a,b);
		b = mul(b,b);
		n >>= 1;
	}*/
	return a;
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
 // long t = System.currentTimeMillis();
  int n = in.nextInt();
  /*n--;
  BigInteger f1 = BigInteger.ONE;
  BigInteger f2 = BigInteger.ONE;
  BigInteger f3 = BigInteger.ZERO;
  for (int i=1; i<=n; i++) {
	  f3 = f1.add(f2);
	  if (i==n) break;
	  f1 = f2;
	  f2 = f3;
  }
  out.println(f1.add(f3)); */
 
  BigInteger[] a = new BigInteger[4];
  for (int  i=0; i<4; i++) a[i] = BigInteger.ONE; a[3] = BigInteger.ZERO;
  a = pow(a,n);
  BigInteger res = a[0].add(a[3]);
  out.println(res);
 // out.print(System.currentTimeMillis()-t);
  in.close(); out.close();  
}
}
