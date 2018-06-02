import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
double[] x,y;
int[][] p;

public static void main(String[] args) throws IOException {
new Main().run();
}
double dist(int i, int j) {
	return Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
}
String way(int i, int j) {
	if (p[i][j]<0) return (" "+String.valueOf(j)); else return way(i,p[i][j])+way(p[i][j],j);
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);  
  out = new PrintWriter(System.out);
  double v1 = in.nextDouble(), v2 = in.nextDouble();
  int n = in.nextInt()+1;
  x = new double[n+1];
  y = new double[n+1];
  for (int i=1; i<n; i++) {
	  x[i] = in.nextDouble();
	  y[i] = in.nextDouble();
  }
  double[][] a = new double[n+1][n+1];
  double[][] d = new double[n+1][n+1];
  p = new int[n+1][n+1];
  for (int i=0; i<=n; i++)
	  for (int j=0; j<=n; j++)
		  p[i][j] = -1;
  for (int i=1; i<n; i++)
	  for (int j=1; j<n; j++) {
		  d[i][j] = dist(i,j);
		  a[i][j] = d[i][j]/v1;
	  }
		  
  while (true) {
	  int vx = in.nextInt();
	  int vy = in.nextInt();
	  if (vx==0 && vy==0) break;
	  a[vx][vy] = Math.min(a[vx][vy], d[vx][vy]/v2);
	  a[vy][vx] = a[vx][vy];
  }
  x[0] = in.nextDouble();
  y[0] = in.nextDouble();
  x[n] = in.nextDouble();
  y[n] = in.nextDouble();
  for (int i=0; i<=n; i++) {
	  a[0][i] = dist(0,i)/v1;
	  a[i][0] = a[0][i];
	  a[n][i] = dist(n,i)/v1;
	  a[i][n] = a[n][i];
  }
  for (int k=0; k<=n; k++)
	  for (int i=0; i<=n; i++)
		  for (int j=0; j<=n; j++)
			  if (a[i][k]+a[k][j]<a[i][j]) {
				  a[i][j]=a[i][k]+a[k][j];
				  p[i][j] = k;
			  }
  out.printf(Locale.CHINA, "%1.7f\n", a[0][n]);
  StringTokenizer st = new StringTokenizer(way(0,n)," ");
  out.print(st.countTokens()-1); 
  while (st.countTokens()>1) out.print(" "+st.nextToken());
  in.close(); out.close();
}

}


