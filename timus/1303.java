import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
int inf = 100000000;
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br); 
  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  int n = Integer.parseInt(br.readLine());
  Vector<Point>[] a = new Vector[n+1];
  for (int i=0; i<=n; i++) a[i] = new Vector<Point>();
  while (true) {
	  String[] ss = br.readLine().split(" +");
	  int l = Integer.parseInt(ss[0]);
	  int r = Integer.parseInt(ss[1]);
	  if (l==0 && r==0) break;	
	  if (l>=n) continue;
	  int x = Math.max(l, 0);
	  if (a[x].isEmpty()) a[x].add(new Point(l,r)); else {
		  int t = a[x].elementAt(0).y;
		  if (r>t) {
			  a[x].clear();
			  a[x].add(new Point(l,r));
		  }
	  }
	  //a[Math.max(l, 0)].add(new Point(l,r));	  
  }
  int[] d = new int[n+1]; Arrays.fill(d, inf);
  Point[] use = new Point[n+1]; d[n] = 0;
  for (int x=n-1; x>=0; --x) {
	  for (Point p:a[x]) {
		  if (p.y>=n) {
			  d[x] = 1;
			  use[x] = p;
			  break;			  
		  } else {
			  for (int t=x+1; t<=Math.min(p.y,n); t++)
				  if (d[t]+1<d[x]) {
					  d[x] = d[t]+1;
					  use[x] = p;
				  }
		  }
			  
	  }
  }
  if (d[0]==inf) {
	  out.print("No solution");
	  out.close();
	  return;
  }
  Vector<Point> res = new Vector<Point>();
  for (int x=0; x<n; ) {
	  res.add(use[x]);
	  int t = d[x];
	  while (x<=n && d[x]!=t-1) x++;
  }
  out.println(res.size());
  for (Point p:res) out.println(p.x+" "+p.y);
  out.close();    
}   

}
