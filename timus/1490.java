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
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  long r = in.nextInt();
  long res = 0;
  for (long x=0; x<r; x++)
	  res+=Math.ceil(Math.sqrt(r*r-x*x));
  out.print(res*4);
  in.close();  out.close();
}

}
