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
  long n = in.nextInt();
  long m = in.nextInt();
  if (n<=m) out.print(2*n-2); else out.print(2*m-1); 
  in.close(); out.close();
}

}