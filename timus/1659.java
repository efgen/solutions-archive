import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StringTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
int nextInt() throws IOException{      
          
    return Integer.parseInt(next());      
}
long nextLong() throws IOException{    
    
    return Long.parseLong(next());      
}

String next() throws IOException{      
    while (ST==null || !ST.hasMoreTokens()) {
    	String line = br.readLine();
    	if (line==null) return null;
    	ST  = new StringTokenizer(line);
    }
    return ST.nextToken();
}      
double nextD() throws IOException{      
    return Double.parseDouble(next());      
}      
public static void main(String[] args) throws IOException {       
   new Thread(new Main()).start();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
    	//in = new Scanner(br);
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}
class Point {
	double x, y;
	public Point(double xx, double yy) {
		x = xx; y = yy;
	}
	double norm() {
		return Math.sqrt(x*x+y*y);
	}
	Point sub(Point a) {
		return new Point(x-a.x, y-a.y);
	}
	Point add(Point a) {
		return new Point(x+a.x, y+a.y);
	}
	Point mul(double v) {
		v /= this.norm();
		return new Point(x*v, y*v);
	}
	Point hz() {
		return new Point(-y, x);
	}
	public String toString() {
		return String.format(Locale.US, "%1.12f %1.12f", x, y);
	}
	double cp(Point a) {
		return x*a.y-y*a.x;
	}
}

public void solve() throws IOException {
	Point a = new Point(nextD(), nextD());
	Point b = new Point(nextD(), nextD());
	Point c = new Point(nextD(), nextD());
	Point ba = b.sub(a);
	Point ca = c.sub(a);
	if (ba.cp(ca)<0) {
		Point q = b; b =c; c = q;
	}
	double val = a.sub(b).norm()/5;
	Vector<Point> v = new Vector<Point>();
	for (int i=0; i<3; i++) {
		Point t1 = b.sub(a).add(c.sub(a)).mul(val);
		Point t2 = b.sub(a).hz().mul(val);
		out.println(a.add(t1));
		v.add(a.add(t2));
		Point q = a; a = b; b = c; c = q;
	}
	for (Point p:v) out.println(p);
}
  
}













 
 
  