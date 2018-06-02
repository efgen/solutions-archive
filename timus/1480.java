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
  int[][] a = new int[n+2][n+2];
  int k = 1, K = n*n;
  for (int d=2; d<=2*n; d++)
	  for (int i=1; i<=n; i++) {
		  int j = d - i;
		  if (j<=0 || j>n) continue;
		  if (d%2==0) a[i][j] = K--; else a[i][j] = k++; 
	  }
  int r = 0;
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=n; j++) {		 
		  if (a[i][j]+a[i-1][j]>r) r = a[i][j]+a[i-1][j];
		  if (a[i][j]+a[i+1][j]>r) r = a[i][j]+a[i+1][j];
		  if (a[i][j]+a[i][j-1]>r) r = a[i][j]+a[i][j-1];
		  if (a[i][j]+a[i][j+1]>r) r = a[i][j]+a[i][j+1];
	  }
  out.println(r);
		 
  for (int i=1; i<=n; i++) {
	  for (int j=1; j<=n; j++)
		  out.print(a[i][j]+" ");
	  out.println();
  }
  in.close(); out.close();  
}
}



