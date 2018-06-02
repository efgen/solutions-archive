import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}

int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}

int[] A;
Vector<Point>[] a;
int[] p;
long[] d,d2;
boolean[] f,f2;
class Point {
	int x,v;
	Point(int x, int v) {this.x = x; this.v = v;}
}
int nmax,res;
void dfs(int v) {
	f[v] = true;
	for (Point P:a[v])
		if (!f[P.x]) {
			d[P.x] = d[v] + P.v + A[P.x];		
			dfs(P.x);
		}	
	if (d[v]>d[nmax]) nmax = v;
}
void dfs2(int v) {
	f2[v] = true;
	for (Point P:a[v])
		if (!f2[P.x]) {
			d2[P.x] = d2[v] + P.v + A[P.x];
			p[P.x] = v;
			dfs2(P.x);
		}	
	if (d2[v]>d2[res]) res = v;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int n = nextInt();
  int k = nextInt();
  a = new Vector[n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector<Point>();
  A = new int[n+1];
  for (int i=1; i<=n; i++) A[i] = nextInt();
  while (k-->0) {
	  int x = nextInt();
	  int y = nextInt();
	  int c = nextInt();
	  a[x].add(new Point(y,c));
	  a[y].add(new Point(x,c));
  }
  f = new boolean[n+1];
  f2 = new boolean[n+1];
  d = new long[n+1];
  d2 = new long[n+1];
  p = new int[n+1];
  res = 1;
  for (int i=1; i<=n; i++)
	  if (!f[i]) {
		  nmax = i;
		  d[i] = A[i];
		  dfs(i);
		  int s = nmax;
		  d2[s] = A[s];
		  p[s] = 0;
		  dfs2(s);
	  }
  out.println(d2[res]);
  Vector<Integer> r = new Vector<Integer>();
  int v = res;
  while (v>0) {
	  r.add(v);
	  v = p[v];
  }
  out.println(r.size());
  for (int x:r) out.print(x+" ");  
  out.close(); 
 
}

}

