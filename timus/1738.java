import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
int nextD() throws IOException{      
    ST.nextToken();      
    return (int) Math.floor(ST.nval*100+0.5);     
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}      
public void run()  {      
    try {          
    	br = new BufferedReader(new InputStreamReader(System.in));        
    	out = new PrintWriter(System.out);
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}
int[] a;
TreeSet<Integer> t = new TreeSet<Integer>();
int[] ans = new int[5];
void f(int i, int j) {
	int x = a[i]^a[j];
	int res = 0;
	for (int k=0; k<4; k++) {
		if ((x&15)==0) res++;
		x >>= 4;
	}
	ans[4-res]++;
}

public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	a = new int[n+1];
	for (int i=1; i<=n; i++) {
		a[i] = Integer.valueOf(br.readLine(), 16);
	}
	
	for (int i=1; i<=n; i++) {
		int x = i;
		int y = 0;
		int d = 1;
		t.clear();
		int lc = 0;
		while (x>0) {
			int c = x%10;
			boolean f = (x/10)==0;
			for (int cc=1; cc<=(f?c-1:c); cc++) {
				f(i, i-cc*d);
				//t.add(i-cc*d);
			}
			x /= 10;
			if (!(f &&lc==0)) t.add(x*d+y);
			y += d*c;			
			d *= 10;
			lc = c;
		}
		for (int p:t) {
			f(i, p);
		}
		//out.println(t);
		
	}
	for (int i=1; i<5; i++) out.print(ans[i]+" ");
}
}











