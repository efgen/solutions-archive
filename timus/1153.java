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
  in = new Scanner(System.in);
  out = new PrintWriter(System.out); 
  BigInteger s = in.nextBigInteger();
  s = s.add(s);
  BigInteger L = new BigInteger("0");
  BigInteger R = s;
  BigInteger Two = new BigInteger("2");
  BigInteger x = new BigInteger("0");
  while (L.compareTo(R)<0) {
	  x = L.add(R).divide(Two);	
	  switch (x.add(BigInteger.ONE).multiply(x).compareTo(s)) {
	  	case  1:{R = x; break;}
	  	case  0:{L = x; R = x; out.print(x); break;}
	  	case -1:{L = x; break;}
	  }	
  }
  in.close();  out.close();
}

}