import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable{
static BufferedReader br;
static Scanner in;
static StreamTokenizer inST;
static PrintWriter out;

public static void main(String[] args) throws IOException {
	br = new BufferedReader(new InputStreamReader(System.in));
//	in = new Scanner(br);
	inST = new StreamTokenizer(br);
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	new Thread(new Main()).start();
}
static int nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return (int)inST.nval;
}

int[] a,c;
int n,pr;

void dfs(int v) {
	c[v] = 1;
	if (a[v]==0) { c[v] = 2; pr++; return; }
	if (c[a[v]]==0) dfs(a[v]); else
	if (c[a[v]]==1) pr = 2;
	c[v] = 2;
}
public void run() { 
  int test = nextInt();
  while (test-->0) {
	  n = nextInt();
	  a = new int[n+1];
	  c = new int[n+1];	
	  pr = 0;
	  for (int i=1; i<=n; i++) a[i] = nextInt();
	  for (int i=1; i<=n; i++)
		  if (c[i]==0) dfs(i);
	  if (pr==1) out.println("YES"); else out.println("NO");
  }  
  out.flush();
}
}


