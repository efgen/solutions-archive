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
  double v = in.nextDouble(), a = in.nextDouble(), k = in.nextDouble();
  k = Math.sqrt(1/k);
  a = Math.sin(2*a* 3.1415926535/180);
  double s = 0;
  while (v>0.0001) {
	  s+=v*v*a/10;
	  v*=k;
  }
  out.printf(Locale.CHINA,"%1.2f",s);  
  in.close();  out.close();
}

}