import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	//static final String FileName = "test";
	double sq(double x) {
		return x*x;
	}
	void solve() throws IOException {
		int n = nextInt();
		char[] aa = next().toCharArray();
		char[] bb = next().toCharArray();
		boolean[] a = new boolean[n];
		boolean[] b = new boolean[n];
		for (int i=0; i<n; i++) a[i] = aa[i]=='1';
		for (int i=0; i<n; i++) b[i] = bb[i]=='1';
		int pos = n;
		for (int i=0; i<n; i++) if (a[i]&&b[i]) {
			pos = i;
			break;
		}
		pos--;
		while (pos>=0 && (b[pos] || a[pos])) pos--;
		if (pos<0) {
			Arrays.fill(b, false);
			pos = n-1;
			while (pos>=0 && a[pos]) a[pos--] = false;
			if (pos>=0) a[pos] = true;
		} else {
			b[pos] = true;
			for (int i=pos+1; i<n; i++) b[i] = false;
		}
		for (int i=0; i<n; i++) if (a[i]) out.print(1); else out.print(0);
		out.println();
		for (int i=0; i<n; i++) if (b[i]) out.print(1); else out.print(0);
		  
	}
	
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	
	public void run() {
		try {
			//br = new BufferedReader(new FileReader(FileName+".in"));
			//out = new PrintWriter(FileName+".out");
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
		new Main().run();
	}
}
