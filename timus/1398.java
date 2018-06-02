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

public class Pos {
	int x,y,px,py;
	Pos(String s1, String s2) {
		x = s1.charAt(0)-'a';
		y = s1.charAt(1)-'1';
		px = s2.charAt(0)-'a';
		py = s2.charAt(1)-'1';
	}
	Pos(int xx, int yy, int pxx, int pyy) {
		x = xx; y = yy; px = pxx; py = pyy;
	}
	boolean rub() {
		return (Math.abs(x-px)==Math.abs(y-py));
	}
	
}
int[] dx = {1,1,-1,-1};
int[] dy = {1,-1,1,-1};
public void run() {
	Queue<Pos> Q = new LinkedList<Pos>(); 
	Q.offer(new Pos(in.nextLine(),in.nextLine()));
	int res = -1;
	while (!Q.isEmpty()) {
		Pos p = Q.poll();
		if (p.rub()) { res = 1; break;}
		if (p.py==0) continue;
		for (int dir = 0; dir<4; dir++)
			for (int t=1; t<8; t++) {
				int nx = p.x+t*dx[dir];
				int ny = p.y+t*dy[dir];
				if (nx<0 || ny<0 || nx==8 || ny==8) break;
				if ((nx==p.px+1||nx==p.px-1) && ny==p.py-1) break;
				if (nx==p.px && ny==p.py-1) 
					res = Math.max(res, 0); 
				else 
					Q.offer(new Pos(nx,ny,p.px,p.py-1));		
			}
	}
	if (res==1)
		out.print("WHITE"); 
	else
		if (res==0)
			out.print("DRAW");
		else
			out.print("BLACK");		
	out.flush();
}
}


