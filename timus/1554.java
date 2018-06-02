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
  int[] F = new int[n+1];
  for (int i=1; i<=n; i++) F[i] = in.nextInt();
  int[] G = new int[n+1]; G[1] = 1;
  for (int x=2; x<=n; x++) {
	  int res = 0;
	/*  int d = 0;
	  for (d=1; d*d<x; d++) 
		  if (x%d==0)
			  res = (4014+res-F[d]*G[x/d]%2007-F[x/d]*G[d]%2007)%2007;
	  if (d*d==x) res = (2007+res-G[d]*F[d])%2007;*/
	  for (int d=2; d<=x; d++)
		  if (x%d==0)
			  res = (res+2007-F[d]*G[x/d]%2007)%2007;
	  G[x] = res;	 
  }
  for (int i=1; i<=n; i++) out.print(G[i]+" "); 
  in.close(); out.close();  
}
}



