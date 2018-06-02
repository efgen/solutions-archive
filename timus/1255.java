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
  int n = in.nextInt();
  int k = in.nextInt();
  int res = 0;
  if (k<=n) {
	  res = n/k*(n+n%k);
	  int m = n%k;
	  int[] a = new int[k];
	  for (int i=0; i<m; i++)
		  for (int j=0; j<m; j++)
			  a[(i+j)%k]++;
	  int min = inf;
	  for (int x:a) min = Math.min(min, x);
	  res += min;
  }
  out.print(res);
  in.close(); out.close();  
}
}


