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
  int n = in.nextInt();
  if (n==1) out.print(14); else
  if (n==2) out.print(155); else  out.print(1575);
  for (int i=4; i<=n; i++) out.print(0);
  in.close(); out.close();
}

}
