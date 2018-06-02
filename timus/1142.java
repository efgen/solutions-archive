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

long C(int k, int n) {
	int res = 1;
	for (int i=1; i<=n; i++) res *= i;
	for (int i=1; i<=k; i++) res /= i;
	for (int i=1; i<=n-k; i++) res /= i;
	return res;	
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  long[] a = new long[15]; a[0] = 1;
  for (int n=1; n<=10; n++) 
	  for (int k=1; k<=n; k++)
		  a[n] += C(k,n)*a[n-k];
  while (true) {
	  int x = nextInt();
	  if (x<0) break;
	  out.println(a[x]);
  }
  out.close();
}

}


