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
  String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
  int[] mon = {0,1,2,3,4,5,6,7,8,30,31,30,31};
  String s = in.nextLine();
  int fd = 0;
  while (!days[fd].equals(s)) fd++;
  s = in.next(); int ed = in.nextInt();
  int em = 9;
  if (s.charAt(0)=='O') em = 10; else
  if (s.charAt(0)=='N') em = 11; else
  if (s.charAt(0)=='D') em = 12; 
  int a = in.nextInt();
  int b = in.nextInt();
  int r = 1<<7;
  int res = -1;
  while (r>0) {
	  r--;
	  int k = 0;
	  int p = (fd+1)%7;
	  int d = 2; int m = 9;
	  while (d!=ed || m!=em) {
		  if (((1<<p)&r)>0) k++;
		  p = (p+1)%7;
		  d++;
		  if (d>mon[m]) {
			  m++;
			  d = 1;
		  }
	  }
	  if (k>=a && k<=b) {
		  res = r;
		  break;		  
	  }	  
  }
  if (res<0) out.print("Impossible"); else {
	  int x = res;
	  int k = 0;
	  while (x>0) {k++; x &=x-1;}
	  out.println(k);
	  for (int i=0; i<7; i++)
		  if ((res&(1<<i))>0) out.println(days[i]);
  }
 
  in.close(); out.close();
}
}