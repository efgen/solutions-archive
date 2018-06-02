import java.io.*;         
import java.util.*;         
import java.math.*;         
        
public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
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
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
        br = new BufferedReader(new InputStreamReader(System.in));
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}   

int[] dx = {1,-1,0,0};
int[] dy = {0,0,1,-1};
class Frac{
	public String toString() {		
		return x+"/"+y;
	}
	int gcd(int a, int b) {
		if (b==0) return a; else return gcd(b,a%b);
	}
	BigInteger x, y;
	Frac(BigInteger x, BigInteger y) {
		BigInteger d = x.gcd(y);
		if (!d.equals(BigInteger.ONE)) {
			x = x.divide(d);
			y = y.divide(d);
		}
		this.x = x;
		this.y = y;
	}
	Frac(Frac a) {
		this.x = a.x;
		this.y = a.y;
	}
	Frac(int x, int y) {
		this.x = BigInteger.valueOf(x);
		this.y = BigInteger.valueOf(y);
	}
	Frac add(Frac a) {
		return new Frac(x.multiply(a.y).add(y.multiply(a.x)),y.multiply(a.y));
	}
	Frac sub(Frac a) {
		return new Frac(x.multiply(a.y).subtract(y.multiply(a.x)),y.multiply(a.y));
	}
	Frac mul(Frac a) {
		return new Frac(x.multiply(a.x),y.multiply(a.y));
	}
	Frac div(Frac a) {
		if (a.x.compareTo(BigInteger.ZERO)>0) 
			return new Frac(x.multiply(a.y),y.multiply(a.x));
		else 
			return new Frac(x.multiply(a.y).negate(),y.multiply(a.x).negate());
	}
}
public void solve() throws IOException {
	String[] ss = br.readLine().split(" ");
	int h = Integer.parseInt(ss[0]);
	int w = Integer.parseInt(ss[1]);
	int n = 0;
	int[][] num = new int[h][w];
	for (int[] aa:num) Arrays.fill(aa, -1);
	char[][] map = new char[h][];
	for (int i=0; i<h; i++) {
		map[i] = br.readLine().toCharArray();
		for (int j=0; j<w; j++)
			if (map[i][j]=='.') num[i][j] = n++;
	}
	int[][] sm = new int[n][n];
	for (int i=0; i<h; i++)
		for (int j=0; j<w; j++)
			if (num[i][j]>=0)
				for (int k=0; k<4; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if (x<0 || y<0 || x>=h || y>=w || num[x][y]<0) continue;
					sm[num[i][j]][num[x][y]] = sm[num[x][y]][num[i][j]] =  -1;
					sm[num[i][j]][num[i][j]]++;			
				}
	n--;
	Frac[][] a = new Frac[n][n];
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++) a[i][j] = new Frac(sm[i][j],1);

	
	Frac res = new Frac(1,1);
	for (int k=0; k<n; k++) {
		Frac x = new Frac(a[k][k]);
		if (x.x.equals(BigInteger.ZERO)) {
			res.x = BigInteger.ZERO;
			break;
		}
		res = res.mul(x);
		for (int i=k; i<n; i++) a[k][i] = a[k][i].div(x);
		for (int i=k+1; i<n; i++) {
			x = new Frac(a[i][k]);
			if (x.x.equals(BigInteger.ZERO)) continue;
			for (int j=k; j<n; j++) a[i][j] = a[i][j].sub(a[k][j].mul(x));
		}
		
	}
	out.print(res.x.mod(BigInteger.valueOf(inf)));
	

	
}      
} 
