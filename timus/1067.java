import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
void Show(String beg,TreeMap<String,TreeMap> t) {
	if (t.size()==0) return;	
		for (String s : t.keySet()) {
		out.println(beg+s);
		Show(" "+beg,t.get(s));
	}				
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);  
  int n = in.nextInt(); in.nextLine();
  TreeMap<String,TreeMap> root = new TreeMap<String,TreeMap>();
  TreeMap<String,TreeMap> t;
  while (n-->0) {
	  StringTokenizer st = new StringTokenizer(in.nextLine(),"\\");
	  t = root;
	  while (st.hasMoreTokens()) {
		  String s = st.nextToken();
		  if (!t.containsKey(s))
			  t.put(s, new TreeMap<String,HashMap>());		  
		  t = t.get(s);
	  }
  } 
  Show("",root);  
  in.close(); out.close();
}

}
/*
GAMES
 DRIVERS
HOME
WIN
 SOFT
WINNT
 DRIVERS
 SYSTEM32
  CERTSRV
   CERTCO~1
    X86
  CONFIG
*/