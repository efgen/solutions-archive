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
  BigInteger[][][][] a = new BigInteger[n+1][n+1][n+1][3];
  for (int i=0; i<=n; i++)
	  for (int j=0; j<=n; j++)
		  for (int k=0; k<=n; k++)
			  for (int l=0; l<3; l++)
				  a[i][j][k][l] = BigInteger.ZERO;
  a[n-1][n][n][0]  = BigInteger.ONE;
  for (int s=3*n-1; s>0; s--)
	  for (int x=0; x<=n; x++)
		  for (int y=0; y<=n; y++) {
			  int z = s-x-y;
			  if (z<0||z>n) continue;
			  for (int p=0; p<3; p++) {
				  if (p!=0 && x>0) a[x-1][y][z][0] = a[x-1][y][z][0].add(a[x][y][z][p].multiply(BigInteger.valueOf(x))); 
				  if (p!=1 && y>0) a[x][y-1][z][1] = a[x][y-1][z][1].add(a[x][y][z][p].multiply(BigInteger.valueOf(y))); 
				  if (p!=2 && z>0) a[x][y][z-1][2] = a[x][y][z-1][2].add(a[x][y][z][p].multiply(BigInteger.valueOf(z))); 
			  }				  
		  }
  out.print((a[0][0][0][1]));			  
  in.close(); out.close();  
}
}
