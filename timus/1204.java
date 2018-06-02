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
	  int n = in.nextInt();
	  int p = 2;
	  while (n%p>0) p++;
	  int q = n/p;
	  int x1 = p*BigInteger.valueOf(p).modInverse(BigInteger.valueOf(q)).intValue();
	  int x2 = q*BigInteger.valueOf(q).modInverse(BigInteger.valueOf(p)).intValue();
	  if (x2<x1) {int t = x1; x1 = x2; x2 = t;}
	  out.println("0 1 "+x1+" "+x2);	 
  }
  in.close();  out.close();
}

}
