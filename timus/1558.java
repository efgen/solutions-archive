import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
int ACode = 10;
public static void main(String[] args) throws IOException {
new Main().run();
}
boolean ok(String s, int k) {
	int len = s.length();
	boolean f = true;
	String ss = s.substring(len-k);
	for (int beg=len-2*k; beg>=k; beg -=k)
		f &= ss.equals(s.subSequence(beg, beg+k));	
	return f;
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  String s1 = in.next(), s2 = in.next();
  s1 = s1.substring(1, s1.length()-1);
  s2 = s2.substring(1, s2.length()-1);
  String a = "", b = "";
  for (int i=0; i<10; i++) a += s1;
  for (int i=0; i<10; i++) b += s2;
  String s = (new BigInteger(a).add(new BigInteger(b))).toString();
  //out.println(s);
  int len = s.length();
  for (int p = 1; p<11; p++) {
	  for (int sh=0; sh<11; sh++) 
		  if (ok(s.substring(0,len-sh),p)) {
			  out.print("(");
			  out.print(s.substring(len-sh-p,len-sh));
			  out.print(")");			  
			  out.print(s.substring(len-sh));
			  out.flush();
			  return;
		  }	  
  }
  in.close(); out.close();  
}
}



