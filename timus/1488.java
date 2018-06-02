import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	// static final String FileName = "test";
	class Card implements Comparable<Card> {
        int x, y;
        public Card(String s) {
                char c = s.charAt(0);
                if (c>='2' && c<='9') x = c-'0';
                if (c=='1') x = 10;
                if (c=='J') x = 11;
                if (c=='Q') x = 12;
                if (c=='K') x = 13;
                if (c=='A') x = 14;
                if (x==10) c = s.charAt(2); else  c = s.charAt(1);
                if (c=='S') y = 0;
                if (c=='C') y = 1;
                if (c=='H') y = 2;
                if (c=='D') y = 3;
        }
        public Card clone() {
                return new Card(x, y);
        }
        public Card(int xx, int yy) {
                x = xx; y = yy;
        }
        
        public int compareTo(Card o) {
                if (x==o.x) return y-o.y;
                return x-o.x;
        }
        public String toString() {
                return x+" "+y;
        }
	}
	  int val(Card[] src) {
          Card[] a = src.clone();
          Arrays.sort(a);
          boolean f = true;       
          for (int i=0; i<a.length; i++) f &= a[i].y == a[0].y;   
          
          boolean s = true;
          for (int i=0; i<a.length; i++) s &= a[i].x==a[0].x+i;
        
          boolean t = a[0].x==a[1].x && a[0].x==a[2].x;
          
          if (t && a[0].x==3) return inf;
          if (s && f) return 15*15*15*6+a[0].x;
          if (t) return 15*15*15*5+a[0].x;
          if (s) return 15*15*15*4+a[0].x;
          if (f) {
        	  return 15*15*15*2 + ((a[2].x*15)+a[1].x)*15+a[0].x;
          }
          if (a[0].x==a[1].x) {
        	  return 15*15*15 + a[0].x*15+a[2].x;
          }
          if (a[1].x==a[2].x) {
        	  return 15*15*15 + a[1].x*15+a[0].x;
          }
          return ((a[2].x*15)+a[1].x)*15+a[0].x;       
	  }
	  
	   int maxval(Card[] a1, Card[] a2, TreeSet<Card> t) {
           int res = 0;
           Card[] all = new Card[5];
           for (int i=0; i<3; i++) all[i] = a1[i];
           for (int i=0; i<2; i++) all[i+3] = a2[i];
           Card[] a = new Card[3];
           for (int i=0; i<5; i++)
                   for (int j=i+1; j<5; j++) {
                           int cnt = 0;
                           for (int k=0; k<5; k++)
                                   if (k!=i && k!=j)
                                           a[cnt++] = all[k];
                           boolean ok = true;
                           for (int k=0; k<3; k++) if (t.contains(a[k])) ok = false;
                           if (!ok) continue;
                           if (a[0].compareTo(a[1])==0 || a[0].compareTo(a[2])==0 || a[2].compareTo(a[1])==0) continue;
                           res = Math.max(res, val(a));
                   }
           return res;
   }
  

	void solve() throws IOException {
		while (true) {
			String fc = next();
			if (fc==null) break;
			Card[] a = new Card[3];
			Card[] b = new Card[3];
			Card[] c = new Card[2];
			a[0] = new Card(fc);
			a[1] = new Card(next());
			a[2] = new Card(next());
			for (int i=0; i<3; i++) b[i] = new Card(next());
			for (int i=0; i<2; i++) c[i] = new Card(next());
			int v1 = val(a);
			TreeSet<Card> t = new TreeSet<Card>();
			for (Card cc:a) t.add(cc);
			int v2 = maxval(b, c, t);
			if (v1<v2) out.println("Dima");
			if (v1>v2) out.println("Sasha");
			if (v1==v2) out.println("Artyom");
		//	out.println(v1+" "+v2);
		}
	}	

	static final int inf = 1000000000;
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	
	public void run() {
		try {
			// br = new BufferedReader(new FileReader(FileName+".in"));
			// out = new PrintWriter(FileName+".out");
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
		new Task().run();
	
	}
}



