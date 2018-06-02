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
  int sz = 1<<n;
  int m = sz-1;
  int m1 = m-sz/2-3;
  int m2 = m-sz/2-sz/4-1;
  int[] d = new int[n];
  int[] a = new int[sz];
  int[] u = new int[sz];
  Arrays.fill(a, inf); a[0] = 0;
  for (int i=0; i<n; i++) d[i] = in.nextInt();
  for (int msk=1; msk<sz; msk++) 
	  for (int i=0; i<n; i++) 
		  if (((msk>>i)&1)>0) u[msk] += d[i];
  
  for (int msk=1; msk<sz; msk++) {
	  a[msk] = Math.min(a[msk],a[msk&m1]+u[msk&m1]);
	  a[msk] = Math.min(a[msk],a[msk&m2]+u[msk&m2]);	    
	  int x = 7;
	  for (int i=0; i<n-2; i++) {
		  int mm = msk&(m^x);
		  a[msk] = Math.min(a[msk], a[mm]+u[mm]);
		  x <<= 1;
	  }	  
  }
  out.print(a[m]); 
  in.close(); out.close();  
}
}


