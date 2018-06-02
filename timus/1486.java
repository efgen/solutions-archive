import java.io.*;
import java.security.AllPermission;
import java.util.*;
import java.math.*;

import javax.swing.text.html.HTML;

public class Main{
	//static final String FileName = "test";
	int n,m;
	long[][] a;
	long[] p;

	long P = 37;
	long geth(int s, int l, int r) {
		return (a[s][r]-a[s][l-1]*p[r-l+1]);
	}

	class Sq implements Comparable<Sq>{
		int pos;
		long h;
		public Sq(long hh, int pp) {
			pos = pp; h = hh;
		}
		public int compareTo(Sq o) {
			if (h<o.h) return -1;
			if (h>o.h) return 1;
			return 0;
		}
		
	}
	void solve() throws IOException {
		
		
		
		 /* out = new PrintWriter(new File("output.txt"));
		  n = 500;
		  Random Rnd = new Random(23412);
		  for (int i=0; i<n; i++) {
			  for (int j=0; j<n; j++) out.print((char)('a'+Rnd.nextInt(1000000)%26));
			  out.println();
		  }
		  out.close(); 
		  if (1==1) return; */ 
		  n = nextInt();
		  m = nextInt();		
		  p = new long[m+1];
		  p[0] = 1;
		  for (int i=1; i<=m; i++) p[i] = p[i-1]*P; 
		  a = new long[n][m+1];
		  for (int i=0; i<n; i++) {
			  String s = next();		  
			  a[i][1] = s.charAt(0)-'a'+1;
			  for (int j=2; j<=m; j++)
				  a[i][j] = (a[i][j-1]*P+s.charAt(j-1)-'a'+1);
		  }
		  
		  int sz = n*m;
		  Sq[] map = new Sq[sz];
		  int p1 = -1, p2 = -1; 
		  int L = 0, R = Math.min(n, m);
		  while (L<R) {
			  int cnt = 0;
			  int k = (L+R+1)/2;
			  long PP = p[k];
//			  System.out.println(PP);
			  int l = 1, r = k;
			  
			  boolean ok = false;
			  while (r<=m && !ok) {
				  long h = geth(0,l,r), d = 1;
				  for (int i=1; i<k; i++) {
					  h = (h*PP+geth(i,l,r));
					  d = (d*PP);
				  }
				  for (int i=k; i<=n; i++) {
					  if (map[cnt]==null)  map[cnt++] = new Sq(h,(i-k)*m+l-1); else {
						  map[cnt].h = h;
						  map[cnt].pos = (i-k)*m+l-1;
						  cnt++;
					  }
					  if (i<n) h = ((h-geth(i-k,l,r)*d)*PP+geth(i,l,r));
				  }
				  l++; r++;
			  }
			  Arrays.sort(map, 0, cnt);
			  for (int i=1; i<cnt; i++)
				  if (map[i].h == map[i-1].h) {
					  p1 = map[i].pos;
					  p2 = map[i-1].pos;
					  ok = true;
					  break;
				  }
			 
			  if (ok) L = k; else R = k-1; 	  
		  }
		  if (R<1) {
			  out.println(0);
			  out.close();
			  return;
		  }
		  out.println(R);
		//  out.println(p1);
		//  out.println(p2);
		  out.println((p1/(m)+1)+" "+(p1%(m)+1));
		  out.println((p2/(m)+1)+" "+(p2%(m)+1));
		  
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
