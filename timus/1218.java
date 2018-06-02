import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int n,time,k;
boolean[][] a;
int[] p1,p2,p3,p,scc;
boolean[] f;
void dfs1(int v) {
	f[v] = true;
	for (int i=0; i<n; i++)
		if (a[i][v] && !f[i]) dfs1(i);
	p[time++] = v;	
}

void dfs2(int v) {
	scc[v] = k;
	for (int i=0; i<n; i++)
		if (a[v][i] && scc[i]==0) dfs2(i);
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  n = in.nextInt();
  String[] name = new String[n];
  p1 = new int[n];
  p2 = new int[n];
  p3 = new int[n];
  for (int i=0; i<n; i++) {
	  name[i] = in.next();
	  p1[i] = in.nextInt();
	  p2[i] = in.nextInt();
	  p3[i] = in.nextInt();
  }
  a = new boolean[n][n];
  for (int i=0; i<n; i++)
	  for (int j=i+1; j<n; j++) {
		  int t = 0;
		  if (p1[i]>p1[j]) t++;
		  if (p2[i]>p2[j]) t++;
		  if (p3[i]>p3[j]) t++;
		  a[i][j] = t>1;
		  a[j][i] = !a[i][j];
	  }
  
  f = new boolean[n];
  p = new int[n];
  time = 0;
  for (int i=0; i<n; i++)
	  if (!f[i]) dfs1(i);
  scc = new int[n];
  k = 0;
  for (int i=n-1; i>=0; i--)
	  if (scc[p[i]]==0)  {
		  k++;
		  dfs2(p[i]);
	  }
 // out.print(k);
  f = new boolean[k+1]; Arrays.fill(f, true);
  for (int i=0; i<n; i++)
	  for (int j=0; j<n; j++)
		  if (a[i][j] && scc[i]!=scc[j]) 
			  f[scc[j]] = false;
  int res = 0;
  for (int i=1; i<=k; i++)
	  if (f[i])
		  if (res==0) res = i; else { res = 0; break;}
  for (int i=0; i<n; i++)
	  if (scc[i]==res) out.println(name[i]); 
  
  in.close(); out.close();
}

}
