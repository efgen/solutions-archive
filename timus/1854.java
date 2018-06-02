import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
	
	/*boolean is_prime(long n){
		Random R = new Random();
		BigInteger N = BigInteger.valueOf(n);
		BigInteger ex = N.subtract(BigInteger.ONE);
		for (int i=0; i<100; i++)
			if (!BigInteger.valueOf(R.nextLong()%n).modPow(ex, N).equals(BigInteger.ONE))
				return false;
		return true;
	}*/
	void solve() throws IOException {
		long n = nextLong();
		
		long res = 1;
		for (int x=3; x<1000000; x+=2) {
			int k = 0;
			while (n%x==0) {
				n /= x;
				k++;
			}
			while (k>1) {
				k -= 2;
				res *= x;
				res *= x;
			}
		}
		if (n>1) {
			long t = (long)Math.floor(Math.sqrt(n)+1e-8);
			if (t*t==n) res *= n;
		}
		out.println(res);
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
