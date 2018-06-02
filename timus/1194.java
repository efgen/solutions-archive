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
  int n = in.nextInt();
  int k = in.nextInt();
  out.print(n*(n-1)/2-k);
  in.close(); out.close();
}

}


