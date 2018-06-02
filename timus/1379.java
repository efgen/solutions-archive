import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
StreamTokenizer in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}

int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int n = nextInt();
  int m = nextInt();
  int[][] a = new int[n+1][n+1];
  int[][] u = new int[n+1][n+1];
  while (m-->0) {
	  int x = nextInt();
	  int y = nextInt();
	  a[x][y] = nextInt();
	  u[x][y] = nextInt();
	  a[y][x] = a[x][y];
	  u[y][x] = u[x][y];
  }
  int inf = 1000000000;
  int l = 0, r = 10000000;
  while (l<r) {
	  int x = (l+r+1)/2;
	  int ves = 3000000+100*x;
	  int p = 1;
	  int[] d = new int[n+1]; Arrays.fill(d, inf); d[1] = 0;
	  boolean[] f = new boolean[n+1];
	  while (p!=n && p>0) {
		  f[p] = true;
		  for (int i=1; i<=n; i++)
			  if (!f[i] && ves<=u[p][i])
				  d[i] = Math.min(d[i], d[p]+a[p][i]);
		  p = 0;
		  for (int i=1; i<=n; i++)
			  if (!f[i] && d[i]<d[p]) p = i;		  
	  }
	  if (d[p]<=1440) l = x; else r = x-1;
  }
  out.print(l);  
  out.close(); 
}

}

