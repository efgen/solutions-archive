import java.io.*;
import java.security.AllPermission;
import java.util.*;
import java.math.*;

import javax.swing.text.html.HTML;

public class Main{
	//static final String FileName = "test";
	int n, d, n2;
	int[][] dx;
	ArrayList<Integer>[] a;
	HashSet<Long> hs = new HashSet<Long>(3000000);
	void add(int[] pos) {
		/*int t = 0;
		for (int i=1; i<n; i++) t = t*d+pos[i];
		a[pos[0]].add(t); */	
		
	}
	void go(int[] pos, int k) {
		
		if (k==0) {
			//for (int i=0; i<n; i++) out.print((pos[i]+1)+" "); out.println();
			long tt = 0;
			for (int i=0; i<n; i++) tt = tt*d+pos[i];
			hs.add(tt);
			return;
		}
		for (int i=0; i<n; i++) for (int j=0; j<d; j++) if (pos[i]!=j){
			int x = pos[i];
			pos[i] = j;
			go(pos, k-1);
			pos[i] = x;
		}
		int[] tmp = new int[n];
		for (int msk=n2-1; msk>=0; msk--) {
			for (int i=0; i<n; i++) tmp[i] = pos[i];
			for (int i=1; i<d; i++) {
				boolean end = false;
				for (int j=0; j<n; j++) {
					pos[j] += dx[msk][j];
					if (pos[j]<0 || pos[j]>=d) {
						end = true;
						break;
					}
				}
				if (end) break;
				go(pos, k-1);
			}
			for (int i=0; i<n; i++) pos[i] = tmp[i];
			
		}
	}
	void solve() throws IOException {
		n = nextInt();
		n2 = 1<<n;
		d = nextInt();
		int[] pos = new int[n];
		for (int i=0; i<n; i++) pos[i] = nextInt()-1;
		//a = new ArrayList[d];
		//for (int i=0; i<d; i++) a[i] = new ArrayList<Integer>();
		dx = new int[n2][n];
		for (int msk=0; msk<n2; msk++) 
			for (int i=0; i<n; i++) if ((msk&(1<<i))==0) dx[msk][i] = 1; else dx[msk][i] = -1;
		go(pos, 2);
		/*out.println("!"); out.flush();
		int res = 0;
		int max = 0;
		for (int i=0; i<d; i++) {
			ArrayList<Integer> cur = a[i];
			Collections.sort(cur);
			int nn = cur.size();
			if (nn>max) max = nn;
			for (int j=0; j<nn; ) {
				int k = 1;
				while(j+k<nn && cur.get(j+k).equals(cur.get(j))) k++;
				res++;
				j += k;
			}
		}
		out.println(res);
		out.println(max); */
		out.println(hs.size());
		
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
