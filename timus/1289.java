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
  int n = in.nextInt()/2;
  if (n==1) out.print(10); else {
	  n -= 2;
	  out.print(1);
	  for (int i=1; i<=n; i++) out.print(1);
	  out.print(0);
	  for (int i=1; i<=n; i++) out.print(8);
	  out.print(90);
  }
  in.close(); out.close();
}

}
