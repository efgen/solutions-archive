import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}
boolean isPal(String s) {	
	return  new StringBuffer(s).reverse().equals(new StringBuffer(s));
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out); 
  String s = in.next();
  if (isPal(s)) out.print(s); else {
	  int len = s.length();
	  int n = len/2-1;
	  StringBuffer sb = new StringBuffer("");
	  for (int i=0; i<=n; i++) sb = sb.append(s.charAt(i));
	  StringBuffer sb2 = new StringBuffer(sb).reverse();
	  
	  if (len%2>0) 
		  sb = sb.append(s.charAt(n+1)).append(sb2);
	  else
		  sb = sb.append(sb2);

	  if (sb.toString().compareTo(s)>=0) out.print(sb.toString()); else {
		  if (len%2>0)  {
			  char c = sb.charAt(n+1);
			  if (c!='9') {
				  c++;
				  sb.deleteCharAt(n+1);
				  sb.insert(n+1, c);
				  out.print(sb.toString());
				  in.close(); out.close();
				  return;
			  } else {
				  sb.deleteCharAt(n+1);
				  sb.insert(n+1, '0');
			  }
		  }
		  int d = len%2;
		  for (int i=0; i<=n; i++) 
			  if (sb.charAt(n-i)!='9') {
				  char c = sb.charAt(n-i); c++;
				  sb.deleteCharAt(n-i); sb.insert(n-i, c);
				  sb.deleteCharAt(n+i+1+d); sb.insert(n+i+1+d, c);
				  out.print(sb.toString());
				  in.close(); out.close();
				  return;
			  } else {
				  sb.deleteCharAt(n-i); sb.insert(n-i, '0');
				  sb.deleteCharAt(n+i+1+d); sb.insert(n+i+1+d, '0');
			  }
		  
		 
	  }

	  
	  
  }
  in.close(); out.close();
}

}


