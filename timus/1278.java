import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int bits(int x) {
	if (x>0) return 1+bits(x & (x-1)); else return 0;
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int x = in.nextInt();
  int b = bits(x);
  int k = 0;
  while (x>=(1<<(k+1)))  k++;
 // out.println(k+" "+b);
  for (int p=0; p<k; p++)
	  if ((x>>p)%2==1) 
		  out.println("CALL "+(b+k-p-1));
  
 // out.println("----------");
  for (int i=1; i<=k; i++) 
	  out.println("CALL "+(b-1+i));
  out.println("BELL&RET");
  in.close(); out.close();
}

}
