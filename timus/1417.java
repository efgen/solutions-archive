import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}   
double nextInt() throws IOException {
	in.nextToken();
	return in.nval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = (int) nextInt();
  double[][] a = new double[n][n+1];
  for (int i=0; i<n; i++)
	  for (int j=0; j<n; j++)
		  a[i][j] = nextInt();
  for (int i=0; i<n; i++) a[i][n] = 1;
  
  for (int i=0; i<n; i++) {
	  double x = a[i][i];
	  for (int j=i; j<=n; j++) a[i][j] /= x;
	  for (int k=i+1; k<n; k++) {
		  x = a[k][i];
		  for (int j=i; j<=n; j++) a[k][j] -= a[i][j]*x;
	  }
  }
  
  double[] y = new double[n];
  for (int i=n-1; i>=0; i--) {
	  y[i] = a[i][n];
	  for (int k=i+1; k<n; k++) y[i] -= a[i][k]*y[k];
  }
  
  double v = 0;
  for (double x:y) v += x;
  v = 1/v;
  for (int i=0; i<n; i++) y[i] *= v;
  for (int i=0; i<n; i++) out.printf(Locale.US,"%1.8f\n",y[i]);
  out.close();    
}   
  
}




