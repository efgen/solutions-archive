import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}
String premake(String s) {
	char p = 0;
	StringBuilder sb = new StringBuilder();
	for (int i=1; i<s.length()-1; i++) { 
		char c = s.charAt(i);
		if (c=='\'') {
			if (p=='\''){ sb.append('\''); p = 0; } else p = c; 
		} else {
			sb.append(c);
			p = c; 
			}
	}
	return sb.toString();
}
String make(String s) {
	StringBuilder sb = new StringBuilder();
	boolean in = false;
	char p = 0;
	for (char c:s.toCharArray()) 
		if (in) {			
			if (c=='[') {
				sb.append(www[c]);
			} else {
				sb.append(c);
				if (c==']') in = false;
				p = 0;
			}
			
		} else {
			if (c=='%') {if (p!='%') sb.append(".*"); }else				
			if (c=='_') sb.append('.'); else 
			if (c=='[') { 
				in = true;
				sb.append('[');
			} else {			
				sb.append(www[c]);				
			}
			p = c;
		
		}
	return sb.toString();
}
String[] www = new String[256];

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
 // in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  for (char c=0; c<256; c++) {
	  //	if (Character.isLetterOrDigit(c)) www[c] = ""+c; else {
	  	www[c] = "\\x";
		int h = c/16;
		if (h<10) www[c] += ((char)(h+'0')); else www[c] +=((char)(h+'a'-10));
		h = c%16;
		if (h<10)www[c] += ((char)(h+'0')); else www[c] += ((char)(h+'a'-10));
	//  	}
  }
  int t = Integer.parseInt(br.readLine());
  while (t-->0) {
	  String[] ss = br.readLine().split(" like ");
	  String s1 = premake(ss[0]);
	  String s = premake(ss[1]);
	//  out.println(s1+" "+s);
	  if (s1.matches(make(s))) out.println("YES"); else out.println("NO");
  }
  out.close();    
}   

}
