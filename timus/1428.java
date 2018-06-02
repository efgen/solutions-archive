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
  int a = in.nextInt();
  int b = in.nextInt();
  int c = in.nextInt(); 
  out.println((long)Math.pow(2, (c-1)/a));
  out.println((long)Math.pow(2, (c-1)/b));
  out.println(2);
  in.close(); out.close();
}

}

