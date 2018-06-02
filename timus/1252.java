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
	return (int) in.nval;
}

class Point implements Comparable{
	int x,p;
	Point (int xx, int pp) { x = xx; p = pp; }
	public int compareTo(Object arg0) {
		return x-((Point)arg0).x;		
	}	
}
int gcd(int a, int b) {
	if (b==0) return a; else return gcd(b,a%b);
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out);  
  int n = nextInt();
  Point[] a = new Point[n+1];
  for (int i=1; i<=n; i++) a[i] = new Point(nextInt(),i);
  Arrays.sort(a, 1, n+1);
  int res = n-1;
  for (int i=2; i<=n; i++)
	  if (Math.abs(a[i].p-a[i-1].p)!=1) { res = 0; break; }
  if (res==0 && n>1) {
	  for (int i=1; i<=n; i++)
		  res = gcd(res,Math.abs(a[i].p-i));
	  int r = 0;
	  for (int i=n; i>0; i--)
		  r = gcd(r,Math.abs(a[i].p-(n+1-i)));
	  res = Math.max(res, r); res--;
  }
  out.print(res);
  out.close();    
}   
  
} 