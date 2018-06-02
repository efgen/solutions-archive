import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	int inf = 1000000000;
	int n = 64*36;
	int[] d = new int[n];
	int[] p = new int[n];
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	int[][] per = {{0,4,2,5,3,1},{0,5,2,4,1,3},{3,0,1,2,4,5},{1,2,3,0,4,5}};
	int[] ves = new int[6];
	class Pos {
		int[] a = new int[6];
		int x,y;
		int code() {
			return (x*8+y)*36+a[0]*6+a[1];
		}
		int ves() {
			return ves[a[3]];
		}
		Pos(int v) {
			x = v/8;
			y = v%8;
		}
		Pos(int xx, int yy, int[] aa) {
			x = xx; y = yy;
			a = aa.clone();
		}
		Pos go(int i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (nx<0 || ny<0 || nx>7 || ny>7) return null;
			Pos p = new Pos(nx,ny,a);
			for (int j=0; j<6; j++) {
				p.a[j] = a[per[i][j]];
			}
			return p;
			
		}
		public String toString() {
			return ('a'+x)+""+y;
		}
	}
	void solve() throws IOException	{
		Pos beg = new Pos(next());
		int req = next();
		for (int i=0; i<6; i++) ves[i] = in.nextInt();		
		
		beg.a[0] = 0;
		beg.a[1] = 2;
		beg.a[2] = 1;
		beg.a[3] = 4;
		beg.a[4] = 5;
		beg.a[5] = 3;		
		
		
		Arrays.fill(d,inf);
		Arrays.fill(p,-1);
		Queue<Pos> Q = new LinkedList<Pos>(); Q.add(beg);
		d[beg.code()] = beg.ves();
		int k = 0;
		while (!Q.isEmpty()) {
			Pos P = Q.poll();			
			k++;
			for (int i=0; i<4; i++) {
				Pos PP = P.go(i);
				if (PP==null) continue;
				if (d[P.code()]+PP.ves()<d[PP.code()]) {
					d[PP.code()] = d[P.code()]+PP.ves();
					p[PP.code()] = P.code();
					Q.add(PP);				
				}
				
			}			
		}
		
		req *= 36;
		int res = req;
		for (int i=0; i<36; i++)
			if (d[req+i]<d[res]) res = req+i;
		out.print(d[res]);
		Stack<String> st = new Stack<String>();
		while (res>=0) {
			int xy = res/36;
			int x = xy/8, y = xy%8;
			st.push(((char)(x+'a'))+""+(y+1));
			res = p[res];
		}
		while (!st.isEmpty()) {
			out.print(" "+st.pop());
		}
	}

	//StreamTokenizer in;
	Scanner in;
	PrintWriter out;
	int next() {
		String s = in.next();
		return (s.charAt(0)-'a')*8+s.charAt(1)-'1';
	}
/*	int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}*/
	public void run(){
		try
		{
			//in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			in = new Scanner(System.in);
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}


