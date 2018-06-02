import java.awt.Point;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable{
static BufferedReader br;
static Scanner in;
static StreamTokenizer inST;
static PrintWriter out;

public static void main(String[] args) throws IOException {
	br = new BufferedReader(new InputStreamReader(System.in));
	in = new Scanner(br);
	inST = new StreamTokenizer(br);
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	new Thread(new Main()).start();
}
static int nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return (int)inST.nval;
}

int n,m;
boolean[][] a;
int[][] d;
int[] dx = {1,-1,0,0};
int[] dy = {0,0,1,-1};
class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x+" "+y;
	}
}
public void run() {
	try {
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0].trim());
		n = Integer.parseInt(s[1].trim());		
	} catch (IOException e) {		
		e.printStackTrace();
	}
	a = new boolean[n][m];
	for (int i=0; i<n; i++) {
		try {
			String s = br.readLine();
			for (int j=0; j<m; j++)
				a[i][j] = s.charAt(j)=='.';			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	d = new int[n][m];
	Queue<Point> Q = new LinkedList<Point>();
	
	boolean f = true;
	for (int i=0;i<n && f; i++)
		for (int j=0; j<m; j++)
			if (a[i][j]) {
				Q.offer(new Point(i,j));
				f = false;
				break;
			}
	
	int res = 0;
	if (!f) {
		//out.println("bfs1"); out.flush();
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++)
				d[i][j] = -1;
		d[Q.peek().x][Q.peek().y] = 0;
		Point last = null;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			last = p;
			int dist = d[p.x][p.y];
			for (int dir = 0; dir<4; dir++) {
				int x = p.x+dx[dir];
				int y = p.y+dy[dir];
				if (x<0 || y<0 || x==n || y == m || d[x][y]>=0 || !a[x][y]) continue;
				Q.offer(new Point(x,y));
				d[x][y] = dist+1; 
			}			
		}
		//out.println("bfs2"+last); out.flush();
		Q.offer(last);
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++)
				d[i][j] = -1;
		d[Q.peek().x][Q.peek().y] = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			last = p;
			int dist = d[p.x][p.y];
			for (int dir = 0; dir<4; dir++) {
				int x = p.x+dx[dir];
				int y = p.y+dy[dir];
				if (x<0 || y<0 || x==n || y == m || d[x][y]>=0 || !a[x][y]) continue;
				Q.offer(new Point(x,y));
				d[x][y] = dist+1; 
			}			
		}
		res = d[last.x][last.y];		
	}
	out.print(res);
	out.flush();
}
}


