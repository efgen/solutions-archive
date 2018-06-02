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
  int k = in.nextInt();
  if (k==0) out.print(1); else {
	  BigInteger[] a = new BigInteger[n+1];
	  BigInteger[] b = new BigInteger[n+1];
	  BigInteger sum = BigInteger.ZERO;
	  a[0] = BigInteger.ONE;
	  b[0] = BigInteger.ZERO;
	  for (int i=1; i<=k; i++) {
		  a[i] = a[i-1].add(b[i-1]);
		  b[i] = a[i];		  
		  sum = sum.add(a[i]);
	  }
	  for (int i=k+1; i<=n; i++) {
		  a[i] = a[i-1].add(b[i-1]);
		  b[i] = sum;
		  sum = sum.add(a[i]).subtract(a[i-k]);
	  }
	  out.print(a[n].add(b[n]));	  
  }

  in.close(); out.close();
}

}


