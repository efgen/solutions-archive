import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}

class Point implements Comparable {
	int x,y;
	Point(int xx, int yy) { x= xx; y = yy; }
	public int compareTo(Object P) {
		Point p = (Point) P;
		if (p.x==x) return p.y-y; else return x-p.x;
	}
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  int w = in.nextInt();
  int h = in.nextInt();
  int px = 0, py = 0, l = 0;
  Point[] p = new Point[n+2];
  for (int i=1; i<=n; i++) p[i] = new Point(in.nextInt(),in.nextInt());
  p[0] = new Point(0,0); p[n+1] = new Point(w,h);
  Arrays.sort(p);

  for (int i=0; i<=n; i++)
	  for (int j=0; j<=n; j++) {
		  int Y = h;
		  int r = 0;
		  for (int k=i+1; k<=n+1; k++)
			  if (p[k].y>p[j].y) {				
				  r = Math.max(r,Math.min(Y-p[j].y, p[k].x-p[i].x));
				  Y = Math.min(Y, p[k].y);
			  }
		  if (r>l) {
			  l = r; px = p[i].x; py = p[j].y;
		  }		  
	  }
  out.println(px+" "+py+" "+l); 
  in.close(); out.close();  
}
}


