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
  int n =in.nextInt();
  double[] a = new double[n+2], c = new double[n+2];
  a[0] = in.nextDouble();  
  double end = in.nextDouble();
  for (int i=1; i<=n; i++) c[i] = in.nextDouble();
  double L=-2000, R = 2000;
  while (R-L>0.0001) {
	  a[1] = (L+R)/2;
	  for (int i=2; i<=n+1; i++) 
		  a[i] = 2*(a[i-1]+c[i-1])-a[i-2];
	  if (a[n+1]<end) L = a[1]; else R = a[1];  
  }
  out.printf(Locale.CHINA,"%1.2f",a[1]);

  in.close();  out.close();
}

}