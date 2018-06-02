import java.io.*;
import java.util.*;

public class Sum implements Runnable
{
	void solve() throws IOException	{
		int n = nextInt();
		int res = 0;
		int h = 1;
		int x1 = 0, x2 = 10;
		for (int k=1; k<=n; k++) {
			nextInt();
			int y1 = nextInt();
			if (k==n) res += nextInt()-2; else nextInt();
			int y2 = nextInt();
			int t = 1000;
			int nh = -1;
			for (int x=x1+1; x<x2; x++)
				if (x>y1 && x<y2 && Math.abs(x-h)<t) {
				t = Math.abs(x-h);
				nh = x;
				}
				if (t==1000) {
					out.println(-1);
					return;
				}
				res += t;		
				x1 = y1; x2 = y2; h = nh;
				if (k==n) res += y2-1-h;
		}
		out.println(res);
	}

	StreamTokenizer in;
	PrintWriter out;

	int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
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
		new Thread(new Sum()).start();
	}
}
