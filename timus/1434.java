import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  int m = nextInt();
  int n = nextInt();
  int[][] a = new int[m][];
  Vector<Integer>[] r = new Vector[n+1];
  for (int i=1; i<=n; i++) r[i] = new Vector<Integer>();
  for (int i=0; i<m; i++) {
	  int k = nextInt();
	  a[i] = new int[k];
	  for (int j=0; j<k; j++) {
		  int x = nextInt();
		  a[i][j] = x;
		  r[x].add(i);
	  }	 
  }  
  int[] Q = new int[n+1];
  int[] d = new int[n+1]; Arrays.fill(d, -1);
  int[] p = new int[n+1];
  boolean[] f = new boolean[m];
  int s = 0, t = 0;
  int A = nextInt();
  int B = nextInt();
  Q[0] = A; d[A] = 0;
  boolean fl = false;
  while (s<=t && !fl) {
	  int x = Q[s++];
	  for (int i:r[x]) {
		  if (f[i]) continue;
			  for (int v:a[i])
				  if (d[v]<0) { 
					  d[v] = d[x]+1;
					  Q[++t] = v;
					  p[v] = x;
					  if (v==B) {fl = true; break;}
				  }		
		  f[i] = true;
	  }
  }
  out.println(d[B]);
  if (d[B]>0) {
	  Stack<Integer> st = new Stack<Integer>();
	  int x = B;
	  while (x>0) {
		  st.push(x);
		  x = p[x];
	  }
	  while (st.size()>0) out.print(st.pop()+" ");
  }
  out.close();
}

}


