import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	

	void solve() throws IOException {
		int n = nextInt();
		TreeSet<Integer> t = new TreeSet<Integer>();
		TreeSet<Integer> t2 = new TreeSet<Integer>();
		for (int i=0; i<n; i++) t.add(nextInt());
		for (int k=0; k<2; k++) {
			n = nextInt();
			for (int i=0; i<n; i++) {
				int x = nextInt();
				if (t.contains(x)) t2.add(x);
			}
			t.clear(); t.addAll(t2); t2.clear();
		}
		out.println(t.size());
		
		
		

		
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
