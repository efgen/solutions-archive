import java.awt.Point;
import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}   
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  //in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  String[] ss = br.readLine().split(" ");
  int m = Integer.parseInt(ss[0]);
  int n = Integer.parseInt(ss[1]);
  int[][] a = new int[n+2][m+2];
  int[][] d = new int[n+2][m+2];
  int[][] p = new int[n+2][m+2];
  int[] dx = {1,-1,0,0};
  int[] dy = {0,0,-1,1};
  for (int i=1; i<=n; i++) {
	  String s = br.readLine();
	  for (int j=1; j<=m; j++)
		  if (s.charAt(j-1)=='o') a[i][j] = 2; else 
			  if (s.charAt(j-1)=='#') a[i][j] = 1;
  }
  int Query = Integer.parseInt(br.readLine());
  for (int query=1; query<=Query; query++) {
	  int tt = Integer.parseInt(br.readLine());
	  int x = n, y = 0;
	  while (tt>0) {
		  y++;
		  if (y>m) {
			  y = 1;
			  x--;
		  }
		  if (a[x][y]==2) tt--;		  
	  }
	  for (int i=0; i<=n+1; i++) {
		  Arrays.fill(d[i], inf);
		  Arrays.fill(p[i], -1);
	  }
	//  out.println(x+" "+y);
	  int[] qx = new int[n*m];
	  int[] qy = new int[n*m];
	  int s = 0, t = 0; 
	  qx[0] = x; qy[0] = y;
	  d[x][y] = 0;
	  while (s<=t) {
		  x = qx[s]; y = qy[s]; s++;
		  for (int i=0; i<4; i++) {
			  int nx = x+dx[i];
			  int ny = y+dy[i];			 
			  if (a[nx][ny]==0) continue;
			  if (d[nx][ny]==inf) {
				  d[nx][ny] = d[x][y]+1;
				  t++; qx[t] = nx; qy[t] = ny;
				  for (int j=0; j<4; j++) 
					  if (d[nx+dx[j]][ny+dy[j]]==d[x][y]) {
						  if (p[nx+dx[j]][ny+dy[j]]==-1) p[nx][ny] = j; else p[nx][ny] = p[nx+dx[j]][ny+dy[j]];
						  break;
					  }
			  }
		  }
	  }	
	/*  for (int i=1; i<=n; i++) {
		  for (int j=1; j<=m; j++)
			  if (falsed[i][j]==inf) out.print("* "); else out.print(p[i][j]+" ");
		  out.println();
	  }*/
	  int[] res = new int[4];
	  for (int i=1; i<=n; i++)
		  for (int j=1; j<=m; j++)
			  if (a[i][j]==2 && p[i][j]>=0) res[p[i][j]]++;
	  out.printf("Experiment #%d: North: %d, South: %d, East: %d, West: %d\n", query,res[0],res[1],res[2],res[3]);
	 // for (int xx:res) out.print(xx+" "); out.println();
  }
  out.close();    
}   
  
}




