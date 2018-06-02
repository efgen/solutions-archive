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
	return (int) in.nval;
}
HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
Stack<Integer>[]  a = new Stack[1000];
Stack<Integer> res = new Stack<Integer>();
int[] id = new int[1000];
int n = 0;
int nextS() throws IOException  {
	in.nextToken();
	int x = (int) in.nval;
	Integer r = map.get(x);
	if (r==null) {map.put(x, n);id[n]=x; n++; return n-1; } else return r;
}
void dfs(int v) {
	while (a[v].size()>0) 
		dfs(a[v].pop());
	res.push(id[v]);
}
public void run()  {
try {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  int routs = nextInt(); 
  for (int i=0; i<1000; i++) a[i] = new Stack<Integer>();
  int[] r = new int[1000];
  while(routs-->0) {
	  int m = nextInt();	  
	  int x = nextS();
	  while (m-->0) {
		  int y = nextS();
		  a[x].push(y);
		  x = y;
		  r[x]++; r[y]--;
	  }
  }
  boolean fl = true;
  for (int i=0; i<n; i++)
	  fl &= (r[i]==0);
  if (fl) {
	  dfs(0);
	  out.print(res.size()-1);
	  while (res.size()>0) out.print(" "+res.pop());
	 
  } else out.print(-1);
  out.close(); }
  catch (IOException e)  {
     throw new IllegalStateException(e);
  }
}

}

