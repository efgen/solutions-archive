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

int[][] C;
String s;
void intitC() {
	int n = 35;
	C = new int[n][n];
	C[0][0] = 1;
	for (int i=1; i<n; i++) {
		C[i][0] = 1;
		for (int j=1; j<n; j++)
			C[i][j] = C[i-1][j]+C[i-1][j-1];
	}
}
void show() {
	int n = 10;
	for (int i=0; i<=n; i++) {
		for (int j=0; j<=n; j++)
			out.print(C[i][j]+" ");
		out.println();
	}
}
int f(int p, int k) {
	if (k==0) return 1;
	if (p==s.length()) {
		if (k==0) return 1; else return 0;
	}
	if (s.charAt(p)=='0') return f(p+1,k); else
		if (s.charAt(p)=='1') return f(p+1,k-1)+C[s.length()-p-1][k]; else
			return C[s.length()-p][k];
}
public void run() {
	intitC();
//	show();
	int x = in.nextInt();
	int y = in.nextInt();
	int k = in.nextInt();
	int b = in.nextInt();
	if (y>x) {
		int q = x; x = y; y = q;
	}
	s = Integer.toString(x, b);
	int r1 = f(0,k);
	s = Integer.toString(y-1,b);
	int r2 = f(0,k);
	out.print(r1-r2);	
	out.flush();
}
}


