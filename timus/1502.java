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
  long n =in.nextLong();
  out.print((n*(n+1)*(n+2))/2);
  in.close();  out.close();
}

}
