import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int n = in.nextInt(); in.nextLine();
  BigInteger r = BigInteger.ZERO;
  int g = -130;
  while (n-->0) {
	  String ss = in.nextLine();
	  String s = ss.substring(0,ss.indexOf('e'));
	  String sp = ss.substring(ss.indexOf('e')+1);
	  if (sp.indexOf('+')==0) sp = sp.substring(1);
	  int p = Integer.parseInt(sp);	  
	  s = s.replace(".", "");
	  p -= s.length()-1;
	  BigInteger x = new BigInteger(s);
	  x = BigInteger.TEN.pow(p-g).multiply(x);
	  r = r.add(x);
  }
  String s = r.toString();
  int p = g+s.length()-1;
 // s = s.charAt(0)+"."+s.substring(1);
  if (s.length()>=20) {
	  if (s.charAt(19)>='5') {
		  BigInteger x = new BigInteger(s.substring(0,19));
		  x = x.add(BigInteger.ONE);
		  s = x.toString();
		  if (s.length()>19) p++;
	  }
  }
  while (s.length()<19) s += "0";
  s = s.substring(0,19);
  out.print(s.charAt(0)+"."+s.substring(1)+"e"+p); 
 // out.print(r);
  in.close(); out.close();
}
}


