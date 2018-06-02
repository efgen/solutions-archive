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
  int n = in.nextInt(), m = in.nextInt() % n;
  String s = ""; in.nextLine();
  while (n-->0) s += in.nextLine();
  s += s;
  out.print(s.substring(m, m+10));  
  in.close();  out.close();
}

}
