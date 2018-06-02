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


public void run() {
	int n = in.nextInt();
	int[] a = new int[n];
	for (int i=0; i<n; i++) a[i] = in.nextInt();
	Arrays.sort(a);
	boolean[] f = new boolean[n];
	int res = 0;
	for (int i=0; i<n; i++)
		if (!f[i]) {
			res++;
			for (int j=i+1; j<n; j++)
				if (!f[j])
					if (a[j]==a[i]+1) {
						f[j] = true;
						break;
					}
		}
	out.print(res);
	out.flush();
}
}


