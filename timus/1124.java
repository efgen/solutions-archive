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

Stack<Integer>[] a;
boolean[] f;
int n;
int res = -1;
void dfs(int v) {
	if (f[v]) return; else f[v] = true;
	while (a[v].size()>0)	
		dfs(a[v].pop());
	
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  n = nextInt();
  int m = nextInt();
  a = new Stack[n+1];
  f = new boolean[n+1];
  for (int i=1; i<=n; i++) 
	  a[i] = new Stack<Integer>();
  for (int i=1; i<=n; i++) {
	  for (int j=1; j<=m; j++) {
		  int x = nextInt();
		  if (x!=i) { a[i].push(x); res++;}
	  }
  }
  for (int i=1; i<=n; i++) 
	  if (!f[i] && a[i].size()>0) { res++; dfs(i); }
  if (res<0) res = 0;
  out.print(res);  
  out.close(); 
}

}

