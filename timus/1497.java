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
	try {
		solveTask();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	out.flush();
}
void solveTask() throws IOException{
	int n = Integer.parseInt(br.readLine());
	boolean[][] a = new boolean[n+2][n+2];
	int[][] d = new int[n+2][n+2];
	for (int i=1; i<=n; i++) {
		String s = br.readLine();
		for (int j=0; j<n; j++)
			a[i][j+1] = s.charAt(j)=='1';
	}
	for (int i=0; i<=n+1; i++) {
		d[0][i] = 15^2;
		d[n+1][i] = 15^8;
		d[i][0] = 15^1;
		d[i][n+1] = 15^4;		
	}
	d[0][0] = d[0][n+1] = d[n+1][0] = d[n+1][n+1] = 15;
	for (int i=1; i<=n; i++)
		for (int j=1; j<=n; j++)
			if (!a[i][j]) {			
				if ((d[i][j-1]&4)>0) d[i][j] += 4;
				if ((d[i-1][j]&8)>0) d[i][j] += 8;
			}
	for (int i=n; i>0; i--)
		for (int j=n; j>0; j--)
			if (!a[i][j]) {
				if ((d[i][j+1]&1)>0) d[i][j] += 1;
				if ((d[i+1][j]&2)>0) d[i][j] += 2;			
			}
	boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true;
	for (int i=1; i<=n; i++) 
		for (int j=1; j<=n; j++)
			if (!a[i][j]) {
				ok1 &= (d[i][j]&1)>0;
				ok2 &= (d[i][j]&2)>0;
				ok3 &= (d[i][j]&4)>0;
				ok4 &= (d[i][j]&8)>0;				
			}
	if (ok1 || ok2 || ok3 || ok4) out.print("Yes"); else out.print("No");	
	
}
}


