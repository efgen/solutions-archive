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
Vector<Integer>[] b;
int[] res;
boolean[] f;
int n,m;
boolean chain(int v) {
	if (v==0) return true;
	if (f[v]) return false; else f[v] = true;
	for (int x:b[v])
		if (chain(res[x])) {
			res[x] = v;
			return true;
		}
	return false;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  n = nextInt();
  m = nextInt();
  int k = nextInt();
  b = new Vector[m+1];
  for (int i=1; i<=m; i++) b[i] = new Vector<Integer>();
  while (k-->0) {
	  int x = nextInt();
	  int y = nextInt();
	//  a[x].add(y);
	  b[y].add(x);
  }
  res = new int[n+1];
  f = new boolean[m+1];
  for (int i=1; i<=m; i++) {
	  Arrays.fill(f, false);
	  chain(i);	  	  
  }
  int pp = 0;
  for (int i=1; i<=n; i++)
	  if (res[i]>0) pp++;
  out.print(n+m-pp);
  out.close();    
}   
  
}




