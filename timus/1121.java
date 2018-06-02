import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;
int n,m,x,y;
int[][] r,a;
int[] rr;

public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

void w(int i, int j, int k) {
	if (i<1 || j<1 || i>n || j>m) return;
	rr[k] = rr[k] | a[i][j];	
	k++;
	if (k==6) return;
	w(i+1,j,k);
	w(i-1,j,k);
	w(i,j+1,k);
	w(i,j-1,k);
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  n = nextInt();
  m = nextInt();
  a = new int[n+1][m+1];
  r = new int[n+1][m+1];
  for (int i=1; i<=n; i++)
	  for (int j=1; j<=m; j++)
		  a[i][j] = nextInt();
  for (x=1; x<=n; x++)
	  for (y=1; y<=m; y++) {		
		  if (a[x][y]>0) r[x][y] = -1; else {
			  rr = new int[6]; w(x,y,0);
			  int i = 1;
			  while (i<6 && rr[i]==0) i++;
			  if (i==6) r[x][y] = 0; else r[x][y] = rr[i];			  
		  }
		  
	  }
  for (int i=1; i<=n; i++) {	  
	  for (int j=1; j<=m; j++)
		  out.print(r[i][j]+" ");
	  out.println();
  }
	
  
  out.close();
}

}

