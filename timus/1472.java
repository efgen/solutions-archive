import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable{
static BufferedReader br;
static Scanner in;
static StreamTokenizer inST;
static PrintWriter out;

public static void main(String[] args) {	
	new Thread(new Main()).start();
}
static int nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return (int)inST.nval;
}
static String nextS() {
	try {
		return br.readLine();
	}
	catch (IOException e) {}
	return null;
}

public void run() {
	br = new BufferedReader(new InputStreamReader(System.in));
	in = new Scanner(br);
	inST = new StreamTokenizer(br);
	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	solveTask();
	out.flush();
}
int n;
class Rib {
	int x, v;
	Rib(int xx, int cc) { x = xx; v = cc; }
}
Vector<Rib>[] a;
int calc(int v) {
	int res = 0;
	if (a[v].size()==0) return -1;
	for (Rib r:a[v]) {
		res += r.v;
		int x = calc(r.x);
		if (x>=0 && x<r.v) res += x-r.v;
	}
	return res;
}
void solveTask() {
	int n = nextInt();
	a = new Vector[n+1];
	for (int i=1; i<=n; i++) a[i] = new Vector<Rib>();
	for (int i=2; i<=n; i++) {
		int x = nextInt();
		a[x].add(new Rib(i,nextInt()));
	}	
	out.print(calc(1)+".00");	
	
}
}


