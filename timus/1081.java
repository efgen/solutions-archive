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
  long[] a = new long[50]; a[0] = 1; a[1] = 1;  
  for (int i=2; i<49; i++) a[i] = a[i-1]+a[i-2]; a[0] = 0;
  int n = in.nextInt(), k = in.nextInt()-1;
  boolean[] r = new boolean[50];
  int p = 0;
  while (k>=a[p+1]) p++;
  while (k>0) {
	  r[p] = true;
	  k -= a[p];
	  while (k<a[p]) p--;
  }
  boolean f = true;
  for (p=49; p>0; p--) 
	  if (r[p]) {
		  if (p>n) f = false;
		  break;
	  }
  if (f) for (int i=n; i>0; i--) if (r[i]) out.print(1); else out.print(0); else out.print(-1);
  in.close();  out.close();
}

}


