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
  int n = in.nextInt();
  BigInteger res = BigInteger.ZERO;
  BigInteger f = BigInteger.valueOf(n);
  for (int k=n-1; k>0; k--) {
	  f = f.multiply(BigInteger.valueOf(k));
	  res = res.add(f);  
  }
  out.print(res);
  in.close();  out.close();
}

}