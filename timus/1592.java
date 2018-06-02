import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}
int nextTime() throws IOException {
	StringTokenizer st = new StringTokenizer(br.readLine(),":");
	int res = Integer.parseInt(st.nextToken());
	if (res==12) res = 0;
	String s = st.nextToken(); if (s.charAt(0)=='0') s = s.substring(1);
	res = 60*res+Integer.parseInt(s);
	s = st.nextToken(); if (s.charAt(0)=='0') s = s.substring(1);
	res = 60*res+Integer.parseInt(s);
	return res;
}
String timeToString(int x) {
	int sec = x%60; x /= 60;
	int min = x%60;
	int h =x/60;
	if (h==0) h = 12;
	String s = h+":";
	if (min<10) s +="0";
	s += min+":";
	if (sec<10) s +="0";
	s += sec+"";
	return s;
	
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = Integer.parseInt(br.readLine());
  int[] a = new int[n];
  for (int i=0; i<n; i++) a[i] = nextTime();
  Arrays.sort(a);
  int t = a[n-1];
  long time = 0;
  for (int x:a) time += t-x;
  int p = n-1;
  int D = 12*60*60;
  long bestTime = time;
  int res = t;
  while (t>0) {
	  time -= n;
	  while (p>=0 && a[p]==t) {
		  p--;
		  time += D;
	  }
	  t--;
	  if (time<bestTime) {
		  bestTime = time;
		  res = t;
	  }	  
  }
  out.print(timeToString(res));
  out.close();    
}   
  
}




