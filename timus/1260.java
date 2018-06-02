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
  long[] a = new long[n+5]; a[1] = 1; a[2] = 1; a[3] = 2;
  for (int i=4; i<=n; i++) 
	  a[i] = a[i-1] + a[i-3] + 1;
  out.print(a[n]);  
  in.close(); out.close();
}

}
