import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
 /*
  BigInteger[] a = new BigInteger[n+1];
  for (int i=1; i<=n; i++) a[i] = BigInteger.valueOf(i);
  for (int i=5; i<=n; i++) {
	  BigInteger max = new BigInteger("1");
	  for (int j=2; j<i; j++) {
		  BigInteger x = a[j].multiply(a[i-j]); 
		  if (x.compareTo(max)>0) max = x;
	  }
	  a[i] = max;
  }
  out.println(a[n]);
  for (int i=1; i<=n; i++) 
  out.println(i+" "+a[i]);
  */
  BigInteger r = new BigInteger("3");
  BigInteger two = new BigInteger("2");
  if (n==1) r = BigInteger.valueOf(1); else
	  if (n%3==0) r = r.pow(n/3); else
		  if (n%3==1) r = r.pow(n/3-1).multiply(two).multiply(two); else r = r.pow(n/3).multiply(two);
  out.print(r);
  in.close(); out.close();
}

}


