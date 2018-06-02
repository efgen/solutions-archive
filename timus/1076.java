import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

StreamTokenizer in;
PrintWriter out;
int inf = 1000000000;
int n;
int[][] d,price;
boolean[][] a;
int[] res;
boolean[] f,x,y;

public static void main(String[] args) throws IOException {
new Main().run();
}
boolean chain(int v) {
	if (v==0) return true;
	if (f[v]) return false; else f[v] = true;
	for (int i=1; i<=n; i++)
		if (a[i][v] && chain(res[i])) {
			res[i] = v;
			return true;
		}
	return false;
}
void dfsx(int i) {
	x[i] = true;
	for (int j=1; j<=n; j++)
		if (a[i][j] && !y[j] && res[i]!=j)
			dfsy(j);	
}

void dfsy(int j) {
	y[j] = true;
	for (int i=1; i<=n; i++)
		if (a[i][j] && !x[i] && res[i]==j)
			dfsx(i);
}
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}
public void run() throws IOException {
 // in = new Scanner(System.in);
  in = new StreamTokenizer(new InputStreamReader(System.in)); 
  out = new PrintWriter(System.out);
  n = nextInt();
  d = new int[n+1][n+1];
  a = new boolean[n+1][n+1];
  price = new int[n+1][n+1];
  int[] total = new int[n+1];
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=n; j++) {  
		  price[i][j] = nextInt();
		  total[j] += price[i][j];
	  }
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=n; j++) 
		  price[i][j] = total[j] - price[i][j];
  
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=n; j++)
		  d[i][j] = price[i][j];
  
  for (int i=1; i<=n; i++) {
	  int min = inf;
	  for (int j=1; j<=n; j++)
		  min = Math.min(min, d[i][j]);
	  for (int j=1; j<=n; j++)
		  d[i][j] -= min;	  
  }
  for (int j=1; j<=n; j++) {
	  int min = inf;
	  for (int i=1; i<=n; i++)
		  min = Math.min(min, d[i][j]);
	  for (int i=1; i<=n; i++)
		  d[i][j] -= min;	  
  }
  
  while (true) {
	  for (int i=1; i<=n; i++)
		  for (int j=1; j<=n; j++)
			  a[i][j] = (d[i][j]==0);
  
	  res = new int[n+1];
	  for (int i=1; i<=n; i++) {
		  f = new boolean[n+1];
		  chain(i);
	  }
	  
	  int k = 0;
	  for (int i=1; i<=n; i++)
		  if (res[i]>0) k++;
	  if (k==n) break;
  
	  x = new boolean[n+1];
	  y = new boolean[n+1];
	  for (int i=1; i<=n; i++)
		  if (res[i]==0) dfsx(i);
  
	  int min = inf;
	  for (int i=1; i<=n; i++)
		  if (x[i])
			  for (int j=1; j<=n; j++)
				  if (!y[j])
					  min = Math.min(min, d[i][j]);
	  for (int i=1; i<=n; i++)
		  if (x[i])
			  for (int j=1; j<=n; j++)
				  d[i][j] -= min;
	  for (int j=1; j<=n; j++)
		  if (y[j]) 
			  for (int i=1; i<=n; i++)
				  d[i][j] += min;
  }	
  int r = 0;
  for (int i=1; i<=n; i++)
	  r += price[i][res[i]];
  out.println(r);
 // in.close(); out.close();
  out.close();
}

}
