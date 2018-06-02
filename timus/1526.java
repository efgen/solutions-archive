import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int mod = nextInt();
  int T = nextInt()/2;
  int n = nextInt();
  int sz = 1<<n;
  int m = nextInt();
  int[][] a = new int[sz][T+1]; 
  int[] den = new int[sz];  
  while (m-->0) {
	  int x = 1<<(nextInt()-1);
	  int y = 1<<(nextInt()-1);
	  for (int msk=0; msk<sz; msk++)
		  if ((msk&x)>0) den[msk] |= y;
  }
  
  for (int msk=0; msk<sz; msk++) a[msk][0] = 1;
	
  for (int k=1; k<=T; k++)
	  for (int msk=0; msk<sz; msk++)  {
		  int bb = 1;
		  int z = den[msk];
		  for (int b=0; b<n; b++, bb<<=1) 
			  if((z&bb)==0) {
				  int msk2 = msk|bb;
				  for (int t=1; t<=k; t++) 
					  a[msk][k] += (a[msk2][t-1]*a[msk][k-t])%mod;
				  a[msk][k] %= mod;
			  }		  		  
	  }
  out.print(a[0][T]);
  out.close();    
}   

}




