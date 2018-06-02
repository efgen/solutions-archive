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
  int a = 0, b = 0, d = 1;
  while (n>0) {
	  if (n%3==0) n /= 3; else 
	  if (n%3==1) { a += d; n /= 3; } else 
	  if (n%3==2) { b += d; n /= 3; n++; }
	  d *= 3;	  
  }
  if (b==0) { a +=d; b += d; } 

  out.print(a+" "+b);  
  in.close(); out.close();
}
}


