import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}

char[] a,b;
int pos,p,star;
boolean z = false;
boolean zero;
boolean ok;
void addI() {
	if (!Character.isDigit(a[pos])) ok = false;
	while (Character.isDigit(a[pos])) {
		if (a[pos]!=0) zero = false;
		b[p++] = a[pos++];
	}
}
void real() {
	zero = true;
	if (a[pos]=='+') pos++;
		else if (a[pos]=='-') { z = true; pos++;}
	if (a[pos]=='.') {
		star = p;
		pos++;
		addI();
	} else {
		addI();
		star = p;
		if (a[pos]=='.') {
			pos++;
			addI();
		}
	}
	if (a[pos]=='e' || a[pos]=='E') {
		pos++;
		boolean zz = false; 
		if (a[pos]=='+') pos++;
			else if (a[pos]=='-') { zz = true; pos++;}
		int x = 0;
		if (!Character.isDigit(a[pos])) ok = false;
		while (Character.isDigit(a[pos])) {
			x = 10*x+a[pos++]-'0';
			if (x>=200 && zz) zero = true;
		}
		if (zz) x = -x;
		star += x; 
	}
	if (a[pos]!=')' || pos!=a.length-1) ok = false;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  b = new char[500];
  while (true) {
	  Arrays.fill(b, '0');
	  String s = br.readLine();
	  if (s.equals("#")) break;
	  int n = Integer.parseInt(br.readLine());
	  s += ")";
	  a = s.toCharArray();
	  pos = 0; z = false; p = 222; ok = true; 
	  real();
	  if (!ok) out.println("Not a floating point number"); else {
		if (zero) {
			out.print("0");
			if (n>0) out.print(".");
			while (n-->0) out.print("0");
			out.println();
			continue;
		}
		int st = -1;
		for (int i=0; i<star; i++)
			if (b[i]!='0') {
				st = i;
				break;
			}
		StringBuilder res = new StringBuilder();
		if (st<0) res.append("0"); else {
			for (int i=st; i<star; i++) res.append(b[i]);
		}
		if (n>0) res.append(".");
		for (int i=0; i<n; i++) {
			p = i+star;
			if (b[p]!='0') st = 1;
			res.append(b[p]);
		}
		if (st<0) z = false;
		if (z) out.print("-");
		out.println(res); out.flush();			
	  }
  }
  out.close();    
}   

}


