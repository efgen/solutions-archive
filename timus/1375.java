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
  long k = in.nextLong(); 
  int p = in.nextInt();
  long P = (long) p;
  int[] a = new int[p];
  Arrays.fill(a, -1);
  for (int i=0; i<p; i++) {
	  long x = (long) i;
	  x = (x*x) % (long)p;
	  a[(int)(x)] = i;
  }
  for (int i=0; i<p; i++) {
	  long x = (long) i;
	  long y = (P*P+k-x*x) % P;
	  if (a[(int)y]<0) continue;
	  out.print(x+" "+a[(int)y]);
	  in.close(); out.close();
	  return;
  }
  out.print("NO SOLUTION");
  in.close(); out.close();
}

}


