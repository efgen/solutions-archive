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
  int L = in.nextInt();
  int M = in.nextInt();
  int K = in.nextInt();
  BigInteger[][] d = new BigInteger[L+1][K];
  for (int i=0; i<=L; i++)
	  for (int j=0; j<K; j++)
		  d[i][j] = BigInteger.ZERO;
  for (int x=1; x<=M; x++)
	  d[1][x%K] = d[1][x%K].add(BigInteger.ONE);
  for (int n=2; n<=L; n++)
	  for (int k=0; k<K; k++)
		  for (int x=1; x<=M; x++)
			  d[n][k] = d[n][k].add(d[n-1][(K+k-x%K)%K]);
  
  d[0][0] = BigInteger.ONE;
  
  int[] a = new int[L+1];
  BigInteger req = in.nextBigInteger();
  int n = L;
  int k = 0;
  for (int i=1; i<=L; i++) {
	  n--;
	  for (int x=1; x<=M; x++) {
		  BigInteger t = d[n][(K+k-x%K)%K];
		  if (t.compareTo(req)<=0) req = req.subtract(t); else {
			  a[i] = x;
			  k = (K+k-x%K)%K;
			  break;
		  }
	  }
  }
  for (int i=1; i<=L; i++) out.print(a[i]+" ");
  in.close(); out.close();  
}
}
