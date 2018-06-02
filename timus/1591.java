import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  long r = 1;
  long res = 0;
  r *= 1L*n*(n-1)*(n-2)*(n-3);
  r /= 6;
  res = r;
  r *= n-4; r /= 4;
  res += r;
  r *= n-5; r /= 30;
  res += r;
  out.print(res);
  in.close(); out.close();  
}
}
