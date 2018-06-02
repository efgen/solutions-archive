import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
//Scanner in;   
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
        //in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point {
	int x, y, id;
	boolean f;
	Point(int xx, int yy, int i) {
		x = xx; y = yy; id = i;
	}
	int dist(Point p) {
		return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y);
	}
}
public void solve() throws IOException {
	int n = nextInt()+2;
	Point[] a = new Point[n];
	for (int i=1; i<=n; i++) a[i-1] = new Point(nextInt(), nextInt(), i);

	int p = 0;
	out.println("YES");
	for (int k=0; k<n; k++) {
		out.print(a[p].id);
		out.print(" ");
		a[p].f = true;
		int t = p;
		int vv = 0;
		for (int i=0; i<n; i++)
			if (!a[i].f && a[p].dist(a[i])>vv) {
				vv = a[p].dist(a[i]);
				t = i;
			}
		p = t;
		
	}
}
}







