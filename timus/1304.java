import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
int nextD() throws IOException{      
    ST.nextToken();      
    return (int) Math.floor(ST.nval*100+0.5);     
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}      
public void run()  {      
    try {          
    	br = new BufferedReader(new InputStreamReader(System.in));        
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
	int x, y, z;
	public Point(int xx, int yy, int zz) {
		z = zz; y = yy; x = xx;
	}
	public int compareTo(Point arg0) {
		if (z==arg0.z)
			return (y==arg0.y)?(x-arg0.x):(y-arg0.y);			
		return z-arg0.z;
	}
	
	
}
public void solve() throws IOException {
	int X = nextD();
	int Y = nextD();
	int Z = nextD();
	int n = nextInt();

	int[] xx = new int[n+2];
	int[] yy = new int[n+2];
	int[] zz = new int[n+2];
	Point[] a = new Point[n+2];
	int cnt = 0;
	for (int i=0; i<n; i++) {
		xx[cnt] = nextD();
		yy[cnt] = nextD();
		zz[cnt] = nextD();
		a[cnt] = new Point(xx[cnt], yy[cnt], zz[cnt]);
		if (xx[cnt]>=0 && yy[cnt]>=0 && zz[cnt]>=0 && xx[cnt]<=X && yy[cnt]<=Y && zz[cnt]<=Z) cnt++;
		
	}
	n = cnt;
	xx[n] = X; yy[n] = Y; zz[n] = Z;
	a[n] = new Point(X, Y, Z);
	a[n+1] = new Point(0, 0, 0);
	n += 2;
	Arrays.sort(xx, 0, n);
	Arrays.sort(yy, 0, n);
	Arrays.sort(a, 0, n);
	Point[] aa = new Point[n-1];
	for (int i=1; i<n; i++) aa[i-1] = a[i];
	long res = 0;
	for (int ix=0; ix<n; ix++)
		for (int jx=ix+1; jx<n; jx++) {
			long lx = xx[jx]-xx[ix];
			if (lx*Y*Z<=res) continue;
			for (int iy=0; iy<n; iy++)
				for (int jy=iy+1; jy<n; jy++){
					long ly = (yy[jy]-yy[iy])*lx;
					if (ly*Z<=res) continue;
					Point pp = a[0];
					for (Point p:aa) 
						if (p.x>xx[ix] && p.x<xx[jx] && p.y>yy[iy] && p.y<yy[jy]) {
							long t = ly*(p.z-pp.z);
							if (t>res)  res = t;
							pp = p;
						}
					long t = ly*(Z-pp.z);
					if (t>res) res = t;
					
				}
		}
	
	
	out.printf(Locale.US, "%1.2f", res/1000000.0);

}
}











