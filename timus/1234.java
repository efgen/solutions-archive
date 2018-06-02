import java.io.*;
import java.util.*;

public class Main implements Runnable {
	void solve() throws IOException	{
		double[] a = new double[3], b = new double[2];  
		a[0] = nextInt(); a[1] = nextInt(); a[2] = nextInt();  
		b[0] = nextInt(); b[1] = nextInt();  
		Arrays.sort(a);
		Arrays.sort(b);
		double ho = a[0], wo = a[1], hk = b[0], wk = b[1], t;  
		if (ho > hk)  
			out.print("NO");  
		else  
			if (ho <= hk && wo <= wk)  
				out.print("YES");  
		else {  
			double acSq, cf, BAF, ge;  
			acSq = wo * wo + ho * ho;  
			cf = Math.sqrt(acSq - hk * hk);  
			BAF = Math.atan2(ho, wo) + Math.atan2(cf, hk);  
			ge = ho * Math.cos(BAF) + wo * Math.sin(BAF);  
			if (ge < wk + 1e-8)  
				out.print("YES");  
			else  
				out.print("NO");  
		}  
	
	}
	
	
	StreamTokenizer in;
	PrintWriter out;
	double nextInt() throws IOException {
		in.nextToken();
		return in.nval;
	}
	public void run(){
		try
		{
			in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}

