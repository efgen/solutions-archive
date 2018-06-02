import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
	
	void solve() throws IOException {
		int alf = nextInt();
		int n = nextInt();
		int[] a = new int[n];
		int sz = 0;
		for (int x=1; x<=n; x++)
			if (n%x==0)
				a[sz++] = x;
		HashMap<Integer, BigInteger> map = new HashMap<Integer, BigInteger>();
		
		for (int i=0; i<sz; i++) {
			int x = a[i];
			map.put(x, BigInteger.ZERO);
			BigInteger ans = BigInteger.valueOf(alf).pow(x);
			int p = 1;
			for (p=1; p*p<x; p++)
				if (x%p==0) ans = ans.subtract(map.get(p).multiply(BigInteger.valueOf(p))).subtract(map.get(x/p).multiply(BigInteger.valueOf(x/p)));
			if (p>1 && p*p==x) ans = ans.subtract(map.get(p).multiply(BigInteger.valueOf(p)));
			ans = ans.divide(BigInteger.valueOf(x));
			map.put(x, ans);
		}
		out.println(map.get(n));
		
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
