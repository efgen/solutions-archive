import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  int n = (int) nextD();
  double[] x = new double[n+1];
  double[] y = new double[n+1];
  double[] maxr = new double[n+1];
  for (int i=1; i<=n; i++) {
	  x[i] = nextD();
	  y[i] = nextD();
  }
  double[][] a = new double[n+1][n+1];
  for (int i=1; i<=n; i++)
	  for (int j=i+1; j<=n; j++) {
		  a[i][j] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
		  a[j][i] = a[i][j];
	  }
  for (int i=1; i<=n; i++) {
	  double m = 50;
	  for (int j=1; j<=n; j++)
		  if (i!=j && a[i][j]<m) 
			  m = a[i][j];
	  maxr[i] = m;
  }
  double r1,r2;
  double best = 0, s = 0;
  for (int i=1; i<=n; i++)	
		  for (int j=1; j<=n; j++) { 			
				  r1 = Math.min(maxr[i], a[i][j]-1);
				  r2 = Math.min(maxr[j], a[i][j]-r1);
				  if (r1>=1 && r2>=1) best = Math.max(best, r1*r1+r2*r2);				
			  }
  best = Math.PI*best;
  out.printf(Locale.US,"%1.4f",best);
  out.close();
}

}


