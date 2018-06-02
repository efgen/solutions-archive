import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(System.in); 
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int s = in.nextInt();
  int[] a = new int[10001]; a[s] = 1;
  for (int x=s; x<=n; x++) 
	  if (a[x]>0) {
		  for (int p=1; p<=100; p++) {
			  if (x*p%100 == 0) {
				  int nx = x + x*p/100;
				  if (nx>n) break;
				  a[nx] = Math.max(a[nx], a[x]+1);
			  }
		  }
	  }
  
  int res = 1;
  for (int x=s; x<=n; x++)
	  res = Math.max(res, a[x]);
  out.println(res);
  in.close(); out.close();
}

}
