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
  int res = 1000000000;
  int n = in.nextInt();
  int[] a = new int[n];
  for (int i=0; i<n; i++) a[i] = in.nextInt();
  boolean[] f = new boolean[n];
  while (true) {
	  int i = 0;
	  for (i=0; i<n && f[i]; i++) f[i] = false;
	  if (i==n) break;
	  f[i] = true;
	  int d = 0;
	  for (int j=0; j<n; j++)
		  if (f[j]) d += a[j]; else d -=a[j];
	  if (d<0) d = -d;
	  if (d<res) res = d;
  }
  out.print(res);
  in.close(); out.close();
}

}


