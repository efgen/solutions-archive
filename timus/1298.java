import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

Scanner in;
PrintWriter out;
int[] dx = {1,1,2,2,-1,-1,-2,-2};
int[] dy = {2,-2,1,-1,2,-2,1,-1};
int[][] a;
int n;

public static void main(String[] args) throws IOException {
new Main().run();
}
int solv(int x, int y) {
	if (x<=0 || y<=0 || x>n || y>n) return 100;
	if (a[x][y]!=0) return 100;
	int res = 0;
	for (int i=0; i<8; i++) {
		int nx = x+dx[i];
		int ny = y+dy[i];
		if (nx<=0 || ny<=0 || nx>n || ny>n) continue;
		if (a[nx][ny]==0) res++;
	}
	return res;
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  n = in.nextInt();
  if (n<5) {
	  if (n==1) out.println("a1"); else out.println("IMPOSSIBLE");
	  in.close(); out.close();
	  return;
  }
  a = new int[n+1][n+1];
  int x = 1, y = 1;
  int k = 0;
  while (true) {
	  a[x][y] = ++k;
	  if (k>n*n) break;
	  char c = (char)('a'+x-1);
	  out.println(c+""+y);
	  int rx = 0, ry = 0, best = 100;
	  for (int i=0; i<8; i++) {
		  if (solv(x+dx[i],y+dy[i])<best) {
			  best = solv(x+dx[i],y+dy[i]);
			  rx = x+dx[i];
			  ry = y+dy[i];
		  }		  
	  }
	  x = rx; y = ry;	
  }
/*  for (int i=1; i<=n; i++) {
	  for (int j=1; j<=n; j++)
		  out.print(a[i][j]+" ");
	  out.println();
  }*/

  in.close(); out.close();
}

}