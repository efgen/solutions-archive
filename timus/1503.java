import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main   {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
static final double eps = 0.5e-9;

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
   // new Thread(new Main()).start();
	new Main().run();
}

public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));  	
    	
    	//br = new BufferedReader(new FileReader(new File(FileName+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
    	//in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}
BigDecimal EPS = BigDecimal.ONE.divide(BigDecimal.TEN.pow(9));
BigDecimal INFP = BigDecimal.TEN.pow(6);
BigDecimal INFN = BigDecimal.TEN.pow(6).negate();
BigDecimal TWO = BigDecimal.valueOf(2);
BigDecimal f(BigDecimal[] cof, BigDecimal x) {
	BigDecimal res = BigDecimal.ZERO;
	for (BigDecimal a:cof) res = res.multiply(x).add(a);
	return res;
}
BigDecimal[] solv(BigDecimal[] cof) {
	int n = cof.length;
	if (n==2) {
		if (cof[0].abs().compareTo(EPS)<0) return new BigDecimal[0];
		return new BigDecimal[]{cof[1].divide(cof[0].negate(), 15, BigDecimal.ROUND_HALF_EVEN)};
	}
	BigDecimal[] pr = new BigDecimal[n-1];
	for (int i=0; i<n-1; i++) pr[i] = cof[i].multiply(BigDecimal.valueOf(n-i-1));
	BigDecimal[] roots1 = solv(pr);
	Vector<BigDecimal> roots = new Vector<BigDecimal>();
	roots.add(INFN);
	for (BigDecimal x:roots1) roots.add(x);
	roots.add(INFP);

	Vector<BigDecimal> v = new Vector<BigDecimal>();
	for (int i=0; i<roots.size()-1; i++) {
		BigDecimal l = roots.elementAt(i), r = roots.elementAt(i+1);
		BigDecimal fl = f(cof, l);
		BigDecimal fr = f(cof, r);
		if ((fl.signum() != fr.signum()) || fl.abs().compareTo(EPS)<0 || fr.abs().compareTo(EPS)<0) {
			boolean voz = f(cof, r).compareTo(f(cof, l)) > 0;
			while (r.subtract(l).compareTo(EPS)>0) {
				BigDecimal mid = l.add(r).divide(TWO);
				if ((f(cof, mid).compareTo(BigDecimal.ZERO)>0)^voz) l = mid; else r = mid;
			}
			v.add(r);
		}
	}
	BigDecimal[] a = v.toArray(new BigDecimal[0]);
	Arrays.sort(a);
	return a;
}
public void solve() throws IOException {
	int n = nextInt();
	BigDecimal[] a = new BigDecimal[n+1];
	for (int i=0; i<=n; i++) a[i] = BigDecimal.valueOf(nextInt());
	BigDecimal[] roots = solv(a);
	for (BigDecimal x:roots) {
		//out.println(x.toPlainString().substring(0, Math.min(20, x.toPlainString().length())));
		out.println(x.toString());
	}
	

		
}
}




