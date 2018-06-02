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
  out.println("0");
  for (int i=1; i<=n; i++) {
	  out.println("X");
	  out.println("*");
	  out.println(i);
	  out.println("+");	  
  }
  in.close();  out.close();
}

}


