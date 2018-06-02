import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
int[] d;
long p = 0, res = 0;
public static void main(String[] args) throws IOException {
new Main().run();
}
boolean solve(int k, int a, int b, int c) {
	if (k==0) return true;
	p /= 2;
	if (d[k]==c) return false;
	if (d[k]==b) {
		res += p;
		return solve(k-1,c,b,a);
	} else return solve(k-1,a,c,b);
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  d = new int[n+1];
  for (int i=1; i<=n; i++) d[i] = in.nextInt();
  p = 1L << n;
  if (solve(n,1,2,3)) out.print(res); else out.print(-1);  
  in.close(); out.close();
}

}


