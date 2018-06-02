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
	return ((int)in.nval);
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}

BigInteger[][] CC = new BigInteger[50][50];
BigInteger[][] f = new BigInteger[50][50];
BigInteger C(int n, int k) {	
	if (k>n || k<0) return BigInteger.ZERO;
	if (k==0 || k==n) return BigInteger.ONE;
	if (CC[n][k]==null)  CC[n][k] = C(n-1,k-1).add(C(n-1,k)); 
	return CC[n][k]; 
}
int N,M,K;
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  N = nextInt();
  M = nextInt();
  K = nextInt();
  for (int x=0; x<=N; x++)
	  for (int y=0; y<=N; y++) {
		  f[x][y] = BigInteger.ZERO;
		  for (int i=0; i<=K; i++)
			  f[x][y] = f[x][y].add(C(y,i).multiply(C(N-y,x-i)));
	  }
  BigInteger[] d = new BigInteger[N+1];
//  for (int i=0; i<=N; i++) d[i] = C(N,i);
  for (int i=0; i<=N; i++) d[i] = C(N,N);
  for (int len=1; len<M; len++) {
	  BigInteger[] dd = new BigInteger[N+1];
	  Arrays.fill(dd, BigInteger.ZERO);
	  for (int x=0; x<=N; x++)
		  for (int y=0; y<=N; y++)
			  dd[y] = dd[y].add(d[x].multiply(f[N-x][y]));
	  for (int i=0; i<=N; i++) d[i] = dd[i];
  }
  BigInteger res = BigInteger.ZERO;
  for (int i=0; i<=N; i++) res = res.add(d[i].multiply(C(N,i)));
  out.println(res);
  out.close();    
}   

}


