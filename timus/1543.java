import java.io.*;
import java.util.*;
import java.math.*;

public class Main{	
BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}


public void run() throws IOException {
  in = (new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);   
  StringTokenizer st = new StringTokenizer(in.readLine()," :");
  int min = Integer.parseInt(st.nextToken());
  int sec = Integer.parseInt(st.nextToken());
  String dif = st.nextToken();

  int p = 1000;
  if (dif.charAt(0)=='M') p = 500; else 
  if (dif.charAt(0)=='H') p = 250;
  
  String s = in.readLine();
  int d = s.length();
  int[] a = new int[d]; 
  boolean[] f = new boolean[d]; 
  int N = 0;
  for (int i=0; i<d; i++) {
	  f[i] = s.charAt(i)!='N';
	  if (f[i]) N++;
  }
 
  
  while (true) {	
	  String exp = in.readLine();
	  if (exp==null) break;
	  int time = Integer.parseInt(exp.substring(0,exp.length()-2)); 
	  char c = exp.charAt(exp.length()-1);	 
	  int t = time/p;
	  if (t>=d) continue;
	  if (f[t] && a[t]==0) {
		  if (c==s.charAt(t)) {
			  int peny = time%p;	
			  if (peny<0.4*p) a[t] = 3; else
			  if (peny<0.7*p) a[t] = 2; else a[t] = 1;
		  } else a[t] = -1;
	  }	  	  
  }
  

  int DancS = 0;
  int k = 0;
  int S = (N+1)*N/2;
  int B = 1000000;
  if (p==500) B *= 2; else
  if (p==250) B *= 3;
  for (int i=0; i<d; i++) 
	  if (f[i]) {
		  k++;
		  if (a[i]==3) DancS += 10*k; else
		  if (a[i]==2) DancS += 5*k;
	  }
  DancS *= B/S;
  
  int ComboS = 0; k = 0;
  for (int i=0; i<d; i++) 
	  if (f[i]) {
		  if (a[i]>0) k++; else k = 0;
		  if (a[i]==3) ComboS += 55*k; else
			  if (a[i]==2) ComboS += 33*k;		  
	  }
  
  int DP = 0;
  int DB = 10000000;
  for (int i=0; i<d; i++)
	  if (f[i]) {
		  if (a[i]==3) {
			  DP += 2;
		  } else
		  if (a[i]==2) {
			  DP += 1;
			  DB = Math.min(DB, 1000000);
		  } else {
			  DB = Math.min(DB, 0);
			  if (a[i]==0) DP -= 4; else 
				  if (a[i]==-1) DP -= 5;
		  }
		  
		  if (DP<0) DB = -1;
	  }
  if (DB == 0) {
	  int max = 2*N;
	  if (DP>=0.8*max) DB = 100000; else
		  if (DP>=0.64*max) DB = 10000; else
			  if (DP>=0.5*max) DB = 1000; else DB = 100;
				  
  }
  if (DB<0) DB = 0;
  
  
  
  int pr = 0, gr = 0, gd = 0, bo = 0, ms = 0;
  for (int i=0; i<d; i++)
	  if (f[i])
		  switch (a[i]) {
		  case 3:
			  pr++;
			  break;
		  case 2:
			  gr++;
			  break;
		  case 1:
			  gd++;
			  break;
		  case 0:
			  bo++;
			  break;
		  case -1:
			  ms++;
			  break;
		}
  
  
  out.println("Perfect: "+pr);
  out.println("Great: "+gr);
  out.println("Good: "+gd);
  out.println("Boo: "+bo);
  out.println("Miss: "+ms);
  out.println("--------------------");
  out.println("Stage Score: "+DancS);
  out.println("Combo Bonus: "+ComboS);
  out.println("Dance Level Bonus: "+DB);
  out.println("Total Score: "+(DancS+ComboS+DB));
  out.close(); 
}

}

