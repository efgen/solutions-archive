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
  int w = in.nextInt();
  int n = in.nextInt();
  int[] p = new int[w+1];
  boolean[] a = new boolean[w+1]; a[0] = true; 
  boolean[] f = new boolean[w+1]; 
  int[] card = new int[n+1];
  for (int i=1; i<=n; i++) {
	  int x = in.nextInt();
	  card[i] = x;
	  for (int v=w; v>=x; v--)
		  if (a[v-x]) {
			  a[v] = true;
			  if (f[v-x] || p[v]>0) f[v] = true;
			  if (p[v]==0) p[v] = i;			
		  }	  
  }
 /* for (int i=0; i<=w; i++)
	  out.println(i+" "+p[i]);*/
  
  if (a[w] && !f[w]) {
	  boolean[] g = new boolean[n+1];
	  while (w>0) {	
		  g[p[w]] = true;
		  w -= card[p[w]];
	  }	  
	  for (int i=1; i<=n; i++) 
		  if (!g[i]) out.print(i+" ");
  } else 
	  if (a[w]) out.print(-1); else out.print(0);
  in.close(); out.close();
}

}

