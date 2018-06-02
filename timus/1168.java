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

public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int m = in.nextInt();
  int K = in.nextInt();
  int[][] a = new int[n+1][m+1];
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=m; j++)
		  a[i][j] = in.nextInt();
  int[] x = new int[K];
  int[] y = new int[K];
  double[] r = new double[K];
  for (int i=0; i<K; i++) {
	  x[i] = in.nextInt();
	  y[i] = in.nextInt();
	  r[i] = in.nextDouble(); r[i] *= r[i];
  }
  long res = 0;
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=m; j++) {
		  boolean f = true;
		  int A = a[i][j];
		  int B = inf;
		  for (int k=0; k<K; k++) {
			  double d = (i-x[k])*(i-x[k])+(j-y[k])*(j-y[k]);
			  if (d<1e-10 || d>r[k]) { f = false; break; }
			  int H = (int)Math.floor(Math.sqrt(r[k]-d));
			  int low = a[x[k]][y[k]]-H;
			  int high = a[x[k]][y[k]]+H;			   
			  A = Math.max(A, low);
			  B = Math.min(B, high);
			  if (A>B) { f = false; break;}		  
		  }
		  if (f)  {res += B-A+1;
		  	//out.println(i+" "+j+" "+A+" "+B);
		  }
	  }
  out.print(res);  
  in.close(); out.close();
}
}


