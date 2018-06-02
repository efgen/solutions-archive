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
  String s1 = "1120311033224052233011302110452740";
  String s2 = "1120311033224455233011302110453748";
  int p = s1.length();
  int x = in.nextInt();
  boolean win = true;
  if (x<=p) win = s1.charAt(x-1)!='0'; else win = s2.charAt((x-1)%p)!='0';
  if (win) out.print("White"); else out.print("Black");
  in.close(); out.close();  
}
}


