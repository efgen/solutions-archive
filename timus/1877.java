import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
	int read() throws IOException {
		char[] s = br.readLine().toCharArray();
		int res  = 0;
		for (char c:s) res = res*10+c-'0';
		return res;
	}
	void solve() throws IOException {
		int x = read();
		int y = read();
		if (x%2==1 && y%2==0) out.println("no"); else out.println("yes");
		
		

		
 	}
	

	
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			// br = new BufferedReader(new FileReader("input.txt"));
			// out = new PrintWriter("output.txt");
			solve();
			br.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(123);
		}
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s,", \t");
		}
		return st.nextToken();
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}
}
