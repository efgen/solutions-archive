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
  double a = in.nextDouble();
  double b = in.nextDouble();
  double x = 1-in.nextDouble()/100; 
  if (a<b) out.print(0); else
  out.print((long)Math.ceil(Math.log(b/a)/Math.log(x)));
  in.close(); out.close();
}

}
