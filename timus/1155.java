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
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int a = in.nextInt();
  int b = in.nextInt();
  int c = in.nextInt();
  int d = in.nextInt();
  int e = in.nextInt();
  int f = in.nextInt();
  int g = in.nextInt();
  int h = in.nextInt();
  if (a+c+f+h-b-e-d-g!=0) out.println("IMPOSSIBLE"); else {
	  while (a>0 && b>0) {a--; b--; out.println("AB-");}
	  while (a>0 && e>0) {a--; e--; out.println("AE-");}
	  while (a>0 && d>0) {a--; d--; out.println("AD-");}
	  
	  while (c>0 && b>0) {c--; b--; out.println("CB-");}
	  while (c>0 && g>0) {c--; g--; out.println("CG-");}
	  while (c>0 && d>0) {c--; d--; out.println("CD-");}
	  
	  while (f>0 && b>0) {f--; b--; out.println("FB-");}
	  while (f>0 && e>0) {f--; e--; out.println("FE-");}
	  while (f>0 && g>0) {f--; g--; out.println("FG-");}
	  
	  while (h>0 && g>0) {h--; g--; out.println("HG-");}
	  while (h>0 && e>0) {h--; e--; out.println("HE-");}
	  while (h>0 && d>0) {h--; d--; out.println("HD-");}
	  
	  while (a>0 && g>0) {a--; g--; out.println("BF+"); out.println("AB-"); out.println("FG-");}
	  while (c>0 && e>0) {c--; e--; out.println("GF+"); out.println("CG-"); out.println("FE-");}
	  while (f>0 && d>0) {f--; d--; out.println("AB+"); out.println("FB-"); out.println("AD-");}
	  while (h>0 && b>0) {h--; b--; out.println("AD+"); out.println("HD-"); out.println("AB-");} 	
  }
  in.close(); out.close();
}

}
