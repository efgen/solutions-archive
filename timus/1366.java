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
	BigInteger a  = BigInteger.ONE;
	BigInteger b = BigInteger.ZERO;
	for (int i=2; i<=n; i++) {
		BigInteger r = BigInteger.valueOf(i-1).multiply(a.add(b));
		a = b;
		b = r;
	}
	out.print(b);	
	out.flush();
}
}


