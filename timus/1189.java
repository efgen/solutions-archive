import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	TreeSet<Long> t = new TreeSet<Long>();
	void calc(long n, long suf, long d) {
		if (n<1) return;
		if (n%11<10) {		
			t.add((n/11*10+n%11)*d+suf);
		}
		
		if (n%2==1) return;
		long x = n%10/2;
		calc(n/10,suf+x*d,10*d);
		calc(n/10-1,suf+(x+5)*d,10*d);
	}
	void solve() throws IOException	{
		long n = in.nextInt();
		if (n<10) {
			out.println(0);
			return;
		}
		calc(n,0,1);
		out.println(t.size());
		for (long x:t) {
			String s = Long.valueOf(x).toString();
			int i = s.length();
			for (int d=1; d<=n && i>=0; d *= 10)	{
				long y = x/(10*d)*d+x%d;
				i--;
				if (x+y==n) {
					out.print(x);
					out.print(" + ");
					out.print(s.substring(0,i)+s.substring(i+1,s.length()));
					out.println(" = "+n);
					break;
				}
			}
		}
	
	}


	//StreamTokenizer in;
	Scanner in;
	PrintWriter out;

	/*int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}*/
	public void run(){
		
		try {
			//in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			in = new Scanner(System.in);
			in.useLocale(Locale.US);
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		} catch (IOException e){throw new IllegalStateException(e);}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}