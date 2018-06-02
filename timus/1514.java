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

class Point{
	int x, y, id;


	Point (int xx, int yy, int i) {
		x = yy; y = xx; id = i;
	}

	public String toString() {
		return x+" "+y;
	}
}

class MinDist {
	Point[] a, b;
	double mindist;
	int t1 = -1, t2 = -1, t3 = -1;
	MinDist(Point[] aa) {
		int n = aa.length;
		a = aa;
		b = new Point[n];
		Arrays.sort(a, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				if (a.x==b.x) return a.y-b.y;
				return a.x-b.x;
			}
		});
		mindist = 1e+100;
		rec(0, n-1);
	}
	double hypot(double x, double y) {
		return Math.sqrt(x*x+y*y);
		//return Math.hypot(x, y);
	}

	void upd(int i, int j, int k) {
		double v = hypot(a[i].x-a[j].x, a[i].y-a[j].y) +
		hypot(a[k].x-a[j].x, a[k].y-a[j].y) +
		hypot(a[i].x-a[k].x, a[i].y-a[k].y);
		if (v<mindist) {
			mindist = v;
			t1 = a[i].id; t2 = a[j].id; t3 = a[k].id;
		}
	}
	Comparator<Point> cmpy = new Comparator<Point>() {
		public int compare(Point a, Point b) {
			if (a.y==b.y) return a.x-b.x;
			return a.y-b.y;
		}
	};
	
	void rec(int l, int r) {
		if (r-l<2) return;
		if (r-l==2) {
			upd(l, l+1, r);
			Arrays.sort(a, l, r+1, cmpy);
			return;
		}
		int mid = (l+r)/2;
		int midx = a[mid].x;
		rec(l, mid); rec(mid+1, r);
		int i = l, j = mid+1, k = 0;
		while (i<=mid && j<=r) if (a[i].y<a[j].y || (a[i].y==a[j].y && a[i].x<a[j].x))
			b[k++] = a[i++]; else b[k++] = a[j++];
		while (i<=mid) b[k++] = a[i++];
		while (j<=r) b[k++] = a[j++];
		k = 0;
		for (i=l; i<=r; i++) a[i] = b[k++];
		k = 0;
		for (i=l; i<=r; i++)
			if (Math.abs(a[i].x-midx)<mindist/2) {
				for (j=k-1; j>0 && (a[i].y-b[j].y)<mindist; --j) {
					double d1 = hypot(a[i].x-b[j].x, a[i].y-b[j].y);
					for (int t=j-1; t>=0 && (b[j].y-b[t].y)<mindist; --t) {
						double v = hypot(a[i].x-b[t].x, a[i].y-b[t].y) + 
								   hypot(b[j].x-b[t].x, b[j].y-b[t].y) + d1;						
						if (v<mindist) {
							mindist = v;
							t1 = a[i].id; t2 = b[j].id; t3 = b[t].id;
						}
					}						
				}
				b[k++] = a[i];
			}
	}	
}

Random R  = new Random();
public void solve() throws IOException {
	int n = nextInt();
	Point[] a = new Point[n];
	for (int i=0; i<n; i++) a[i] = new Point(nextInt(), nextInt(), i+1);
	//for (int i=0; i<n; i++) a[i] = new Point(R.nextInt(1000000), R.nextInt(1000000), i);
	/*double res = 1e+100;
	for (int i=0; i<n; i++)
		for (int j=i+1; j<n; j++)
			for (int k=j+1; k<n; k++) {
				res = Math.min(res,  Math.hypot(a[i].x-a[j].x, a[i].y-a[j].y) +
				Math.hypot(a[k].x-a[j].x, a[k].y-a[j].y) +
				Math.hypot(a[i].x-a[k].x, a[i].y-a[k].y));
			}
	*/
	MinDist md = new MinDist(a);
	//out.println(res);
	out.printf(Locale.US,"%1.7f\n", md.mindist);
	out.println(md.t1+" "+md.t2+" "+md.t3);
}
}

