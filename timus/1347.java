import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
BufferedReader in;
PrintWriter out;


public static void main(String[] args) throws IOException {
	new Main().run();
}

void show(TreeSet<String> t) {
	StringBuffer sb = new StringBuffer("");
	for (String s:t) sb.append(s+", ");
	if (sb.length()>0) sb.setLength(sb.length()-2);
	out.println(sb.toString()); 
}

public void run() throws IOException {
  in = new BufferedReader(new InputStreamReader(System.in)); 
  out = new PrintWriter(System.out);  
  int n =  Integer.parseInt(in.readLine());   
  TreeSet<String>[] fr = new TreeSet[n];
  TreeSet<String>[] infr = new TreeSet[n];
  String[] name = new String[n];
  for (int i=0; i<n; i++) {
	  name[i] = in.readLine();	  
	  TreeSet t = new TreeSet();
 	  StringBuffer sb = new StringBuffer("");
	  while (true) {		  
		  String s = in.readLine();	
		  sb.append(s);	
		  if (s.endsWith("</blog>")) break;		  
	  }
	  String s = sb.toString();	  
	  int p = 0;	  
	  while (true) {		
		  p = s.indexOf("<friend>", p);
		  if (p<0) break; else p += 8;
		  int e = s.indexOf("</friend>",p);
		  String fname = s.substring(p,e); p = e;
		  if (name[i].equals(fname)) continue;
		  t.add(fname);
	  }
	  fr[i] = t; 
	  infr[i] = new TreeSet<String>();
  }
  
  for (int i=0; i<n; i++) 
	  for (int j=0; j<n; j++)
		  if (i!=j) 
			  if (fr[j].contains(name[i])) 
				  infr[i].add(name[j]);  
  /*for (int i=0; i<n; i++) {
	  for (String s:infr[i]) out.print(s+" ");
	  out.println();
  }*/
 
  for (int i=0; i<n; i++) {	
	  TreeSet<String> t = new TreeSet<String>();	 	
	  for (String x:fr[i]) 
		  if (infr[i].contains(x))
			  t.add(x);	  
	  if (i>0) out.println();
	  out.println(name[i]);		   
	  out.print("1: "); show(fr[i]);	
	  out.print("2: "); show(infr[i]);
	  out.print("3: "); show(t);
  } 
 
  out.close(); 
 
}

}

