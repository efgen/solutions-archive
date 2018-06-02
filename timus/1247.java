import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	void exit(int x) {
		if (x==0) out.println("NO"); else out.println("YES");
		out.close();
		System.exit(0);
	}
	void solve() throws IOException	{
		int n = nextInt();
		int s = nextInt();
		int k = 0;
		int sum = 0;
		while (n-->0) {
			int x = nextInt(); k++;
			if (x>0) {
				sum += x;				
				if (sum>k+s) exit(0);
			} else {
				if (sum<k) {
					sum = 0;
					k = 0;
				}
			}
		
		}
		if (sum>k+s) exit(0); else exit(1);
		
	}


	StreamTokenizer in;
	//Scanner in;
	PrintWriter out;

	int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	public void run(){
		try {
			in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			//in = new Scanner(System.in);
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		} catch (IOException e){throw new IllegalStateException(e);}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}