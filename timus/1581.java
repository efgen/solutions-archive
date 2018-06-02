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
  int p = in.nextInt(), k =1;
  while (n-->1) {
	  int x = in.nextInt();
	  if (x==p) k++; else {
		  out.print(k+" "+p+" ");
		  p = x; k = 1;
	  }
  }
  out.print(k+" "+p+" ");
  in.close(); out.close();  
}
}



