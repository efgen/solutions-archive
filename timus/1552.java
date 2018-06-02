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
class State {
	int[] a = new int[4];
	int t, pos;
	State next(int k) {
		State st = new State();
		st.a = a.clone();
		st.a[t] = (int)s[pos];
		st.a[k] = (int)s[pos+1];
		st.t = k;
		st.pos = pos+1;
		return st;
	}
	int code() {
		int res = 0;
		for (int i=0; i<4; i++) if (i!=t) res = res*27+a[i];
		res = 4*res+t;
		res = res*L+pos;
		return res;
	}
	
	
	
	
}
State decode(int x) {
	State s = new State();
	s.pos = x%L; x /= L;
	s.t = x&3; x >>= 2;
	for (int i=3; i>=0; --i) if (i!=s.t) {
		s.a[i] = x%27;
		x /= 27;
	}
	return s;
}
char[] s;
int L;
public void solve() throws IOException {
//	out.print((int)'a'); out.flush();
	s = ((char)('z'+1)+br.readLine().trim()).toCharArray();	
	L = s.length;
	for (int i=0; i<L; i++) s[i] -= 'a';
	int sz = 27*27*27*4*L;
	int[] d = new int[sz];
	int[] pr = new int[sz];
	int[] Q = new int[sz];
	int qs = 0, qt = 0;	
	Arrays.fill(d, -1);
	Arrays.fill(pr, -1);
	int res = inf;
	int bv = -1;
	for (int i=0; i<4; i++) {
		State st = new State();
		Arrays.fill(st.a, 26);
		st.pos = 0;
		st.t = i;
		int x = st.code();
		Q[qt++] = x;
		d[x] = 0;
	}
	while (qs<qt) {
		int x = Q[qs++];
		int w = d[x];
		State st = decode(x);
		if (st.pos==L-1) {
			if (w<res) {
				res = w;
				bv = x;
			}
			continue;
		}
		for (int i=0; i<4; i++) {
			int v = 1+Math.abs(i-st.t);
			int p = i==st.t?s[st.pos]:st.a[i];
			if (p==26) {
				p = 0;
				v += (int)'a';
			}
			v += Math.abs(p-s[st.pos+1]);	
			int nx = st.next(i).code();
			if (d[nx]<0) Q[qt++] = nx;
			if (d[nx]<0 || d[nx]>w+v) {
				d[nx] = w+v; pr[nx] = x;
			}
		}			
	}
	Stack<String> Res = new Stack<String>();
	StringBuilder sb = new StringBuilder();
	while (true) {
		int p = pr[bv];
		if (p<0) break;
		State st1 = decode(p);
		State st2 = decode(bv);
		for (int k=st1.t; k<st2.t; k++) sb.append(">");
		for (int k=st1.t; k>st2.t; k--) sb.append("<");
		int z2 = s[st2.pos];
		int z1 = st1.t==st2.t?s[st1.pos]:st1.a[st2.t];
		if (z1==26) z1 = -((int)'a');
		for (int k=z1; k<z2; k++) sb.append("+");
		for (int k=z1; k>z2; k--) sb.append("-");
		sb.append(".");
		Res.add(sb.toString()); sb.setLength(0);
		bv = p;
	}
	//out.println(res+" "+bv);
	while (!Res.empty()) out.print(Res.pop());
}
}











