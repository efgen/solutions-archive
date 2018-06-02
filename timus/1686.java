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
double[] sx,sy,sz;
int n;
double res = 0;
class Point {
	double x,y,z;
	Point(double xx, double yy, double zz) {
		x = xx; y =yy; z = zz;
	}
}
void calc(Point p, Point p1, Point p2, Point pp) {
	double a = (p1.y-p.y)*(p2.z-p.z)-(p1.z-p.z)*(p2.y-p.y);
	double b = (p1.z-p.z)*(p2.x-p.x)-(p1.x-p.x)*(p2.z-p.z);
	double c = (p1.x-p.x)*(p2.y-p.y)-(p1.y-p.y)*(p2.x-p.x);
	double d = p.x*a+p.y*b+p.z*c;	
	d = -d;
	for (int i=0; i<n; i++) {
		double t1 = a*(sx[i]+p2.x)+b*(sy[i]+p2.y)+c*(sz[i]+p2.z)+d;
		if (Math.abs(t1)<1e-7) continue;
		double t2 = a*(pp.x)+b*(pp.y)+c*(pp.z)+d;
		if (t1<0 ^ t2<0) {
			res += Math.abs(a*sx[i]+b*sy[i]+c*sz[i]);
		}
	}
	
}
public void solve() throws IOException {
	Point p1 = new Point(nextInt(), nextInt(), nextInt());
	Point p2 = new Point(nextInt(), nextInt(), nextInt());
	Point p3 = new Point(nextInt(), nextInt(), nextInt());
	Point p4 = new Point(nextInt(), nextInt(), nextInt());
	n = nextInt();
	sx = new double[n];
	sy = new double[n];
	sz = new double[n];
	for (int i=0; i<n; i++) {
		sx[i] = nextInt();
		sy[i] = nextInt();
		sz[i] = nextInt();
	}
	calc(p1,p2,p3,p4);
	calc(p1,p2,p4,p3);
	calc(p1,p4,p3,p2);
	calc(p4,p2,p3,p1);
	out.printf(Locale.US,"%1.7f", res);
		
	
}
} 











