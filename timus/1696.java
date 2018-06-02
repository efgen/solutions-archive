import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	// static final String FileName = "test";


	void solve() throws IOException {
		int n = nextInt();
		int k = nextInt();
		int p = nextInt();
		int sz = 256;
		int[] a = new int[sz*sz];		
		int[] addi = new int[k];
		int[] addj = new int[k];
		int res = 1;
		while (n-->0) {
			Arrays.fill(addi, 0);
			Arrays.fill(addj, 0);
			addi[k-1] = 1;
			for (int i=k-1; i>=0; --i) {
				for (int j=i-1; j>=0; --j) {
					int x = a[(i<<8)|j];
					addi[i] += x;
					if (addi[i]>=p) addi[i] -= p;
					addj[j] += x;
					if (addj[j]>=p) addj[j] -= p;
					
					x = addi[i]+addj[j];
					if (x>=p) x -= p;
					a[(i<<8)|j] = x;
					
				}
			}			
			
		}
		for (int i=0; i<k; i++)
			for (int j=0; j<i; j++) {
				res += a[(i<<8)|j];
				if (res>=p) res -= p;
			}
		out.println(res+1);
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



