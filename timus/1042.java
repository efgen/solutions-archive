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
  int n = in.nextInt();
  int m = n+1;
  boolean[][] a = new boolean[n+1][n+2];
  for (int i=1; i<=n; i++) {
	  while (true) {
		  int x = in.nextInt();
		  if (x<0) break;
		  a[x][i] = true;
	  }
  } 
  for (int i=1; i<=n; i++) a[i][m] = true;
  int[] var = new int[n+1];
  for (int i=1; i<=n; i++) var[i] = i;
  
  int start = n;
  for (int i=1; i<=n; i++) {
	  boolean f = false;
	  int ii = i, jj = i;
	  for (ii=i; ii<=n; ii++) {		  
			 for (jj=i; !f && jj<=n; jj++)
				 if (a[ii][jj]) {
					 f = true;
					 break;
				 }
			 if (f) break;
	  }
	  if (f) {
		  int Q = var[i]; var[i] = var[jj]; var[jj] = Q;
		  boolean q = true;
		  for (int k=1; k<=n; k++) {
			  q = a[k][i]; a[k][i] = a[k][jj]; a[k][jj] = q;
		  }
		  for (int k=i; k<=m; k++) {
			  q = a[i][k]; a[i][k] = a[ii][k]; a[ii][k] = q;
		  }		  
	  } else {		
		  for (int k=i; k<=n; k++)
			  if (a[k][m]) f = true;
		  //The End.
		  if (f) {
			  out.print("No solution.");
			  out.close();
			  return;
		  } else {
			  start = i;
			  break;
		  }
	  }
	  for (ii = i+1; ii<=n; ii++) {
		  if (a[ii][i])
			  for (jj=i; jj<=m; jj++)
				  a[ii][jj] ^= a[i][jj];	
	  }
  }
  boolean[] x = new boolean[n+1];
  for (int i=start; i>0; i--) {
	  x[var[i]] = a[i][m];
	  for (int k=1; k<i; k++)
		  if (a[k][i]) a[k][m] ^= a[i][m];	 
  }

  for (int i=1; i<=n; i++) 
	  if (x[i]) out.print(i+" "); 
 
  in.close(); out.close();
}
}


