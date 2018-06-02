import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;
boolean[][] a;
boolean[] f;
int[] p,scc;
int n,k;

public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int) in.nval;
}
void dfs(int v) {
	f[v] = true;
	for (int w = 1; w <= n; w++)
		if (a[w][v] && !f[w]) dfs(w);
	p[++k] = v;	
}
void dfs2(int v) {	
	scc[v] = k;
	for (int w = 1; w <= n; w++)
		if (a[v][w]) {
			if (scc[w]==0) dfs2(w); else 
				if (scc[v]!=scc[w]) f[scc[w]] = true;	
		}
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  n = nextInt();
  a = new boolean[n+1][n+1];  
  for (int x=1; x<=n; x++) 
	  while (true) {
		  int y = nextInt();
		  if (y==0) break;
		  a[x][y] = true;		  
	  }
  
  f = new boolean[n+1];
  p = new int[n+1]; k = 0;
  for (int i=1; i<=n; i++)
	  if (!f[i]) dfs(i);
  
  Arrays.fill(f, false); k = 0;
  scc = new int[n+1];  
  for (int i=n; i>0; i--)
	  if (scc[p[i]]==0) {
		  k++;
		  dfs2(p[i]);
	  }
  
  int r = 0;
  for (int i=1; i<=k; i++)
	  if (!f[i])
		  if (r==0) r = i; else {
			  r = 0;
			  break;			 
		  }
  for (int i=1; i<=n; i++)
	  if (scc[i]==r) out.print(i+" "); 
  out.print(0);
  out.close();
}

}


