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
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}
int n,m;
int[] s,p;
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  n = nextInt(); 
  s = new int[n+101];
  p = new int[n+101];
  for (int i=0; i<n; i++) {
	  s[i] = 1<<i;
	  p[i] = nextInt();
  }
  m = nextInt();
  for (int i=0; i<=m; i++) {
	  if (i<m) p[i+n] = nextInt();
	  int k = nextInt();
	  int x = 0;
	  while (k-->0) 
		  x |= 1<<(nextInt()-1);
	  s[i+n] = x;
  }
  int want = s[n+m];
  int sz = 1<<n;
  int[] a = new int[sz]; Arrays.fill(a, inf); a[0] = 0;
  int M = n+m;
  for (int i=0;i<M; i++)
	  for (int msk=sz-1; msk>=0; msk--)
		  a[msk|s[i]] = Math.min(a[msk|s[i]], a[msk]+p[i]);
  int res = inf;
  for (int msk=1; msk<sz; msk++) 
	  if ((want&msk)==want && a[msk]<res) res = a[msk];
  //for (int i=0; i<sz; i++) out.print(a[i]+" "); out.println();
  //out.println(want);
  if (res==inf) out.print(-1); else out.print(res);
  out.close();    
}   
  
}




