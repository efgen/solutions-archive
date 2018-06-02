import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
long[][] a = new long[21][21];

public static void main(String[] args) throws IOException {
new Main().run();
}
long solv(int n, int m) {
	if (m==0) return 1;
	if (n==0) return 0;
	if (a[n][m]>0) return a[n][m];
	long res = 0;
	for (int i=0; i<=m; i++)
		res += solv(n-1,m-i);
	a[n][m] = res;
	return res;
}
long comp(int n, int m) {
	long res = 0;
	for (int i=0; i<=m; i++) {	
		for (int j=0; j<=20; j++)
			for (int k=0; k<=20; k++)
				a[j][k] = -1;
		res += solv(n,i);
	}
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int m1 = in.nextInt();
  int m2 = in.nextInt();
  BigInteger res = BigInteger.valueOf(comp(n,m1)).multiply(BigInteger.valueOf(comp(n,m2)));
  out.print(res);  
  in.close(); out.close();
}

}