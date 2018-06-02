import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main {   
BufferedReader br;
Scanner in;   
PrintWriter out;
StreamTokenizer stt;
int inf = 1000000000;
class Heap {
	int inf = 1000000000;

	int[] a, pos, d;

	int sz;

	Heap(int n) {
		sz = n;
		a = new int[n + 1];
		pos = new int[n + 1];
		d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = i;
			pos[i] = i;
			d[i] = inf;
		}
	}

	public int extMin() {
		int res = a[1];
		int q;
		a[1] = a[sz];
		pos[a[1]] = 1;
		sz--;
		int v = 1;
		int u = 2;
		while (u <= sz) {
			if (u < sz && d[a[u + 1]] < d[a[u]])
				u++;
			if (d[a[u]] < d[a[v]]) {
				q = a[v];
				a[v] = a[u];
				a[u] = q;
				pos[a[v]] = v;
				pos[a[u]] = u;
			} else
				break;
			v = u;
			u *= 2;
		}
		return res;
	}

	public void decKey(int v, int K) {
		d[v] = K;
		v = pos[v];
		int k = v / 2;
		int q;
		while (k > 0)
			if (d[a[v]] < d[a[k]]) {
				q = a[k];
				a[k] = a[v];
				a[v] = q;
				pos[a[k]] = k;
				pos[a[v]] = v;
				v = k;
				k /= 2;
			} else
				return;
	}
}
public static void main(String[] args) throws IOException {	
	new Main().run();
}


int nextInt() throws IOException {
	stt.nextToken();
	return (int) stt.nval;
}

String nextS() throws IOException {
	stt.nextToken();
	return stt.sval;
}

class Road {
	int x,h,c,t,id;
	Road(int xx, int hh, int cc, int tt, int idd) { x = xx; h = hh; c = cc; t = tt; id = idd; }
}
class Road2 {
	int x,y,c;
	Road2(int xx, int yy, int cc) { x = xx; y = yy; c = cc; }
}
Vector<Road>[] a;
int[][] pr;
int n,money,maxtime;
int s,t;


int Dijkstra(int height) {
	  int N = n*n+n+10;
	  Heap H = new Heap(N);
	  boolean[] f = new boolean[N];
	  int p = s, paid = 0;
	  H.decKey(p*n+paid, 0);	 
	  while (true) {	
		  int V = H.extMin();
		  if (H.d[V]==inf) return -1;
		  f[V] = true;
		  p = V/n; paid = V%n;		  
		  if (p==t && paid<=money && H.d[V]<=maxtime) return V;	
		  int cur = H.d[V];
		  for (Road r:a[p]) {
			  int U = paid+r.c;
			  if (U>money) continue;
			  U += r.x*n;
			  if (r.h<=height && !f[U]) {				
				  if (H.d[U] > cur+r.t) {
					  H.decKey(U, cur+r.t);					 
					  pr[r.x][paid+r.c] = r.id;
				  }
			  }
		  }
			  
	  }	  
}

public void run()throws IOException {
  br = new BufferedReader(new InputStreamReader(System.in));
  stt = new StreamTokenizer(br);
  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); 
  n = nextInt();

  int m = nextInt();
  s = nextInt();
  t = nextInt();
  money = Math.min(n-1,nextInt());
  maxtime = nextInt();
  a = new Vector[n+1];
  Road2[] RR = new Road2[m+1]; 
  pr = new int[n+1][n+1];
  for (int i=1; i<=n; i++) a[i] = new Vector<Road>();
  for (int i=1; i<=m; i++) {
	  int x = nextInt(), y = nextInt();
	  int c = nextInt(), time = nextInt(), h = nextInt();
	  a[x].add(new Road(y,h,c,time,i));
	 // a[y].add(new Road(x,h,c,time,i));	  
	  RR[i] = new Road2(x,y,c);
  }
  if (s==t) {
	  out.println(0);
	  out.println(0);
	  out.flush();
	  System.exit(0);
  }
  int L = 0, R = 1000000;
/*  if (!Dijkstra(R)) {
	  out.print(-1);
	  out.flush();
	  System.exit(0);
  }  */

  while (L<R) {
	  int height = (L+R)/2;	 
	  if (Dijkstra(height)>=0) R = height; else L = height+1;	 
  }
  int V = Dijkstra(R);
  if (V>=0) {
	  out.println(R);
	  Stack<Integer> st = new Stack<Integer>();
	  int p = t, paid = V%n;	 
	  while (p!=s || paid>0) {
		  int id = pr[p][paid];
		  st.push(id);
		  paid -= RR[id].c;
		  if (p==RR[id].x) p = RR[id].y; else p = RR[id].x; 
	  }
	  out.println(st.size());
	  while (!st.isEmpty()) out.print(st.pop()+" ");
  } else out.print(-1); 
  out.flush(); 
}   
}
