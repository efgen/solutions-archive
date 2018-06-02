import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
int inf = 1000000000;   

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}

long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}      
public void run()  {      
    try {          
    	br = new BufferedReader(new InputStreamReader(System.in));        
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point implements Comparable<Point> {
	int x, y, id;
	Point (int xx, int yy, int i) {
		x = xx; y = yy; id =i;
	}

	public int compareTo(Point o) {
		int t = y*o.x-x*o.y; 
		if (t==0)return -(x*x+y*y-o.x*o.x-o.y*o.y); else return t;
	}

}
class Cmp implements Comparator<Point> {

	
	public int compare(Point o1, Point o2) {
		int t = o1.y*o2.x-o1.x*o2.y; 
		if (t==0)return (o1.x*o1.x+o1.y*o1.y-o2.x*o2.x-o2.y*o2.y); else return t;
	}
	
}
public void solve() throws IOException {
	int n = nextInt();
	Point[] a = new Point[n];
	for (int i=0; i<n; i++) a[i] = new Point(nextInt(), nextInt(), i+1);
	int r = 0;
	for (int i=0; i<n; i++)
		if (a[i].y<a[r].y || (a[i].y==a[r].y && a[i].x<a[r].x)) r = i;
	Point pp = a[r]; a[r] = a[0]; a[0] = pp;
	for (int i=1; i<n; i++) a[i].x -= a[0].x;
	for (int i=1; i<n; i++) a[i].y -= a[0].y;
	Arrays.sort(a, 1 ,n);
	for (int i=0; i<n; i++)
		if (a[i].id == 1) r = i;
	
	out.println(n);
	if (r==0) {
		out.println(a[r].id);
		for (int i=n-1; i>0; --i) out.println(a[i].id);
		return;
	}
	for (int i=r; i<n; i++) out.println(a[i].id);
	if (r>0) {
		out.println(a[0].id);
		Arrays.sort(a, 1, r, new Cmp());
		for (int i=1; i<r; i++) out.println(a[i].id);
	}

}
}







