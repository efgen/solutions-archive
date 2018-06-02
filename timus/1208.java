import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int ds = 0;
String[] dict;

int pos(String s) {	
	for (int i=0; i<ds; i++)
		if (dict[i].equals(s)) return i;
	dict[ds] = s;
	return ds++;
}

int ed(int x) {
	if (x>0) return 1+ed(x&(x-1)); else return 0;
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  int n = in.nextInt(); dict = new String[3*n]; 
  long[] a = new long[n];
  for (int i=0; i<n; i++) 
	  a[i] = (1L<<pos(in.next()))+(1L<<pos(in.next()))+(1L<<pos(in.next()));
  int res = 0;
  for (int st=(1<<n)-1; st>0; st--) {
	  long t = 0;
	  boolean f = true;
	  for (int i=0; i<n; i++)
		  if (((st>>i)&1)==1)
			  if ((t&a[i])==0) t |= a[i]; else f = false;
	  if (f) res = Math.max(res, ed(st));
  }
  out.print(res);
  in.close(); out.close();
}

}
