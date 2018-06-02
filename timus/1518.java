import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
int n,y;

public static void main(String[] args) throws IOException {
new Main().run();
}

int[][] mult(int[][]a, int[][]b) {
	int[][] res = new int[n][n];
	for (int i=0; i<n; i++)	
		for (int j=0; j<n; j++) {
			long t = 0;
			for (int k=0; k<n; k++) t += (long)a[i][k]*(long)b[k][j];				
			res[i][j] =(int)(t%y);
		}
	return res;	
}
int[][] pow(int[][] x, int p) {
	int[][] res = new int[n][n]; 
	for (int i=0; i<n; i++) res[i][i] = 1;
	int[][] a = new int[n][n];
	for (int i=0; i<n; i++) 
		for (int j=0; j<n; j++)
			a[i][j] = x[i][j];
	while (p>0) {
		if (p%2>0) res = mult(res,a);		
		a = mult(a,a);
		p /= 2;
	}
	return res;
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US); 
  out = new PrintWriter(System.out);
  n = in.nextInt();
  int x = in.nextInt();
  y = in.nextInt();
  int[][] v = new int[n][n];
  for (int i=0; i<n; i++) v[0][i] = in.nextInt();
  int[][] a = new int[n][n];
  for (int i=0; i<n; i++)   a[i][n-1] = in.nextInt();
  for (int i=0; i<n-1; i++)  a[i+1][i] = 1;
  int[][] res = mult(v,pow(a,x-1));
  out.print(res[0][0]);
  in.close();  out.close();
}

}


