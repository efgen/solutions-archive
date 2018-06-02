import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
public static void main(String[] args) throws IOException {	new Main().run();}
Scanner in;
PrintWriter out;
boolean Check(String s){
	int len = s.length();
	for (int i=0; i<len/2;i++)
		if (s.charAt(i)!=s.charAt(len-i-1)) return false;
	return true;
}

void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  String s = in.next();
  for (int len=s.length(); len>0; len--){
	  for (int p=0; p<=s.length()-len; p++)
		 if (Check(s.substring(p, p+len))) {
			 out.print(s.substring(p, p+len));
			 out.flush();
			 return;
		 }
  }

  out.flush(); 
}


}