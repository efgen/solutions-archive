import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.util.regex.*;
public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;
Scanner in;
int inf = 1000000000;
long a1, a2, a3, a4, b1, b2, c;
class Point {
	int x, y;
	void next() {
		long h = a1*x*y+a2*x+a3*y+a4;
		if (h>b1) {
			h -= (h-b2+c-1)/c*c;
		}
		x = y;
		y = (int)h;
	}
}

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}

long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
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
    	//br = new BufferedReader(new InputStreamReader(System.in));
    	br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1")));
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();            
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}


public void solve() throws IOException {
	a1 = nextInt();
	a2 = nextInt();
	a3 = nextInt();
	a4 = nextInt();
	b1 = nextInt();
	b2 = nextInt();
	c = nextInt();
	Point p = new Point();
	p.x = nextInt();
	p.y = nextInt();
	Point start = new Point();
	start.x = p.x; start.y = p.y;
	int hz = 1000000;
	while (hz-->0) p.next();
	Point mem = new Point(); mem.x = p.x; mem.y = p.y;
	int per = 0;
	while (true) {
		p.next();
		per++;
		if (p.x==mem.x && p.y==mem.y) break;
	}
	//out.println(per);
	Point pp = new Point(); pp.x = start.x; pp.y = start.y;
	p.x = start.x; p.y = start.y;
	for (int i=0; i<per; i++) pp.next();
	int prd = 0;
	while (true) {
		prd++;
		if (p.x==pp.x && p.y==pp.y) break;
		p.next();
		pp.next();		
	}
	out.println(prd+" "+per);

}
}









