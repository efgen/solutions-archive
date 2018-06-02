import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int inf = 1000000000;
int n;
int[][] a;
boolean[] f;
void dfs(int v) {
	f[v] = true;
	for (int i=1; i<=n; i++)
		if (!f[i] && a[v][i]<inf) dfs(i);
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  boolean fl = false;
  n = in.nextInt();
  int m = in.nextInt();
  int S = in.nextInt();
  a = new int[n+1][n+1];
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=n; j++)
		  a[i][j] = inf;
  while (m-->0) {
	  int x = in.nextInt();
	  int y = in.nextInt();
	  int d = in.nextInt();
	  if (x==y || a[x][y]<inf) fl = true;
	  a[x][y] = d;
	  a[y][x] = d;
  } 
  f = new boolean[n+1];
  int r = -n;
  for (int i=1; i<=n; i++)
	  for (int j=i+1; j<=n; j++)
		  if (a[i][j]<inf) r++;
  for (int i=1; i<=n; i++)
	  if (!f[i]) { r++; dfs(i); }
  if (r>0 || fl) out.print("YES"); else {
	  for (int k=1; k<=n; k++)
		  for (int i=1; i<=n; i++)
			  for (int j=1; j<=n; j++)
				  a[i][j] = Math.min(a[i][j], a[i][k]+a[k][j]);
	  int max = 0;
	  for (int i=1; i<=n; i++)
		  for (int j=i+1; j<=n; j++)
			  if (a[i][j]<inf && a[i][j]>max) max = a[i][j];
	  if (max>=S) out.print("YES"); else out.print("NO");
  }
  in.close(); out.close();
}

}
