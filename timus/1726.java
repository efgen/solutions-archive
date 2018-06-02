import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
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
    	//br = new BufferedReader(new FileReader(new File(filename+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point implements Comparable<Point>{
	int x, y;
	public Point (int xx, int yy) {
		x = xx; y = yy;
	}

	public int compareTo(Point o) {
		if (x!=o.x)
			return x-o.x;
		return y-o.y;
	}
}

public void solve() throws IOException {
	int n = nextInt();
	Point[] a = new Point[n];
	for (int i=0; i<n; i++) a[i] = new Point(nextInt(), nextInt());
	Arrays.sort(a);
	long res = 0;
	long v = 0;
	for (int i=0; i<n; i++) v += a[i].x;
	for (int i=0; i<n; i++) {
		res += v - 1l*a[i].x*(n-i);
		v -= a[i].x;
	}
	Arrays.sort(a, new Comparator<Point>() {		
		public int compare(Point o1, Point o2) {
			if (o1.y!=o2.y)
				return o1.y-o2.y;
			return o1.x-o2.x;
		}		
	});
//	out.println(res);
	v = 0;
	for (int i=0; i<n; i++) v += a[i].y;
	for (int i=0; i<n; i++) {
		res += v - 1l*a[i].y*(n-i);
		v -= a[i].y;
	}
//	out.println(res);
	out.println(res/((n*(n-1l)/2)));
}
}





