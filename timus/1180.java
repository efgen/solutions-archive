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
  String s = in.nextLine();
  int n = 0;
  for (int i=0; i<s.length(); i++) n += s.charAt(i)-'0';
  n %= 3;
  if (n==0) out.print(2); else {
	  out.println(1);
	  out.print(n);
  }

  in.close();  out.close();
}

}


