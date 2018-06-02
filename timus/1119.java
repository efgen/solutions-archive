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
  int m = in.nextInt(), n = in.nextInt();
  boolean[][] a = new boolean[n+1][m+1];
  double[] dt = new double[m+1], dp = new double[m+1];
  int k = in.nextInt();
  while (k-->0) {
	  int y = in.nextInt();
	  int x = in.nextInt();
	  a[x][y] = true;
  }
  double s1 = 100.0;
  double s2 = Math.sqrt(2)*s1;
  for (int i=1; i<=m; i++) dt[i] = i*s1;
  for (int i=1; i<=n; i++) {
	  for (int j=0; j<=m; j++) dp[j] = dt[j]; dt[0] += s1;	 
	  for (int j=1; j<=m; j++) {
		  dt[j] = Math.min(dp[j], dt[j-1])+s1;
		  if (a[i][j])
			  dt[j] = Math.min(dt[j], dp[j-1]+s2);
	  }
  }
  out.print(Math.round(dt[m]));
  in.close();  out.close();
}

}


