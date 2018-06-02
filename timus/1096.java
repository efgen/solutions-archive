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
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
  int[] a = new int[n+2];
  int[] b = new int[n+2];
  int[] d = new int[n+2];
  int[] p = new int[n+2];
  Arrays.fill(d, -1);
  for (int i=1; i<=n; i++) {
	  a[i] = in.nextInt();
	  b[i] = in.nextInt();	  
  }
  int need = in.nextInt();
  a[n+1] = in.nextInt();
  b[n+1] = in.nextInt();
  int[] Q = new int[n+2];
  int s = 0, t = 0; Q[0] = n+1; d[n+1] = 0;
  int res = -1;
  while (s<=t) {
	  int v = Q[s++];
	  int x = a[v];
	  int y = b[v];
	  if (x==need || y==need) {
		  res = v;
		  break;
	  }
	  for (int i=1; i<=n; i++)
		  if (d[i]==-1) {
			  if (x==a[i] || y==a[i]) {				 
				  Q[++t] = i;
				  d[i] = d[v]+1;
				  p[i] = v;
			  } 			 
		  }	  
  }
  if (res<0) out.print("IMPOSSIBLE"); else {
	  out.println(d[res]);
	  Stack<Integer> st = new Stack<Integer>();
	  while (res<=n) {
		  st.push(res);
		  res = p[res];
	  }
	  while (st.size()>0) out.println(st.pop());
  }
  
  in.close(); out.close();
}

}

