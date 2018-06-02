import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.util.regex.*;
public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;
Scanner in;
int inf = 1000000000;
class Point {
	int x, y;
	public Point(int xx, int yy) {
		x = xx; y = yy;
	}
	                      
}

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}

long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}

public void run()  {      
    try {          
    	//br = new BufferedReader(new InputStreamReader(System.in));
    	br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1")));
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();            
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}
long mod;

class Str {
	long n, pref, suf, res, str, N;
	boolean emp = true;
	Str conc(Str a) {
		if (emp) return a;
		Str res = new Str();
		
		long d = 0, pd = 1,  b = 1, st = 10;
		long pow = a.n;
		while (pow>0) {
			if (pow%2==1) {
				d = (d*st+b)%mod;
				pd = pd*st%mod;
			}
			b = b*(st+1)%mod;
			st = st*st%mod;
			pow >>= 1;
		}
		d = d*10%mod;
		
		res.pref = (pref+a.pref+str*d)%mod;
		res.suf = (a.suf+a.str*N+suf*pd)%mod;
		res.res = (this.res+a.res+a.pref*N+suf*d)%mod;
		res.n = n+a.n;
		res.N = res.n%mod;
		res.str = (str*pd+a.str)%mod;
		res.emp = false;
		return res;
	}
	Str poww(Str x, long n) {
		Str a = new Str();
		Str b = x;
		while (n>0) {
			if (n%2==1) a = a.conc(b);
			b = b.conc(b);
			n >>= 1;
		}
		return a;
	}
}
long dummy(String str, int cnt) {
	String ss = "";
	while (cnt-->0)  ss += str;
	char[] s = ss.toCharArray();
	int n = s.length;
	for (int i=0; i<n; i++) s[i] -= '0';
	long res = 0;
	for (int i=0; i<n; i++)
		for (int j=i; j<n; j++) {
			long x = 0;
			for (int k=i; k<=j; k++) {
				x = (10*x+s[k])%mod;
			}
			res = (res+x)%mod;
		}
	return res;
}
public void solve() throws IOException {
	char[] s = br.readLine().toCharArray();
	
	int k = nextInt();
	mod = nextInt();
	Str x = new Str();
	int n = s.length;
	x.n = n;
	long d = 1;
	long sum = 0;
	for (int i=0; i<s.length; i++) s[i] -= '0';
	for (int i=0; i<n; i++) {
		sum += s[i];
		x.str = (x.str*10+s[i])%mod;
		x.pref = (x.pref+x.str)%mod;
	}
	long val = 0;
	long ans = sum;
	for (int i=n-1; i>=0; --i) {
		x.res = (x.res+ans)%mod;
		val = (s[i]*d+val)%mod;
		d = d*10%mod;
		x.suf = (x.suf+val)%mod;
		sum = (sum+mod-(s[n-1-i]))%mod;
		ans = ((ans-val+mod)*10+sum)%mod;
	}
	x.emp = false;
	x.N = x.n%mod;
	//out.println(x.res);
	out.println(x.poww(x, k).res);
	//out.println(dummy(line, k));
}
}





 



