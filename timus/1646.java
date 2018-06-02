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
//        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
 //       br = new BufferedReader(new FileReader("input.txt"));      
 //      out= new PrintWriter(new File("output.txt"));
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


String dna;
long mod = inf+7;
int n;
class Rec {
	boolean f = false;
	long ans;
	String beg,end;
	Rec(String s) {
		beg = s;
		end = s;
		ans = calc(s);
	}
	Rec(Rec a, Rec b) {
		if (a.f && b.f) {
			this.beg = a.beg;
			this.end = b.end;
			this.ans = (a.ans+b.ans+calc(a.end+b.beg))%mod;
			f= true;
		}
		if (a.f && !b.f) {
			beg = a.beg;			
			ans = (a.ans+calc(a.end+b.beg))%mod;
			end = a.end+b.beg;
			end = end.substring(end.length()-(n-1));
			f = true;
		} 
		if (!a.f && b.f) {			
			end = b.end;
			ans = (b.ans+calc(a.beg+b.beg))%mod;
			beg = a.beg+b.beg;
			beg = beg.substring(0,n-1);
			f= true;
		} 
		if (!a.f && !b.f) {
			this.beg = a.beg+b.beg;
			this.end = this.beg;
			this.ans = calc(beg);
			int k = 2*n-2;
			f = false;
			if (beg.length()>=k) {
				f = true;
				end = beg.substring(beg.length()-(n-1));
				beg = beg.substring(0, n-1);
				f = true;
			}
		} 
	}
}
long calc(String s) {
	long res =0;
	for (int i=0; i<=s.length()-n; i++)
		if (s.substring(i, i+n).equals(dna)) res++;
	return res;
}
public void solve() throws IOException {
	dna = br.readLine();
	n = dna.length();
	Rec[] a = new Rec[100+3];
	a[1] = new Rec(br.readLine());
	a[2] = new Rec(br.readLine());
	int m = Integer.parseInt(br.readLine());
	long res = 0;
	for (int i=3; i<m+3; i++) {
		String[] ss = br.readLine().split(" ");
		int x = Integer.parseInt(ss[0]);
		int y = Integer.parseInt(ss[1]);
		a[i] = new Rec(a[x],a[y]);
		res = a[i].ans;
	}
	out.println(res);
	
	
}      
} 



















