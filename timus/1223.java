import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}


public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int[][] a = new int[1001][1001];
  int nn = 1000;
  for (int h=1; h<=nn; h++) a[h][1] = h;
  for (int k=1; k<=nn; k++) a[1][k] = 1;
//  out.println("!!!!"); out.flush();
  for (int h=2; h<=nn; h++) {
	  for (int k=2; k<=h; k++) {
		/*  a[h][k] = h;
		  for (int i=1; i<=h; i++)
			  a[h][k] = Math.min(a[h][k], 1+Math.max(a[i-1][k-1], a[h-i][k]));*/
		/*  int i = 1;
		  while (a[i-1][k-1]<a[h-i][k]) i++;
		  a[h][k] = 1+Math.min(a[i-1][k-1],a[h-i+1][k]);	*/  		  
		  int l = 1, r = h;
		  while (r-l>1) {
			  int x = (l+r)/2;
			  if (a[x-1][k-1]<a[h-x][k]) l = x; else r = x;
		  }		  
		  int x = (l+r+1)/2;
		  a[h][k] = 1+Math.min(a[x-1][k-1], a[h-x+1][k]);		
		  
	  }
	  for (int k=h+1; k<=nn; k++) a[h][k] = a[h][h];
  }
//  out.println("........."); out.flush();
  
  
  while (true) {
	  int k = nextInt();
	  if (k==0) break;
	  int h = nextInt();
	  out.println(a[h][k]);
  }
 
  out.close();
}

}


