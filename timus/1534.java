import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	long val(long x) {
		if (x>0) return 3;
		if (x==0) return 1;
		return 0;
	}
	void solve() throws IOException	{
		long k = in.nextLong();
		long l = in.nextLong();
		long n = in.nextLong();
		long t = Math.min(k,n-1);
		long maxr = 3*t+n-1-t+val(k-t-l);		
		t = Math.min(l,n-1);
		long minr = n-1-t+val(k+t-l);		
		if (k + t - l == 1 && t >= 1) minr--;
		out.println(maxr+" "+minr);
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