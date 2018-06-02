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
int n;
Vector<Integer>[] a;
boolean[] f;
int solv(int v) {	
	f[v] = true;	
	Vector<Integer> t = new Vector<Integer>();
	for (int u:a[v]) 
		if (!f[u]) t.add(solv(u));
	int k = t.size();
	int res = 0;
	Integer[] time = t.toArray(new Integer[0]);
	Arrays.sort(time);
	for (int x:time) {
		res = Math.max(x+k, res);
		k--;
	}
	return res;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  int n = nextInt();
  a = new Vector[n+1];
  f = new boolean[n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector<Integer>();
  for (int v=1; v<=n; v++) {
	  int u = 0;
	  while ((u = nextInt())>0) {
		  a[v].add(u);
		  a[u].add(v);		  
	  }      
  }
  out.print(solv(nextInt()));
  out.close();
}

}


