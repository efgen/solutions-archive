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
  boolean[][] f = new boolean[n+2][m+2];
  for (int i=1; i<=n; i++) {
	  f[i][0] = true;
	  f[i][m+1] = true;
  }
  for (int j=1; j<=m; j++) {
	  f[0][j] = true;
	  f[n+1][j] = true;
  }
  int sx = in.nextInt();
  int sy = in.nextInt();
  int[] x = new int[n*m];
  int[] y = new int[n*m];
  int p = 0;
  x[0] = 1; y[0] = 1; f[1][1] = true;
  int np = 0;
  int[] dx = {0,1,0,-1};
  int[] dy = {1,0,-1,0};
  while (x[p]!=sx || y[p]!=sy) {
	  if (f[x[p]+dx[np]][y[p]+dy[np]]) np = (np+1)%4;
	  x[p+1] = x[p]+dx[np];
	  y[p+1] = y[p]+dy[np];
	  p++;
	  f[x[p]][y[p]] = true;
  }
  sx = in.nextInt();
  sy = in.nextInt();
  int pos = 0;
  while (pos<=p && (x[pos]!=sx || y[pos]!=sy)) pos++;
  int t = in.nextInt();
  int L = Math.max(0, pos-t);
  int R = Math.min(p, pos+t);
  for (int i=L; i<=R; i++)
	  out.println(x[i]+" "+y[i]);
  in.close(); out.close();  
}
}


