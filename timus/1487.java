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

static String nextS() {
	try {
		return br.readLine();
	} 
	catch (IOException e) {}
	return null;
}


public void run() {
	int n = Integer.parseInt(nextS());
	int sz = n/32;
	if (n%32>0) sz++;
	int[][] a = new int[n][sz];
	for (int i=0; i<n; i++) {	
		String s = nextS();		
		for (int j=0; j<n; j++) {			
			if (s.charAt(j)=='1') 
				a[j][i/32] |= 1L<<(i%32);			
		}		
	}
	for (int k=0; k<n; k++)
		for (int i=0; i<n; i++)
			if ((a[i][k/32] & (1L<<(k%32)))!=0) {
				for (int j=0; j<sz; j++)
					a[i][j] |= a[k][j];
			}
	int q = Integer.parseInt(nextS());
	while (q-->0) {
		String[] s = nextS().split(" ");
		int x = Integer.parseInt(s[0])-1;
		int y = Integer.parseInt(s[1])-1;
		boolean f = false;
		for (int i=0; !f && i<sz; i++)
			f = (a[x][i]&a[y][i])!=0;			
		if (f) out.println("No"); else out.println("YES");
	}
	out.flush();
}
}


