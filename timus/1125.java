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
  int m = in.nextInt();
  in.nextLine();
  boolean[][] a = new boolean[n+1][m+1];
  boolean[] kv = new boolean[5001];
  for (int x = 5000; x>0; x--) { 
	  int t = (int) Math.sqrt(x);
	  kv[x] = (t*t==x);
  }
  
  for (int i=1; i<=n; i++) {
	  String s = in.nextLine();
	  for (int j=0; j<m; j++)
		  a[i][j+1] = (s.charAt(j)=='B');
  }
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=m; j++) {
		  int r = in.nextInt();
		  if (r%2==1) {
			  for (int x=1; x<=n; x++)
				  for (int y=1; y<=m; y++)
					  if (i==x || j==y || kv[(x-i)*(x-i)+(y-j)*(y-j)]) 
						  a[x][y] = !a[x][y];
		  }
	  }
  for (int i = 1; i<=n; i++) {
	  for (int j = 1; j <= m; j++)
		  if (a[i][j]) out.print("B"); else out.print("W");
	  out.println();
  }  
 
  in.close(); out.close();
}

}
