import java.io.*;
import java.util.*;
import java.math.*;


public class Main implements Runnable{	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {	
	new Thread(new Main()).start();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

class Arc {
	int x,v;
	Arc(int x, int v) { this.x = x; this.v = v; }
}

int n;
Vector<Arc>[] a;
boolean[] f;
long[] p,d;
int[] c;

void dfs(int v) {
	f[v] = true;
	for (Arc r:a[v]) 
		if (!f[r.x]) {	
			d[r.x] = d[v]+r.v;
			dfs(r.x);			
			c[v] += 1+c[r.x];
			p[v] -= 1L*c[r.x]*(c[r.x]+1);
		}
	p[v] += 1L*c[v]*(c[v]+1);	
}
public void run() {
  try{
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out); 
  n = nextInt();
  if (n==1) {
	  out.print("0.0000");
	  out.close();
	  return;
  }
  a = new Vector[n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector();
  for (int i=1; i<n; i++) {
	  int x = nextInt();
	  int y = nextInt();
	  int v = nextInt();
	  a[x].add(new Arc(y,v));
	  a[y].add(new Arc(x,v));
  }
  
  f = new boolean[n+1];
  c = new int[n+1];
  p = new long[n+1];
  d = new long[n+1];
  
  dfs(1);
  
  double res = 0;
  for (int i=1; i<=n; i++) res += (n-p[i]-1)*d[i]; 
  res /= (double)(n)*(n-1)/2.0;
  out.printf(Locale.US,"%1.4f",res); 
  out.close();
  }
  catch (IOException e)  {
     throw new IllegalStateException(e);
  }
}

}


