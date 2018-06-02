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
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}

class Point {
	int v, x;
	Point(int vv, int xx) {
		x = xx ; v = vv;
	}
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = nextInt();
  int R = nextInt();
  Vector<Integer>[] a = new Vector[n];
  Queue<Point> Q = new LinkedList<Point>();
  a[0] = new Vector<Integer>(); a[0].add(1); Q.add(new Point(0,nextInt()));
  int k = 1;
  for (int i=2; i<=n; i++) {
	  int x = nextInt();
	  if (x>Q.peek().x+R) {
		  int v = Q.poll().v;
		  Q.add(new Point(v,x));
		  a[v].add(i);
	  } else {
		  a[k] = new Vector<Integer>(); a[k].add(i); 
		  Q.add(new Point(k,x));
		  k++;		  
	  }
  }
  out.println(k);
  for (int i=0; i<k; i++) {
	  out.print(a[i].size());
	  for (int x:a[i]) { out.print(" "); out.print(x); }
	  out.println();
  } 
  out.close();    
}   
  
}




