import java.io.*;
import java.util.*;
import java.math.*;

import javax.swing.text.html.HTML;

public class Main{
	//static final String FileName = "test";
	class Point implements Comparable<Point>{
		int x, y;
		public Point (int xx, int yy) {
			x = xx; y = yy;
		}
		@Override
		public int compareTo(Point o) {
			if (x==o.x) return o.y-y;
			return x-o.x;
		}
		public String toString() {
			return x+" "+y;
		}
	}
	void solve() throws IOException {
		TreeMap<Point, Integer> map = new TreeMap<Point, Integer>();
		int n = nextInt();
		Point[] a = new Point[n];
		for (int i=0; i<n; i++) {
			int x = nextInt();
			int y=  nextInt();
			if (x>y) {
				int q = x; x = y; y = q;
			}
			a[i] = new Point(x, y);			
		}
		Arrays.sort(a);
		for (int i=0; i<n; i++) {
			Point p = a[i];
			if (map.containsKey(p)) { map.put(p, map.get(p)+1); continue; } else
			if (map.isEmpty()) {map.put(p, 1); continue; } else {
				Point pr = map.floorKey(p);
				if (pr==null) {
					if (p.y>=map.firstKey().y) {
						map.put(p, 1);
						continue;
					}
				} else {
					if (p.y<=pr.y) {
						Point next = map.higherKey(pr);
						if (next==null || (p.x<=next.x && p.y>=next.y)) {
							map.put(p, 1);
							continue;
						}
					}
				}
			}
			p = new Point(a[i].y, a[i].x);
			if (map.containsKey(p))  { map.put(p, map.get(p)+1); continue; }  else
			if (map.isEmpty()) {map.put(p, 1); continue; } else {
				Point pr = map.floorKey(p);
				if (pr==null) {
					if (p.y>=map.firstKey().y) {
						map.put(p, 1);
						continue;
					}
				} else {
					if (p.y<=pr.y) {
						Point next = map.higherKey(pr);
						if (next==null || (p.x<=next.x && p.y>=next.y)) {
							map.put(p, 1);
							continue;
						}
					}
				}
			}
			out.println("NO");
			return;	
			
		}
		out.println("YES");
		for (Point p:map.keySet()) {
			for (int i=map.get(p); i>0; --i) out.println(p);
		}
		
		
	}
	
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
		new Main().run();
	}
}
