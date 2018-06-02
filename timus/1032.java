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
	return (int) in.nval;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  int n = nextInt();
  int[] a = new int[n+1];
  int[] p = new int[n+1]; Arrays.fill(p, -1); p[0] = 0;
  int k = 0;
  for (int i=1; i<=n; i++) {
	  a[i] = nextInt();
	  k = (k+a[i]) % n;
	  if (p[k]<0) p[k] = i; else {
		  out.println(i-p[k]);
		  for (int j=p[k]+1; j<=i; j++)
			  out.println(a[j]);
		  out.close();
		  return;
	  }
  }
  out.println(0);
  out.close();
}

}

