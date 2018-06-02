import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	long mod = 1000000000+7;
	BigInteger MOD;
	class C {
		BigInteger k;
		long n, cur;
		public C(int nn) {
			n = nn;
			k = BigInteger.ONE;
			cur = 1;
		}
		int next() {			
			int res = (int) cur;
			cur = cur*(n-k.intValue()+1)%mod;
			cur = cur*k.modInverse(MOD).intValue()%mod;
			k = k.add(BigInteger.ONE);
			return res;
		}
	}
	long pow(long x, int n) {
		long a = 1, b = x;
		while (n>0) {
			if (n%2==1) a = a*b%mod;
			b = b*b%mod;
			n >>= 1;
		}
		return a;
	}
	long inv(int n) {
		return pow(n, (int)mod-2);
	}
	class Point {
		int n, k;
		public Point (int nn, int kk) {
			n = nn; k = kk;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + k;
			result = prime * result + n;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (k != other.k)
				return false;
			if (n != other.n)
				return false;
			return true;
		}
		private Main getOuterType() {
			return Main.this;
		}
	}
	HashMap<Point, Long> map = new HashMap<Point, Long>();
	long cnk(int n, int k) {
		if (k<0 || k>n) return 0;
		if (k>n/2) k = n-k;
		long res = 1;
		if (map.containsKey(new Point(n, k-1))) {
			res = map.get(new Point(n, k-1));
			res = res*(n-k+1)%mod*inv(k)%mod;
		} else 
		if (map.containsKey(new Point(n, k+1))) {
			res = map.get(new Point(n, k+1));
			res = res*(k+1)%mod*inv(n-k)%mod;
		}
		else {		
			for (int i=1; i<=k; i++) res = res*(n-i+1)%mod*inv(i)%mod;
		}
		map.put(new Point(n, k), res);
		return res;
	}
	void solve() throws IOException {
		MOD = BigInteger.valueOf(mod);
		int n = nextInt();
		int k = nextInt();
		
		
		long res = 0;
		for (int i=0; i<=n; i++) {
			res += (cnk(n,i)*pow(3, i) % mod) * (cnk(n*(n-2)/2,k-i)*pow(4,k-i)%mod);
			res %= mod;
		}
		long res2 = 0;
		for (int i=0; i<=n/2; i++) {
			res2 += (cnk(n/2, i)) * (cnk(n*(n-1)/2,k-i)*pow(2,k-i)%mod);
			res2 %= mod;
		}
		res = (res+2*(mod-res2))%mod;
		out.println(res);
		if (1==1)return;
		
		int sz = n;
		n = sz*sz/2;
		int m  = k;
		
		res = 0;
		
		C csz = new C(sz);
		C cnsz = new C(n-sz);
		for (int i=0; i<n-sz-m; i++) cnsz.next();
		
		for (int i=0; i<=Math.min(sz, m); i++)
			res = (res+csz.next()*cnsz.next()%mod*pow(3,i)%mod*pow(4,m-i)%mod)%mod;
		
		res2 = 0;
		//out.println(res);
		csz = new C(sz/2);
		cnsz = new C(n-sz/2);
		for (int i=0; i<n-sz/2-m; i++) cnsz.next();
		
		for (int i=0; i<=Math.min(sz/2, m); i++)
			res2 = (res2+csz.next()*cnsz.next()%mod*pow(2,m-i)%mod)%mod;
		res = (res-2*res2%mod+mod)%mod;
		//out.println(res2);
		out.println(res);
		
		
	}
	
	
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	
	void run() {
		try {
			//br = new BufferedReader(new FileReader("input.txt"));
			//out = new PrintWriter("output.txt");
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);			
			solve();
			br.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
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
