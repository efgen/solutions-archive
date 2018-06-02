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
boolean ok(BigInteger x) {
	String s = x.multiply(x).subtract(x).toString();
	for (int i=x.toString().length(); i>0; --i)
		if (s.charAt(s.length()-i)!='0') return false;
	return true;
}
char[] s;
int sz, pos = 0;

int symbol() {
	int res = 0;
	if (s[pos]=='(') {
		pos++;
		res = exp();
		pos++;
	} else {
		if (Character.isLetter(s[pos])) res = 1; else
		if (s[pos]=='0') res = 0; else assert(false);
		pos++;
	}
	return res;
}


int concat() {
	int res = 3;
	boolean inf = false;
	while (pos<sz && (s[pos]=='(' || s[pos]=='0' || Character.isLetter(s[pos]))) {
		int x = closure();
		if (x==2) inf = true;
		if (x==0) res = 0;
		if (x==1) {
			if (res!=0) res = 1;
		}
	}
	if (res==1 && inf) res = 2;
	if (res==3 && inf) res = 2;
	return res;
}
int exp() {
	int res = 0;
	res = concat();
	while (pos<sz && s[pos]=='|') {
		pos++;
		int x = concat();
		if (x==2) res = 2;
		if (x==1 || x==3) res = Math.max(res, 1);
	}
	return res;
}
int closure() {	
	int res = symbol();
	boolean ff =false;
	if (pos<sz && s[pos]=='*') ff = true;
	while (pos<sz && s[pos]=='*') pos++;
	if (res==1 && ff) res = 2;
	if (res==0 && ff) res = 3;
	return res;
}
public void solve() throws IOException {
	s = br.readLine().toCharArray();
	sz = s.length;
	int t = exp();
	if (t!=2) out.print("F"); else out.print("N");
	//out.println(exp());
	
}
}











