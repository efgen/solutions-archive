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
  int n = in.nextInt();
  int r = 1;
  int p = 2;
  while (n>1) {
	  if (n%p==0){
		  int a = p, b = 1;
		  n /= p;
		  while (n%p==0) {
			  n /= p;
			  a *= p;
			  b *= p;
		  }
		  r *= a-b;
	  }
	  if (p*p>n) p = n; else p++;
  }
  out.print(r/2); 
  in.close(); out.close();
}
}


