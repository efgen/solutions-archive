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
  int dl = in.nextInt();
  if (dl==0) out.print("000000000003"); else {	
	  long n = in.nextLong();
	  long d = 1;
	  for (;dl<12; dl++) d *= 10;
	  n *= d;	  
	  Random R = new Random(); 
	  long x = n;  	 
	  while (!BigInteger.valueOf(x).isProbablePrime(100))
		  x = n + (Math.abs(R.nextLong())%d);		
	  String s = Long.toString(x);
	  while (s.length()<12) s = "0"+s;
	  out.print(s);		
  }  
  in.close(); out.close();
}

}

