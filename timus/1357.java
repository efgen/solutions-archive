import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

int nextTime() {
	StringTokenizer st = new StringTokenizer(in.nextLine(),":");
	int x = (int)Integer.parseInt(st.nextToken())*3600+(int)Integer.parseInt(st.nextToken())*60+(int)Integer.parseInt(st.nextToken());
//	out.println(x);
	return x;
}
void printTime(int t){
	t = t % (24*3600);
	int h = t / 3600; t = t % 3600;
	int m = t / 60; 
	int s = t % 60;
	if (h<10) out.print("0"+h); else out.print(h); out.print(":");
	if (m<10) out.print("0"+m); else out.print(m); out.print(":");
	if (s<10) out.print("0"+s); else out.print(s); out.println();
	
}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);  
  int n = in.nextInt(); in.nextLine();
  int[] a = new int[n+2];
  for (int i=1; i<=n; i++) a[i] = nextTime();
  int  wait = 0, users = 0, p=1;
  double T = 0;
  for (int time=0; time<24*60*60*1000; time++) {
	  if (a[p]==time && p<=n) {wait++; p++;}
	  if (users>0) {
		  T += 2000.0/(4190.0*users); 
		  if (T>=100.0) {
			  while (users-->0) printTime(time);
			  users = 0;
		  }
	  }
	  if (wait>0) 
		  while (users<5 && wait>0) {	
			  if (users==0) T = 20.0; else T = (users*T+20.0)/(users+1); 
			  users++;
			  wait--;		
		  }	  
  }
  in.close();  out.close();
}

}