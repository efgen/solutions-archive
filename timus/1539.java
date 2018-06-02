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
  int d = in.nextInt();
  int n = in.nextInt();

  long D = 10L;
  while (d-->0) D *= 10;
  long[] a = new long[n];
 
  for (int i=0; i<n; i++) 
	  a[i] = Math.round(in.nextDouble()*D);	  
 
  for (int k=1; k<=100000; k++) {
	  boolean f = true;
	  for (int i=0; f && i<n; i++) { 
		  long A = (a[i]-5)*k;
		  long B = (a[i]+5)*k;
		  if (B%D==0) B--;
		  if (A>B/D*D) f = false;		 
	  }
	  if (f) {
		  out.print(k);
		  break;
	  }
  }

  in.close(); out.close();
}
}


