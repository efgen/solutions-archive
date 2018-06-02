import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StringTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
int nextInt() throws IOException{      
          
    return Integer.parseInt(next());      
}
long nextLong() throws IOException{    
    
    return Long.parseLong(next());      
}      
String next() throws IOException{      
    while (ST==null || !ST.hasMoreTokens()) {
    	String line = br.readLine();
    	if (line==null) return null;
    	ST  = new StringTokenizer(line);
    }
    return ST.nextToken();
}      
double nextD() throws IOException{      
    return Double.parseDouble(next());      
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
    	//in = new Scanner(br);
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
class Vertex implements Comparable<Vertex>{
	long cost;
	int d, p;
	public Vertex(long cc, int dd, int pp) {
		cost = cc; d = dd; p = pp; 
	}
	public String toString() {
		return p+" "+d +" "+cost;
	}
	@Override
	public int compareTo(Vertex o) {
		return Integer.valueOf(d).compareTo(o.d);
	}
}

private static int modular_exponent_32(int base, int power, int modulus) {
    long result = 1;
    for (int i = 31; i >= 0; i--) {
        result = (result*result) % modulus;
        if ((power & (1 << i)) != 0) {
            result = (result*base) % modulus;
        }
    }
    return (int)result; // Will not truncate since modulus is an int
}
private static boolean miller_rabin_pass_32(int a, int n) {
	int d = n - 1;
	int s = Integer.numberOfTrailingZeros(d);
	d >>= s;
    int a_to_power = modular_exponent_32(a, d, n);
    if (a_to_power == 1) return true;
    for (int i = 0; i < s-1; i++) {
        if (a_to_power == n-1) return true;
        a_to_power = modular_exponent_32(a_to_power, 2, n);
    }
    if (a_to_power == n-1) return true;
    return false;
}
static Random R = new Random(123123123);
public static boolean miller_rabin_32(int n) {
    if (n <= 1) return false;
    else if (n == 2) return true;
    else if (miller_rabin_pass_32( 2, n) &&
        (n <= 7  || miller_rabin_pass_32( 7, n)) &&
        (n <= 61 || miller_rabin_pass_32(61, n))) {
    	//for (int i=30; i>=0; --i) 
    	//	if (!miller_rabin_pass_32(R.nextInt(n-1)+1, n)) return false;
    	return true;
    }
        
    else
        return false;
}

public void solve() throws IOException {
	int n = nextInt();
	if (n==1) {
		out.println(1);
		return;
	}
	ArrayList<Integer> divs = new ArrayList<Integer>();
	for (int d=1; d*d<=n; d++) {
		if (d*d==n) divs.add(d); else if (n%d==0) {
			divs.add(d);
			divs.add(n/d);
		}
	}
	Collections.sort(divs);
	ArrayList<Vertex> e = new ArrayList<Vertex>();
	ArrayList<Vertex> cure = new ArrayList<Vertex>();
	ArrayList<Vertex> newe = new ArrayList<Vertex>();
	int maxn = 1<<16;
	boolean[] prime = new boolean[maxn];
	ArrayList<Integer> primes = new ArrayList<Integer>();
	Arrays.fill(prime, true); prime[0] = prime[1] = false;
	for (int i=2; i<maxn; i++)
		if (prime[i]) {
			primes.add(i);
			for (int j=i+i; j<maxn; j+=i)
				prime[j] = false;
		}
	for (int p:primes) {
		long pp = (p-1l)*p;
		while (pp<=n) {
			int id = Collections.binarySearch(divs, (int)pp); 
			if (id>=0)  {
				e.add(new Vertex(pp/(p-1)*p, (int)pp, p));
				cure.add(new Vertex(pp/(p-1)*p, (int)pp, p));
			}
			pp *= p;
		}
	}
	for (int i=0; i<divs.size(); i++) {
		//if (BigInteger.valueOf(divs.get(i)+1).isProbablePrime(100)) {
		if (miller_rabin_32(divs.get(i)+1)) {
			e.add(new Vertex(divs.get(i)+1, divs.get(i), divs.get(i)+1));
			cure.add(new Vertex(divs.get(i)+1, divs.get(i), divs.get(i)+1));
		}
	}
	//out.println(divs.size()); out.flush();
	Collections.sort(e);
	ArrayList<Vertex>[] go = new ArrayList[divs.size()];
	for (int i=0; i<divs.size(); i++) go[i] = new ArrayList<Vertex>();
	for (Vertex v:e) {
		for (int i=0; i<divs.size(); i++) if (divs.get(i)%v.d==0) go[i].add(v);
	}
	//out.println(divs.size()); out.flush();
primes = null;
prime = null;
	System.gc();
	long res = Long.MAX_VALUE;
	while (cure.size()>0) {
		for (Vertex v:cure) {
			if (v.cost>res) continue;
			if (v.d==n) res = v.cost; else {
				int n0 = n/v.d;
				int id = Collections.binarySearch(divs, n0);
				for (Vertex vv:go[id])
					if (vv.p>v.p) 
						newe.add(new Vertex(vv.cost*v.cost, v.d*vv.d, vv.p));
				/*for (Vertex vv:e) if (n0%vv.d==0) {
					if (vv.p>v.p) newe.add(new Vertex(vv.cost*v.cost, v.d*vv.d, vv.p));
					if (vv.d==n0) break;
				}*/
			}
		}
		cure.clear();
		cure.addAll(newe);
		newe.clear();
		System.gc();
		
		
	}
	if (res==Long.MAX_VALUE) out.println(0); else out.println(res);
	
}
  
}













 
 
  