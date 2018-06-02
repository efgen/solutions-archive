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
static double nextInt() {
	try {
		inST.nextToken();
	} 
	catch (IOException e) {}
	return inST.nval;
}
static String nextS() {
	try {
		return br.readLine();
	}
	catch (IOException e) {}
	return null;
}

int maxn = 111;
int[][] a = new int[maxn][50];
int[] link = new int[maxn];
boolean[] end = new boolean[maxn];
int sz = 0;
int go(int p, int c) {
	if (a[p][c]<0) {
		sz++;
		Arrays.fill(a[sz], -1);
		a[p][c] = sz;
	}
	return a[p][c];
}
public void run() {
	Arrays.fill(a[sz], -1);
	int n = in.nextInt();
	int m = in.nextInt();
	int K = in.nextInt();
	in.nextLine();
	String let = in.nextLine();
	//construct bor
	while (K-->0) {
		String s = in.nextLine();
		int p = 0;
		for (char C:s.toCharArray()) 			
			p = go(p,let.indexOf(C));
		end[p] = true;
	}
	//construct dfa
	Queue<Integer> Q = new LinkedList<Integer>();
	for (int c=0; c<n; c++) 
		if (a[0][c]<0) 
			a[0][c] = 0; 
		else
			Q.add(a[0][c]);
	while (!Q.isEmpty()) {
		int u = Q.poll();
		for (int c=0; c<n; c++)
			if (a[u][c]>=0) {
				int v = a[u][c];
				Q.add(v);
				int fp = link[u];
				while (a[fp][c]<0) fp = link[fp];
				link[v] = a[fp][c];
				end[v] |= end[link[v]];
			}
	}
	
	//upgrade dfa
	for (int i=0; i<=sz; i++) {
		for (int c=0; c<n; c++) {
			int p = i;
			while (a[p][c]<0) p = link[p];
			a[i][c] = a[p][c];
		}		
	}
	//dp
	BigInteger[] A = new BigInteger[sz+1];
	for (int i=0; i<=sz; i++) A[i] = BigInteger.ZERO; A[0] = BigInteger.ONE;
	while (m-->0) {
		BigInteger[] B = new BigInteger[sz+1];
		for (int i=0; i<=sz; i++) B[i] = BigInteger.ZERO;
		for (int p=0; p<=sz; p++)
			if (A[p].compareTo(BigInteger.ZERO)>0)
				for (int c=0; c<n; c++) {
					int v = a[p][c];
					if (!end[v])
						B[v] = B[v].add(A[p]);
				}
		for (int p=0; p<=sz; p++) A[p] = B[p];
	}
	BigInteger res = BigInteger.ZERO;
	for (BigInteger x:A) res = res.add(x);
	out.println(res);
	out.flush();
}
}


