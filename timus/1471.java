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
class Rib {
	int x,w;
	Rib(int x, int w) {
		this.x = x;
		this.w = w;
	}
}

int n=0,k=0,time=0;
int[][] a;
Vector<Rib>[] rib;
int[] d,dist,uk;

void dfs(int v) {
	d[v] = ++time;
	a[0][++k] = v; uk[v] = k;
	for (Rib r:rib[v])
		if (d[r.x]==0) {
			dist[r.x] = dist[v] + r.w;
			dfs(r.x);
			a[0][++k] = v;
		}
}

int min(int u,int v) {
	if (d[u]<d[v]) return u; else return v;
}
void init() {
	int d = 1;
	int k = 1;
	int N = 2*n-1;
	while (N>d) {
		for (int i=N-2*d+1; i>0; i--) 
			a[k][i] = min(a[k-1][i],a[k-1][i+d]);
		k++;
		d *= 2;
	}
}

int rmq(int l, int r) {
	int d = r-l+1;
	int k = 0;
	while ((d>>k)>0) k++; k--;
	return min(a[k][l],a[k][r-(1<<k)+1]);
}

int lca(int u,int v) {
	u = uk[u]; v = uk[v];
	if (u<v) return rmq(u,v);
		else return rmq(v,u);
}

public void run() {
  try{
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out); 
  n = nextInt();
  rib = new Vector[n];
  for (int i=0; i<n; i++) rib[i] = new Vector<Rib>();
  for (int i=1; i<n; i++) {
	  int u = nextInt();
	  int v = nextInt();
	  int w = nextInt();
	  rib[u].add(new Rib(v,w));
	  rib[v].add(new Rib(u,w));	  
  }
  d = new int[n];
  dist = new int[n];
  uk = new int[n];
  a = new int[21][2*n];
  dfs(0);
  init();
  int Q = nextInt();
  while (Q-->0) {
	  int u = nextInt();
	  int v = nextInt();
	  out.println(dist[u]+dist[v]-2*dist[lca(u,v)]);
  }  
 // for (int i=1; i<2*n; i++) out.print(1+a[0][i]+" ");
  out.close();
  }
  catch (IOException e)  {
     throw new IllegalStateException(e);
  }
}

}


