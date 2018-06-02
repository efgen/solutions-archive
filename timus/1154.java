import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}
int day = 24*60*60;
int[] maxt = new int[4];
int[] mint = new int[4];
int[] maxv = new int[4];
int[] minv = new int[4];
int[] tt = new int[4];
int[] rr = new int[4];
int time(String s) {
	int res = 0;
	StringTokenizer st = new StringTokenizer(s,":");
	res = (Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken()))*60+Integer.parseInt(st.nextToken());
	return res;
}
double power(int p, int t) {
	int t1 = (day+maxt[p]-t)%day;
	int t2 = (day+mint[p]-t)%day;
	if (t1<t2) 
		return maxv[p] - 1.0*rr[p]*t1/tt[p];
	else
		return minv[p] + 1.0*rr[p]*t2/(day-tt[p]);
}
void proc(String s) {
	StringTokenizer st = new StringTokenizer(s," ");
	char c = st.nextToken().charAt(0);
	int p = 0;
	if (c=='E') p = 1; else
		if (c=='F') p = 2; else 
			if (c=='W') p = 3;
	maxt[p] = time(st.nextToken());
	maxv[p] = Integer.parseInt(st.nextToken());
	mint[p] = time(st.nextToken());
	minv[p] = Integer.parseInt(st.nextToken());
	tt[p] = (day+maxt[p]-mint[p])%day;	
	rr[p] = maxv[p]-minv[p];
}
String norm(int x) {
	String s = ""+x;
	if (s.length()<2) s = "0"+s;
	return s;
}
String toTime(int x) {
	String s = ":"+norm(x%60); x /= 60;
	s = ":"+norm(x%60)+s; x /= 60;
	s = norm(x)+s;
	return s;
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  proc(in.nextLine());
  proc(in.nextLine());
  proc(in.nextLine());
  proc(in.nextLine());
  int[] L = new int[4];
  int[] D = new int[4];
  String s = in.nextLine();
  for (char c:s.toCharArray()) {
	  int p = 0;
		if (c=='E') p = 1; else
			if (c=='F') p = 2; else 
				if (c=='W') p = 3;
		L[p]++;	  
  }
  s = in.nextLine();
  for (char c:s.toCharArray()) {
	  int p = 0;
		if (c=='E') p = 1; else
			if (c=='F') p = 2; else 
				if (c=='W') p = 3;
		D[p]++;	  
  }
  double eps = 1e-9;
  int best = -1;
  double maxp = 0;
  for (int t=0; t<day; t++) {
	  double pow = 0;
	  for (int i=0; i<4; i++) 
		  pow += (L[i]-D[i])*power(i,t);
	  if (pow>maxp+eps) {
		  best = t;
		  maxp = pow;
	  }
  }
  if (best<0) out.println("We can't win!"); 
  else {
	  out.println(toTime(best));
	  out.printf(Locale.US,"%1.2f",maxp);
  }
  in.close(); out.close();  
}
}


