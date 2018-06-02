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
  BigInteger x = BigInteger.valueOf(36);
  int n = in.nextInt();
  for (int k=2; k<=n; k++, x = x.multiply(BigInteger.valueOf(55)));
  out.print(x);  
  in.close(); out.close();
}

}
