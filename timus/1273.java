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
	in = new Scanner(br);
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

class Point implements Comparable{
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int compareTo(Object arg0) {	
		return x-((Point)arg0).x;
	}
}


public void run() {
	int n = in.nextInt();	
	if (n==0) out.print(0); else {
		Point[] a = new Point[n];
		for (int i=0; i<n; i++) 
			a[i] = new Point(in.nextInt(),in.nextInt());
		Arrays.sort(a);
		int[] d = new int[n];
		Arrays.fill(d, 1);
		int res = 1;
		for (int i=1; i<n; i++) { 
			for (int j=0; j<i; j++)
				if (a[j].y<a[i].y) 
					d[i] = Math.max(d[i], d[j]+1);
			res  = Math.max(res, d[i]);
		}		
		out.print(n-res);	
	}
	out.flush();
}
}


