import java.io.*;
import java.util.*;
//import java.math.*;

public class Solution {
	class Point {
		double x, y;
		public Point(double xx, double yy) {
			x = xx; y = yy;
		}
		Point sub(Point a) {
			return new Point(x-a.x, y-a.y);
		}		
		double dist() {
			return Math.sqrt(sq(x)+sq(y));
		}	
		public String toString() {
			return String.format("%1.5f %1.5f", x, y);
		}
	}
	
	double sq(double x) {
		return x*x;
	}
	Point mid(Point a, Point b, double t) {
		return new Point(a.x*t+b.x*(1-t), a.y*t+b.y*(1-t));
	}
	double val(Point a, Point b) {
		return a.dist()+b.sub(a).dist();
	}
	
	double F(Point p, Point a, Point b) {
		double l = -1e+7, r = 1e+7;
		for (int it1=0; it1<200; it1++) {
			double x1 = l+(r-l)/3;
			double x2 = r-(r-l)/3;
			Point p1 = mid(a, b, x1);
			Point p2 = mid(a, b, x2);
			if (val(p, p1)>val(p, p2)) l = x1; else r = x2;
		}
		return val(p, mid(a, b, (l+r)/2));
	}
	
	void solve() throws IOException {
		Point[] a = new Point[4];
		int n = 4;
		for (int i=0; i<n; i++) a[i] = new Point(nextDouble(), nextDouble());
		double best = 1e+100;
		for (int i=0; i<n-1; i++)
			for (int j=i+1; j<n; j++) {
				Point aa = null, bb = null;
				Point a1 = a[i], b1 = a[j];
				for (int k=0; k<n; k++) if (k!=i && k!=j) {
					if (aa==null) aa = a[k]; else bb = a[k]; 
				}
				double l1 = -1e+7, r1 = 1e+7;
				for (int it1=0; it1<200; it1++) {
					double x1 = l1+(r1-l1)/3;
					double x2 = r1-(r1-l1)/3;
					Point p1 = mid(a1, b1, x1);
					Point p2 = mid(a1, b1, x2);
					if (F(p1, aa, bb)>F(p2, aa, bb)) l1 = x1; else r1 = x2;
				}
				best = Math.min(best, F(mid(a1, b1,(l1+r1)/2), aa, bb));
			}
		out.printf(Locale.US, "%1.7f", best);
		
    }    

	
    static final int inf = 1000000000+10;
    static final double epd = 1e-8;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
            //br = new BufferedReader(new FileReader(FileName+".in"));
            //out = new PrintWriter(FileName+".out");
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //br = new BufferedReader(new FileReader("input.txt"));
            //out = new PrintWriter("output.txt");
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                    return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }
    double nextDouble() throws IOException {
       return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
            return Integer.parseInt(next());
    }
    long nextLong() throws IOException {
            return Long.parseLong(next());
    }
    public static void main(String[] args) {        
            new Solution().run();    
    }    
}