import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
BufferedReader in;
PrintWriter out;

public static void main(String[] args) throws IOException {
	new Main().run();
}
static final int mod = 400009;
static final int mod2 = mod-1;
static int maxsz = 100000;
static int[] len = new int[maxsz];
static int[] per = new int[maxsz];
static int[] Q = new int[maxsz];
static int[] key = new int[mod];
static int[] val = new int[mod];
int get(int x) {
	int h1 = ((7*x*x%mod)+mod)%mod;
	int h2 = 13*x%mod2; h2++;
	while (key[h1]>=0) {
		if (key[h1]==x) return val[h1];
		h1+=h2;
		if (h1>=mod) h1-=mod;
	}
	return -1;
}
void set(int x, int v) {
	int h1 = ((7*x*x%mod)+mod)%mod;
	int h2 = 13*x%mod2; h2++;
	while (key[h1]>=0) {		
		h1+=h2;
		if (h1>=mod) h1-=mod;
	}
	key[h1] = x;
	val[h1] = v;
}
public void run() throws IOException {
	
  in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"), 1024*8); 
  out = new PrintWriter(System.out);  
  //out.println(BigInteger.valueOf(400000).nextProbablePrime());
  Arrays.fill(key, -1);
 
  int n = Integer.parseInt(in.readLine());
  int k = 1;  
  while (n-->0) {
	  int p = 1;
	  int j = 0;
	  while (true) {
		  int c = in.read();
		  if (c == 13) break; else j++;
		  int x = (p<<8)+c;	
		  int g  = get(x);
		  if (g==-1) { 
			  set(x, ++k);
			  p = k;
		  } else  p = g;		
	  }
	  in.read();	
	  len[p] = j;
  }
  
 
  int s = 0, t = 0; 
  for (int c=1; c<256; c++) 
	  if (get(256+c)>=0) {
		  Q[++t] = get(256+c);
		  per[Q[t]] = 1;
	  }
  while (s<t) {
	  int p = Q[++s];
	  int x = (p<<8)+1;
	  for (int c=1; c<256; c++, x++) {
		  int g = get(x); 
		  if (g>=0) {			  
			  int u = g;
			  int v = per[p];
			  Q[++t] = u;
			  while (v>1 && get((v<<8)+c)<0) v = per[v];
			  g=get((v<<8)+c);
			  if (g>=0) per[u] = g; else per[u] = 1;
			  len[u] = Math.max(len[u], len[per[u]]);
		  }
	  }
  } 
  
  
  n = Integer.parseInt(in.readLine());
  for (int i=n-1; i>=0; --i) {
	  int p = 1;
	  int j = 0;
	  int best = 0;
	  while (true) {
		  int c = in.read();
		  if (c == 13 || c < 0) break; else j++;
		  int g = get((p<<8)+c);
		  while (p>1 && g<0) {
			  p = per[p];
			  g = get((p<<8)+c);
		  }
		  if (g>=0) p = g; else p = 1;
		  if (len[p]>0) 
			  if (best==0) best = j-len[p]+1; else best = Math.min(best, j-len[p]+1);		  
	  }
	  in.read();
	  if (best>0) {
		  out.print((n-i)+" "+best);
		  out.close();
		  return;
	  }	  
  }
  out.print("Passed");  
  out.close();
}

}
