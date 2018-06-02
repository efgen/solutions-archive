import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
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
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}
long pow(long x, int p, long mod) {
	long a = 1, b = x%mod;
	while (p>0) {
		if ((p&1)==1) a = a*b%mod;
		b = b*b%mod;
		p >>= 1;
	}
	return a;
}

static int[] gcd(int p, int q) {
    if (q == 0)
       return new int[] { p, 1, 0 };
    int[] vals = gcd(q, p % q);
    int d = vals[0];
    int a = vals[2];
    int b = vals[1] - (p / q) * vals[2];
    return new int[] { d, a, b };
 }
public void solve() throws IOException {
	int n = nextInt();
	int p = 1;
	long s = 0;
	HashSet<Long> t = new HashSet<Long>(2*n);
	for (int i=1; i<=n; i++) {
		if (t.contains((long)i)) continue;
		int r = (int)((p-s%p)%p);
		if (i%p==r) {
			out.print(i); out.print(' ');
			s+=i;
			p++;
			t.add((long)i);
		} else {
			int r2 = (int)((p+1-(s+i)%(p+1))%(p+1));
			int m1 = p;
			int m2 = p+1;
			long m = ((long)m1)*m2;
			int[] hz = gcd(m1, m2);
			//long c1 = BigInteger.valueOf(m2).modInverse(BigInteger.valueOf(m1)).longValue()*m2;
			//long c2 = BigInteger.valueOf(m1).modInverse(BigInteger.valueOf(m2)).longValue()*m1;
			hz[1] = (hz[1]%m2+m2)%m2;
			hz[2] = (hz[2]%m1+m1)%m1;
			long c1 = ((long)hz[2])*m2;
			long c2 = ((long)hz[1])*m1;
			long x = (c1*r+c2*r2)%m;
			if (x==0) x = m;
			while (x==i || t.contains(x)) x += m;
			out.print(x);
			out.print(' ');
			out.print(i);
			out.print(' ');
			
			t.add(x);
			t.add((long)i);
			p += 2;
			s += x+i;
		}
	}
}
  
}













 
 
  