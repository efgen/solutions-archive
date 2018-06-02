import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;
int n,k;
Vector[] a; 
int[] d,r;
boolean[] f;
class Point {
	int x,v;
	Point(int x, int y) {
		this.x = x;
		this.v = y;		
	}
}

public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

void dfs(int v) {
	f[v] = true;
	for (Iterator it = a[v].iterator(); it.hasNext();) {
		Point p = (Point) it.next();
		if (!f[p.x]) dfs(p.x);		
	}
	r[++k] = v;	
}


public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  n = nextInt();
  a = new Vector[n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector(); 
  d = new int[n+1]; 
  r = new int[n+1];
  k = 0;
  f = new boolean[n+1];
  int m = nextInt();
  while (m-->0) { 
	  int x = nextInt();
	  int y = nextInt();
	  int v = nextInt();
	  a[x].add(new Point(y,v));	
  }	
  int S = nextInt();
  int F = nextInt();
  d[S] = 0; dfs(S);
  while (k>0) {
	  int v = r[k]; k--;
	  for (Iterator it = a[v].iterator(); it.hasNext();) {
		Point p = (Point) it.next();
		d[p.x] = Math.max(d[p.x], d[v]+p.v);		
	}
  }
  if (d[F]>0) out.print(d[F]); else out.print("No solution");  
  out.close();
}

}


