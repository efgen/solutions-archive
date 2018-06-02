import java.awt.Point;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}

double sq(double x) { return x*x; }

public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);  
  int n = in.nextInt();
  int[] x = new int[n];
  int[] y = new int[n];
  double res = 0;  
  for (int i=0; i<n; i++) {
	  x[i] = in.nextInt();
	  y[i] = in.nextInt();	  
  }
    for (int i=0; i<n; i++)
	  for (int j=i+1; j<n; j++) {
		  long a = y[j]-y[i];
		  long b = x[i]-x[j];
		  long c = a*x[i]+b*y[i];
		  boolean f = true;
		  for (int k=0; k<n; k++) 
			  if (a*x[k]+b*y[k]==c) {
				  int p1 = (x[k]-x[i])*(x[j]-x[i])+(y[k]-y[i])*(y[j]-y[i]);
				  int p2 = (x[k]-x[j])*(x[i]-x[j])+(y[k]-y[j])*(y[i]-y[j]);
				  if (p1<0 && p2<0) { f = false; break;}
				  if (p1>0 && p2>0) { f = false; break;}
			  }
		  if (f) res += Math.sqrt(sq(x[i]-x[j])+sq(y[i]-y[j]));
	  }
  out.printf(Locale.US, "%1.0f",res);
  in.close(); out.close();  
}
}
