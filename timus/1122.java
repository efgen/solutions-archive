import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}

int f(boolean[][] h) {
	int res = 0;
	for (int i=0; i<4; i++)
		for (int j=0; j<4; j++) {
			res <<= 1;
			if (h[i][j]) res++;
		}
	return res;			
}
boolean[][] F(int x) {
	boolean[][] a = new boolean[4][4];
	for (int i=3; i>=0; i--)
		for (int j=3; j>=0; j--) {
			a[i][j] = (x%2==1);
			x >>= 1;
		}			
	return a;
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);  
  boolean[][] a = new boolean[4][4];
  boolean[][] b = new boolean[4][4];
  boolean[][] msk = new boolean[3][3];
  for (int i=0; i<4; i++) {
	  String s = in.nextLine();
	  for (int j=0; j<4; j++)
		  a[i][j] = s.charAt(j)=='B';
  }
  for (int i=0; i<3; i++) {
	  String s = in.nextLine();
	  for (int j=0; j<3; j++)
		  msk[i][j] = s.charAt(j)=='1';
  }
  int[] q = new int[1<<16]; 
  int[] d = new int[1<<16]; Arrays.fill(d, -1);
  int s = 0, t = 0; q[0] = f(a); d[q[0]] = 0;
  while (s<=t) {
	  int x = q[s++];
	  a = F(x);
	  for (int i=0; i<4; i++)
		  for (int j=0; j<4; j++) {			
			  for (int n=0; n<4; n++)
				  for (int m = 0; m<4; m++)
					  b[n][m] = a[n][m];			
			  for (int ii=0; ii<3; ii++)
				  for (int jj=0; jj<3; jj++)
					  if (msk[ii][jj])
						  if (ii+i-1>=0 && jj+j-1>=0 && ii+i-1<4 && jj+j-1<4)
							  b[i+ii-1][j+jj-1] = !b[i+ii-1][j+jj-1];
			  int v = f(b);
			  if (d[v]<0) {
				  q[++t] = v;
				  d[v] = d[x]+1;
			  }
		  }
  }  
  if (d[0]<0) d[0] = 1<<16;
  if (d[(1<<16)-1]<0) d[(1<<16)-1] = 1<<16;
  int res = Math.min(d[0], d[(1<<16)-1]);
  if (res<(1<<16)) out.print(res); else out.print("Impossible");
  
	  
	  
 
  in.close(); out.close();
}

}

