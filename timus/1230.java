import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	// static final String FileName = "test";


	void solve() throws IOException {
		String A = "AB;=\"?C";
		String C = "'";
		String B = "?$(A,1,1)+$(A,4,1)+C+A+C+$(A,3,1)+$(A,7,1)+$(A,4,2)+C+$(A,5,1)+$(A,3,1)+$(A,2,1)+$(A,4,1)+C+B+C+$(A,3,1)+B";
		out.print("A='"+A+"'"+";C=\""+C+"\""+ ";B='"+B+"';"+B);
	}
	
	


	static final int inf = 1000000000;
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	
	public void run() {
		try {
			// br = new BufferedReader(new FileReader(FileName+".in"));
			// out = new PrintWriter(FileName+".out");
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//br = new BufferedReader(new FileReader("input.txt"));
			//out = new PrintWriter("output.txt");
			solve();
			br.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s);
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
		new Task().run();
	
	}
}



