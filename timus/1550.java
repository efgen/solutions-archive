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
  double H = in.nextDouble();
  double w = in.nextDouble();
  double x = Math.abs(in.nextDouble());
  double y = Math.abs(in.nextDouble());
  double r = in.nextDouble();
  double d = Math.sqrt(x*x+y*y);
  double D = w/2; 
  if (x>y) D *= Math.sqrt(1+y*y/x/x); else D *= Math.sqrt(1+x*x/y/y);
  double h = H*(D-d)/D;
  double v = w*w*H/3-Math.PI*r*r*h;
  out.printf(Locale.US,"%1.5f",v);   
  in.close(); out.close();
}

}
