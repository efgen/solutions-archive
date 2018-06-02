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
  in = new Scanner(System.in); in.useLocale(Locale.CHINA);
  out = new PrintWriter(System.out);   
  int n = in.nextInt();
  double[] a = new double[n+1];  
  a[1]  = in.nextDouble();
  double L = 0, R = a[1];
  while (R-L>0.000001) {
	  a[2] = (L+R)/2;
	  boolean f = true;
	  for (int i=3; i<=n && f; i++) {
		  a[i] = 2*a[i-1]-a[i-2]+2;
		  if (a[i]<0) f = false;
	  }
	  if (f) R = a[2]; else L = a[2];	 
  }
  out.printf(Locale.CHINA,"%1.2f", a[n]);
  out.close();
}

}

