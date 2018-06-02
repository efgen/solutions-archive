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
  int[] a = {0,1,1,2};
  int n = in.nextInt();
  int R = a[n%4];
  if (n%5==0 && n%10!=0 && R==1) R++;
  out.print(R); 
  in.close(); out.close();
}

}
