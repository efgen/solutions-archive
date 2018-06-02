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
  int[][] a = new int[n+1][n+1];
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=n; j++)
		  a[i][j] = in.nextInt();
  for (int i=1; i<=n; i++) {
	  int s = 0;
	  for (int j=1; j<=n; j++) {
		  s += a[i][j];
		  a[i][j] = a[i-1][j]+s;
	  }
  }
  int res = a[n][n]; 
  for (int i=0; i<n; i++)
	  for (int j=0; j<n; j++)
		  for (int x=i+1; x<=n; x++)
			  for (int y=j+1; y<=n; y++) {
				  int s = a[x][y]+a[i][j]-a[x][j]-a[i][y];
				  if (s>res) res = s;				 
			  }
				  
  out.print(res);
  in.close();  out.close();
}

}


