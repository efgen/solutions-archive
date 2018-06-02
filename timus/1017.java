import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
long[][] a;
public static void main(String[] args) throws IOException {
new Main().run();
}

long R(int k, int n) {
	if (a[n][k]>=0) return a[n][k];
	a[n][k] = 0;
	if (k>=n-k) return 0;
	a[n][k]++;
	for (int i=k+1; i<=n-k; i++)
		a[n][k] += R(i,n-k);
	return a[n][k];
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  a = new long[n+1][n+1];
  for (int i=0; i<=n; i++)
	  for (int j=0; j<=n; j++)
		  a[i][j] = -1;
  long res = 0;
  for (int i=1; i<=n; i++)
	  res += R(i,n);
  out.print(res); 
  in.close(); out.close();
}

}


