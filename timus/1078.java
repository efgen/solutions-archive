import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
Scanner in;
PrintWriter out;
public static void main(String[] args) throws IOException {
new Main().run();
}
class Point implements Comparable{
	int x,y,id;
	Point(int x, int y, int id) { this.x = x; this.y = y; this.id = id; }
	public int compareTo(Object o) {
		return ((Integer)x).compareTo((Integer)(((Point)o).x));			
	}
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
  Point[] a = new Point[n+1];
  int[] p = new int[n+1];
  int[] r = new int[n+1];
  for (int i=1; i<=n; i++) 
	  a[i] = new Point(in.nextInt(),in.nextInt(),i);
  Arrays.sort(a,1,n+1);
  Arrays.fill(r, 1);
  for (int i=n-1; i>0; i--) {
	  for (int j=i+1; j<=n; j++)
		  if (a[i].x<a[j].x && a[j].y<a[i].y)
			  if (r[i] < r[j]+1) {
				  r[i] = r[j]+1;
				  p[i] = j;
			  }
  }
  int x = 1;
  for (int i=1; i<=n; i++)
	  if (r[i]>r[x]) x = i;
  out.println(r[x]);
  Stack<Integer> s = new Stack<Integer>();
  while (x>0) {
	  s.push(a[x].id);
	  x = p[x];
  }
  while (s.size()>0) out.print(s.pop()+" ");
  
  
  
  in.close(); out.close();
}
}