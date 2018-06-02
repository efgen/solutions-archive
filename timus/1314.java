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
Vector<Integer>[] a = new Vector[32768];
int[] bfs(int s) {
	int[] d = new int[32768]; Arrays.fill(d, -1);
	Queue<Integer> q = new LinkedList();
	q.add(s); d[s] = 0;
	while (q.size()>0) {
		int v = q.poll();
	//	if (a[v]==null) continue;
		for (int x:a[v]) 
			if (d[x]<0) {
				d[x] = d[v]+1;
				q.add(x);
			}		
	}	
	return d;
}
public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  int n = nextInt();
  while (n-->0) {
	  int m = nextInt();
	  int x = nextInt();
	  while (m-->1) {
		  int y = nextInt();
		  if (a[x]==null) a[x] = new Vector<Integer>();
		  if (a[y]==null) a[y] = new Vector<Integer>();
		  a[x].add(y);
		  a[y].add(x);
		  x = y;
	  }
  }
  int m = nextInt();
  int s = nextInt();
  int t = s;
  for (int i=2; i<=m; i++) t = nextInt();
  
  int[] d1 = bfs(s);
  int[] d2 = bfs(t);

  for (int i=1; i<=32767; i++)
	  if (d1[i]>=0 && d2[i]>=0 && d1[i]==(d2[i]+m-1)) 
		  out.println(i);
  out.close(); 
 
}

}

