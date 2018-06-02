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
  double a = in.nextDouble()*1000;
  double b = in.nextDouble()*1000;
  double c = in.nextDouble()*1000;
  double d = in.nextDouble()*1000;
  if (Math.abs(a*b-c*d)<0.00001) out.print("Impossible."); else { 
	  double c_alf = (a*a+b*b-c*c-d*d)/(2*(a*b-c*d));
	  if (Math.abs(c_alf)>1) out.print("Impossible."); else {
		  double x = Math.round(Math.sqrt(a*a+b*b-2*a*b*c_alf));		 
		  out.println("Distance is "+(long)x+" km.");
	  } 
  }
  in.close(); out.close();
}

}
