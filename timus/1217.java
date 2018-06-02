import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;   
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}   
  
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}


public void run() throws IOException {   
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int n = nextInt()/2;
  long[][][] a = new long[n+1][9*n+1][200];
  int z = 100;
  for (int i=0; i<10; i++) a[1][i][i+z] = 1;
  int zz = 1;
  for (int i=2; i<=n; i++) {
	  zz *= -1;
	  for (int s=0; s<=9*(i-1); s++)
		  for (int r=-9*(i/2); r<=9*(i/2); r++)
			  for (int c=0; c<10; c++)				
					  a[i][s+c][r+z+c*zz] += a[i-1][s][r+z];
  }
  long res = 0;
  for (int i=0; i<=9*n; i++)
	  for (int j=0; j<200; j++)
		  res += a[n][i][j]*a[n][i][j];
  out.print(res);
  out.close();    
}   
  
} 