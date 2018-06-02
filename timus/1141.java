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
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int test = in.nextInt();
  while (test-->0) {
	  int e = in.nextInt(), n = in.nextInt(), c = in.nextInt(), p = 3; 
	  while (n % p > 0) p += 2;
	  int fi = (p - 1) * (n / p - 1);
	  BigInteger d = BigInteger.valueOf(e).modInverse(BigInteger.valueOf(fi));
	  BigInteger s = BigInteger.valueOf(c).modPow(d, BigInteger.valueOf(n));
	  out.println(s);
  }

  in.close();  out.close();
}

}