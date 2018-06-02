import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}
int n;
boolean[] t,tt,f;
Vector<Integer>[] a;
int sz = 0;
void dfs(int v) {
	sz++;
	f[v] = true;
	t[v] = !t[v];
	for (int x:a[v])
		if (!f[x] && t[x]!=t[v]) 
			dfs(x);  
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  n = nextInt();
  int m = nextInt();
  a = new Vector[n+1];
  t = new boolean[n+1];
  tt = new boolean[n+1];
  f = new boolean[n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector<Integer>();
 
  for (int i=1; i<=n; i++) 
	  if (next().charAt(0)=='J') tt[i] = true;
  
 
  while (m-->0) {
	  int x = nextInt();
	  int y = nextInt();
	  a[x].add(y);
	  a[y].add(x);
  }
  int res = n+1;
  int B = -1;
  for (int b=1; b<=n; b++) {
	  int r = -1;
	  t = tt.clone();	  
	  sz = 0;
	  while (sz<n) {
		  sz = 0;
		  r++;
		  Arrays.fill(f, false);
		  dfs(b);
	  }	  
	  if (r<res) {
		  res = r;
		  B = b;
	  }
  }
  out.println(res);  
  while (res-->0) {
	  out.print(B+" ");
	  if (!tt[B]) out.println("J"); else out.println("E");
	  tt[B] = !tt[B];
  }
  out.close();    
}   
  
}




