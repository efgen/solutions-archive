import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	//static final String FileName = "test";
	class Point {
		int x, y, id;
		public Point(int xx, int yy, int ii) {
			x = xx; y = yy; id = ii;
		}
	}
	void solve() throws IOException{
		int h = nextInt();
		int n = nextInt();
		boolean[] f = new boolean[n+1];
		ArrayList<Point>[] a = new ArrayList[h+1];
		for (int i=0; i<=h; i++) a[i] = new ArrayList<Point>();
		int t = inf;
		boolean ok = true;
		boolean rev = false;
		int cnt = 0;
		for (int i=1; i<=n; i++) {
			int x = nextInt();
			int y = nextInt();
			if (y<x) {
				int q = x; x = y; y = q; rev = true;
				cnt++;
			}
			if (t==inf) t = y-x; else ok &= t+x==y;
			a[x].add(new Point(x, y, i));
			a[h-y].add(new Point(h-y, h-x, -i));
		}
		ok &= cnt==0 || cnt==n;
		if (ok) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			int p = 0;
			while (a[p].size()==0) p++;
			if (a[p].size()==n) {
				for (Point pp:a[p]) res.add(pp.id);
			} else {
				while (p<=h) {
					int op = p;
					for (Point pp:a[p]) if (!f[Math.abs(pp.id)]) {
						f[Math.abs(pp.id)] = true;
						res.add(pp.id);
						p = pp.y;
						break;
					}
					if (p==op) break;
					
				}
			}
			if (res.size()==n) {
				if (rev) {
					for (int i=n-1; i>=0; --i) out.print(res.get(i)+" ");
				} else
				for (int x:res) out.print(x+" ");
			} else out.print(0);
			
		}else out.print(0);

					
	}
	static final int inf = 1000000000;
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
