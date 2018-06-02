import java.io.*;         
import java.util.*;         
import java.math.*;         
        
public class Main implements Runnable  {   


StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}      
public void run()  {      
    try {      
//        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
 //       br = new BufferedReader(new FileReader("input.txt"));      
 //      out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);    	
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}
class Point {
	int x,y;
	Point (int xx, int yy) {
		x = xx; y = yy;
	}
}
char[][] map;
int n,m;
Vector<Point>[] a = new Vector[26];
int[][] bfs(Point v, boolean can) {
	int[][] d = new int[n+2][m+2];
	Queue<Point> q = new LinkedList<Point>();
	q.add(v);
	d[v.x][v.y] = 1;
	while (!q.isEmpty()) {
		v = q.poll();
		for (int i=-1; i<2; i++)
			for (int j=-1; j<2; j++) {
				Point x = new Point(v.x+i,v.y+j);
				if (map[x.x][x.y]=='#' || (map[x.x][x.y]=='*' && !can)) continue;
				if (d[x.x][x.y]==0) {
					d[x.x][x.y] = d[v.x][v.y]+1;
					q.add(x);
					if (Character.isLetter(map[x.x][x.y])) {
						int tt = map[x.x][x.y]-'A';
						for (Point xx:a[tt]) 
							if (d[xx.x][xx.y]==0) {
								d[xx.x][xx.y] = d[v.x][v.y]+1;
								q.add(xx);	
							}
					}
				}
			}
	}
	return d;
}
public void solve() throws IOException {
	String[] ss = br.readLine().split(" ");
	for (int i=0; i<26; i++) a[i] = new Vector<Point>();
	n = Integer.parseInt(ss[0]);
	m = Integer.parseInt(ss[1]);
	map = new char[n+2][m+2];
	Point D = new Point(0,0),A = new Point(0,0),S = new Point(0,0);
	for (int i=1; i<=n; i++) {
		String s = "#"+br.readLine()+"#";
		map[i] = s.toCharArray();
		int k = s.indexOf('*');
		if (k>0) S = new Point(i,k);
		k = s.indexOf('!');
		if (k>0) A = new Point(i,k);
		k = s.indexOf('$');
		if (k>0) D = new Point(i,k);
		for (int j=1; j<=m; j++)
			if (map[i][j]>='A' && map[i][j]<='Z') a[map[i][j]-'A'].add(new Point(i,j));
	}
	String s = "";
	for (int i=0; i<=m+1; i++) s += "#";
	map[0] = s.toCharArray();
	map[n+1] = s.toCharArray();
	int[][] DD = bfs(D,false);
	int[][] AA = bfs(A,false);
	int[][] SS = bfs(S,true);
	int res = inf;
	for (int i=1; i<=n; i++)
		for (int j=1; j<=m; j++)
			if (DD[i][j]>0 && AA[i][j]>0 && SS[i][j]>0) res = Math.min(res, Math.max(DD[i][j], AA[i][j])+SS[i][j]);
	if (res<inf) out.println(res-2); else out.println("Impossible");
	
	

}      
} 



















