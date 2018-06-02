import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}
int[][] a;
int n,m,ex,ey,K;
void dfs(int x, int y, int k) {
	if (x<=0 || y<=0 || x>n || y>m || a[x][y]!=-1) return;
	if (x==ex&&y==ey) return;
	a[x][y] = k; k++;
	if (k>K) return;
	dfs(x+1,y,k);
	dfs(x-1,y,k);
	dfs(x,y+1,k);
	dfs(x,y-1,k);
}
int r(int x, int y,int ex, int ey) {
	if (ex<=0 || ey<=0 || ex>n || ey>m) return - 1;
	if (a[x][y]<0) return -1;
	if (x==ex) {
		int d = Math.abs(y-ey)-1;
		if (a[x][y]+d<=K) return d+1;		
	} else 
	if (y==ey) {
		int d = Math.abs(x-ex)-1;
		if (a[x][y]+d<=K) return d+1;
	}
	return -1;	
}
int r2(int x, int y,int ex, int ey) {
	if (ex<=0 || ey<=0 || ex>n || ey>m) return - 1;
	if (a[x][y]<0) return -1;
	if (x==ex) {
		int d = Math.abs(y-ey);
		if (a[x][y]+d<=K) return d+1;		
	} else 
	if (y==ey) {
		int d = Math.abs(x-ex);
		if (a[x][y]+d<=K) return d+1;
	}
	return -1;	
}
class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
int[] dx = {0,0,1,-1};
int[] dy = {1,-1,0,0};
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  n = in.nextInt();
  m = in.nextInt();
  K = in.nextInt();
  int sx = in.nextInt();
  int sy = in.nextInt();
  ex = in.nextInt();
  ey = in.nextInt();  
  a = new int[n+2][m+2];
  for (int[] aa:a) Arrays.fill(aa, -1);
  Queue<Point> Q = new LinkedList<Point>(); Q.add(new Point(sx,sy)); a[sx][sy] = 0;
  while (!Q.isEmpty()) {
	  Point P = Q.poll();
	  for (int i=0; i<4; i++) {
		  int x = P.x+dx[i];
		  int y = P.y+dy[i];
		  if (x<=0 || y<=0 || x>n || y>m || a[x][y]!=-1) continue;;
		  if (x==ex&&y==ey) continue;
		  if (a[P.x][P.y]==K) continue;
		  Q.add(new Point(x,y));
		  a[x][y] = a[P.x][P.y]+1;
	  }
  }
  /*for (int i=1; i<=n; i++) {
	  for (int j=1; j<=m; j++)
		  out.print(a[i][j]+" ");
	  out.println();
  }*/
  int res = -1;
  for (int i=1; i<=n; i++)
	  res = Math.max(res, r(i,ey,ex,ey));

  for (int i=1; i<=m; i++)
	  res = Math.max(res, r(ex,i,ex,ey));
  
  for (int i=1; i<=n; i++) {
	  res = Math.max(res, r2(i,ey-1,ex,ey-1));
	  res = Math.max(res, r2(i,ey+1,ex,ey+1));
  }
  for (int i=1; i<=m; i++) {
	  res = Math.max(res, r2(ex-1,i,ex-1,ey));
	  res = Math.max(res, r2(ex+1,i,ex+1,ey));
  }
  
  if (res==-1) res = 0;
  out.print(res);
  in.close(); out.close();  
}
}
