import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}

int[] dx = {0,-1,-1,-1,0,1,1,1};
int[] dy = {1,1,0,-1,-1,-1,0,1};
long inf = 0;
int[] a,p;
long[] d;
int sz;

void decKey(int v,long K) {
	d[v] = K;
	v = p[v];	
	int k = v/2;
	int q;
	while (k>0) 
		if (d[a[v]]<d[a[k]]) {
			q = a[k]; a[k] = a[v]; a[v] = q;
			p[a[k]] = k; p[a[v]] = v;		
			v = k; k /= 2;
		} else return;	
}
int extMin() {
	int res = a[1];
	int q;
	a[1] = a[sz];
	p[a[1]] = 1;
	sz--;
	int k = 1;
	int v = 2;
	while (true) {		
		if (v>sz) return res; else
			if (v<sz && d[a[v+1]]<d[a[v]]) v++;
		if (d[a[v]]<d[a[k]]) {
			q = a[k]; a[k] = a[v]; a[v] = q;
			p[a[k]] = k; p[a[v]] = v;				
		} else return res;
		k = v;
		v *= 2;		
	}		
}

public void run() throws IOException {
  in = (new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);  
  StringTokenizer st;
  st = new StringTokenizer(in.readLine());  
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
  st = new StringTokenizer(in.readLine());
  int bx = Integer.parseInt(st.nextToken());
  int by = Integer.parseInt(st.nextToken());
  st = new StringTokenizer(in.readLine());
  int ex = Integer.parseInt(st.nextToken());
  int ey = Integer.parseInt(st.nextToken());
  if (bx==ex && by==ey) {
	  out.print("1 0");
	  out.close();
	  return;
  }
  long KK = 1L+n*m;
  inf = KK*KK+1;
  sz = n*m;
  int[][] g = new int[n+2][m+2];
  int bv = (bx-1)*m+by;
  int ev = (ex-1)*m+ey;
 

  for (int i=1; i<=n; i++) {
	  String s = in.readLine();
	  for (int j=1; j<=m; j++)
		  g[i][j] = s.charAt(j-1)-'0';
  }
  d = new long[sz+1];
  a = new int[sz+1];
  p = new int[sz+1]; 
  for (int i=1; i<=sz; i++) {
	  d[i] = inf;
	  a[i] = i;
	  p[i] = i;
  }
  decKey(bv,1L);
  while (sz>0) {
	  int v = extMin();	  
	  if (d[v]==inf) break;
	  int px = (v-1)/m+1;
	  int py = (v-1)%m+1;
	  int c = g[px][py];
	  for (int i=0; i<8; i++) {
		  int x = px+dx[i];
		  int y = py+dy[i];
		  long D = d[v];		 
		  if (g[x][y]==0) continue; else 
			  if (g[x][y]!=c) D += KK;
		  D++;
		  int u = (x-1)*m+y; 
		  if (d[u]>D) decKey(u,D);	 	  
	  }	
  }

  if (d[ev]<inf) 
	  out.println(d[ev]%KK+" "+d[ev]/KK); 
  else
	  out.println("0 0");
  out.close(); 
}

}

