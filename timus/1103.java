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
      //  br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        //out= new PrintWriter(new File("output.txt"));
    	out = new PrintWriter(System.out);
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point implements Comparable<Point> {
	double x,y;
	double k;
	Point(int xx, int yy) {
		x = xx; y = yy;
	}
	public int compareTo(Point arg0) {
		return Double.compare(k, arg0.k);
	}
}
double sc(double x1, double y1,double x2, double y2) {
	return x1*x2+y1*y2;
}
public void solve() throws IOException {
	int n = nextInt();
	Point[] a = new Point[n];
	for (int i=0; i<n; i++) a[i] = new Point(nextInt(),nextInt());
	for (int i=1; i<n; i++)
		if (a[i].x<a[0].x || (a[i].x==a[0].x && a[i].y<a[0].y)) {
			Point q = a[i]; a[i] = a[0]; a[0] = q;
		}
	for (int i=2; i<n; i++)
		if ((a[i].x-a[0].x)*(a[1].y-a[0].y)-(a[1].x-a[0].x)*(a[i].y-a[0].y)>0) {
			Point q = a[i]; a[i] = a[1]; a[1] = q;
		}
	
	double xx = (a[0].x+a[1].x)/2;
	double yy = (a[0].y+a[1].y)/2;
	double na = a[1].y-a[0].y;
	double nb = a[0].x-a[1].x;
	for (int i=2; i<n; i++) {
		double na2 = a[i].x-a[0].x;
		double nb2 = a[i].y-a[0].y;
		double x0 = (a[0].x+a[i].x)/2;
		double y0 = (a[0].y+a[i].y)/2;		
		a[i].k = -sc(na2,nb2,xx-x0,yy-y0)/sc(na2,nb2,na,nb);
		
	}
	Arrays.sort(a,2,n);
	out.printf(Locale.US, "%1.0f %1.0f\n",a[0].x,a[0].y);
	out.printf(Locale.US, "%1.0f %1.0f\n",a[1].x,a[1].y);
	out.printf(Locale.US, "%1.0f %1.0f\n",a[n/2+1].x,a[n/2+1].y);
	
}      
} 












