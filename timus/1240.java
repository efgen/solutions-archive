import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main {   
BufferedReader br;
Scanner in;   
PrintWriter out;   
int inf = 1000000000;
public static void main(String[] args) throws IOException {   
new Main().run();   
}   

byte[][][][] a;
int n, hp, mp, hpm, nm, v, dh,h,maxhp;
int[] L;
byte CL, CH;
int[] u;
boolean canWinM(int hp, int mp, int p, int h) {
	if (h<=0) return true;
	p-=v; if (p<1) p = 1;
	if (p==1) hp -= u[h];	
	return canWinH(hp,mp,p,h);
}
boolean canWinH(int hp, int mp, int p, int h) {
	if (hp<=0 || mp<=0) return false;	
	if (a[hp][mp][p][h]==0) {
		if (canWinM(hp,mp-1,p,h-L[p])) {
			a[hp][mp][p][h] = CL;
			return true;
		}		
		for (byte i=1; i<=n; i++) 
			if (canWinM(hp,mp-1,i,h)) {
				a[hp][mp][p][h] = i;
				return true;
			}
		if (canWinM(Math.min(hp+dh, maxhp),mp-1,p,h)) {
			a[hp][mp][p][h] = CH;
			return true;
		}
	}	
	a[hp][mp][p][h] = -1;
	return false;
}
public void run() throws IOException {  
 // br = new BufferedReader(new FileReader("input.txt"));
 // in = new Scanner(br); in.useLocale(Locale.US);
  in = new Scanner(new InputStreamReader(System.in));
 // out = new PrintWriter(new File("output.txt"));
  out = new PrintWriter(System.out);
  n = in.nextInt();
  CL = 11; CH = 12;
  hp = in.nextInt();
  mp = in.nextInt();
  hpm = in.nextInt();
  nm = in.nextInt();
  v = in.nextInt();
  dh = in.nextInt();
  L = new int[n+1];
  for (int i=1; i<=n; i++) L[i] = in.nextInt();
  h = hpm*nm;
  a = new byte[hp+1][mp+1][n+1][h+1];
  maxhp = hp;
  u = new int[h+1];
  for (int i=1; i<=h; i++) {
	  u[i] = u[i-1];
	  if ((i-1)%hpm==0) u[i]++;
  }
	  
  if (canWinH(hp,mp,n,h)) {
	  out.println("VICTORIOUS");
	  int p = n;
	  while (h>0) {
		  int hod = a[hp][mp][p][h];
		  if (hod<=n) {
			  out.println("T "+hod);
			  mp--; p = hod;
		  }
		  if (hod==CL) {
			  out.println("L");
			  mp--; h -= L[p];
		  }
		  if (hod==CH) {
			  out.println("H");
			  mp--; hp = Math.min(maxhp, hp+dh);
		  }
		  p = Math.max(1, p-v);
		  if (p==1) hp -= Math.ceil(1.0*h/hpm);
	  }	  
	  
  } else out.print("DEFEATED");  
  out.flush();
}   
 
}   