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
int binS(int x, int n) {
	int res = 0;
	int p = 0, q = n-1;
	while (p<=q) {
		res++;
		int i = (p+q)/2;
		if (i==x) return res;
		if (x<i) q = i-1; else p = i+1;
	}
	return res;
}
public void run() {
	Vector<Integer> a = new Vector<Integer>();
	Vector<Integer> b = new Vector<Integer>();
	int x = in.nextInt();
	int L = in.nextInt();
	for (int n=x+1; n<=10000; n++) 
		if (binS(x,n)==L) {
			if (b.size()>0 && b.lastElement()==n-1) b.set(b.size()-1, n); else {
				a.add(n);
				b.add(n);
			}
		}
	out.println(a.size());
	for (int i=0; i<a.size(); i++)
		out.println(a.elementAt(i)+" "+b.elementAt(i));
	out.flush();
}
}


