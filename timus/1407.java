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
  String res = "2";
  for (int i=2; i<=n; i++) {
	  BigInteger a = new BigInteger(res);
	  if (a.mod(BigInteger.valueOf(2).pow(i)).equals(BigInteger.ZERO)) res = "2"+res; else res = "1"+res;
  }
  out.print(res);
  in.close(); out.close();
}

}
