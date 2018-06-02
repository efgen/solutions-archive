import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}

public void run() throws IOException {
  in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"), 1024*8); 
  out = new PrintWriter(System.out);  
  long n = Long.parseLong(in.readLine());
  long sq = (long)Math.floor(Math.sqrt(n)+1e-8);
  long b = sq;
  if (1l*sq*sq==n) {
	  out.println(1);
	  out.close();
	  return;
  } else {
	  for (long a=1; a<=sq; a++) {
		  	long X = n-a*a;
		  	while (b*b>X) b--;
			 if (b*b==X) {
				 out.println(2);
				 out.close();
				 return;
			 }
		  }
	  
  }
  while (n>8 && (n&3)==0) n >>= 2;
  if (n%8==7) out.println(4); else  out.println(3);
  out.close();
}

}
