import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
    // static final String FileName = "test";
	long mod = 1000000000+7;
	int fi = 1000000000+5;
	long pow(long x, int p) {
		long a = 1, b = x;
		while (p>0) {
			if ((p&1)!=0) a = a*b%mod;
			b = b*b%mod;
			p >>= 1;
		}
		return a;
	}
	long inv(long x) {
		return pow(x, fi);
	}
	
    void solve() throws IOException {
    	int m = nextInt();
    	int n = nextInt();
    	int k = nextInt();
    	int l = nextInt();
    	int maxn = 100000;
    	long[] fact = new long[maxn+1]; fact[0] = 1;
    	for (int i=1; i<=maxn; i++) fact[i] = fact[i-1]*i%mod;
    	long mul = fact[n]*inv(fact[l]*fact[n-l]%mod)%mod;
    	mul = mul*(fact[m]*inv(fact[k]*fact[m-k]%mod)%mod)%mod;
    	m -= k;
    	n -= l;
    	if (m<n) {
    		int q = m; m = n; n = q;
    	}
    	long[] f = new long[n+1];
    	long cur = 0;
    	for (int i=1; i<=n; i++) {
    		cur = ((cur<<1)|1);
    		if (cur>=mod) cur -= mod;
    		f[i] = pow(cur, m);
    	}
    	long res = 0;
    	boolean z = true;
    	long fn = fact[n];
    	for (int i=n; i>0; --i, z = !z) {
    		if (z) 
    			res += f[i]*(fn*inv(fact[i]*fact[n-i]%mod)%mod);
    		else
    			res -= f[i]*(fn*inv(fact[i]*fact[n-i]%mod)%mod);
    		res %= mod;
    	}
    	if (n==0 || m==0) {
    		if (n==0 && m==0) res = 1; else res = 0;
    	}
    	res = (res+mod)%mod;
    	out.println(res*mul%mod);
            
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