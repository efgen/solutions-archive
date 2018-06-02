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
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}

char[] a = new char[300*81];
int len, p = 0;
String nextC() {
	StringBuilder sb = new StringBuilder();
	p++; 
	sb.append(a[p++]);
	while (p<len) 
		if (Character.isLetter(a[p])) sb.append(a[p++]); else break;	
	return sb.toString();
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
 // in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  len = br.read(a);
  Vector<Vector<Integer>> P = new Vector();
  P.add(new Vector<Integer>());
  int par = 0;
  int st = 0;
  while (p<len) {
	  if (a[p]=='\\') {
		  String s = nextC();
		  if (s.equals("par")) {
			  P.add(new Vector<Integer>());
			  par++;
		  } else
		  if (s.equals("endinput")) break;		  
	  }  else
	  if (a[p]=='"') P.elementAt(par).add(p++); else
	  if (a[p]=='\r') {st++; p++; } else
	  if (a[p]=='\n') {
		  st++;
		  p++;
		  if (st==4) {
			  P.add(new Vector<Integer>());
			  par++;
			  st = 0;
		  }
	  }else {
		  p++;
		  st = 0;
	  }		  
  }
 // out.println(par);
  p = 0; par = 0; st = 0;
  int k = 0;
  while (p<len) {
	  if (a[p]=='\\') {
		  String s = nextC();
		  out.print("\\"+s);
		  if (s.equals("par")) {
			  k = 0;
			  par++;
		  } else
		  if (s.equals("endinput")) break;		  
	  }  else
	  if (a[p]=='"') {
		  if (k%2==1) out.print("''"); else
			  if (k!=P.elementAt(par).size()-1) out.print("``");
		  k++; p++;
	}
	  else
	  if (a[p]=='\r') {st++; p++; out.print('\r');} else
	  if (a[p]=='\n') {
		  out.print('\n');
		  st++;
		  p++;
		  if (st==4) {
			  par++;
			  st = 0;
			  k = 0;
		  }
	  }else {
		  out.print(a[p++]);		  
		  st = 0;
	  }		  
  }
  
  out.close();    
}   

}




