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
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  in.nextLine(); in.nextLine(); in.nextLine();
  double f1 = 0, f2 = 0, t1 = 0, t2 = 0;  
  StringTokenizer st;
  
  st = new StringTokenizer(in.nextLine(),"^\'\" ");
  t1 = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())/60.0+Integer.parseInt(st.nextToken())/3600.0;
  if (st.nextToken().charAt(0)=='S') t1 = -t1;
  t1 = Math.PI/2 - Math.PI*t1/180.0;  
  
  st = new StringTokenizer(in.nextLine(),"^\'\" "); st.nextToken();
  f1 = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())/60.0+Integer.parseInt(st.nextToken())/3600.0;
  if (st.nextToken().charAt(0)=='W') f1 = -f1;
  f1 = Math.PI*f1/180.0;
  
  in.nextLine();
  
  st = new StringTokenizer(in.nextLine(),"^\'\" ");
  t2 = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())/60.0+Integer.parseInt(st.nextToken())/3600.0;
  if (st.nextToken().charAt(0)=='S') t2 = -t2;
  t2 = Math.PI/2 - Math.PI*t2/180.0;
  
  st = new StringTokenizer(in.nextLine(),"^\'\" "); st.nextToken();
  f2 = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())/60.0+Integer.parseInt(st.nextToken())/3600.0;
  if (st.nextToken().charAt(0)=='W') f2 = -f2;
  f2 = Math.PI*f2/180.0;
  
  double R = 6875;
  double x1 = R*Math.sin(t1)*Math.sin(f1);
  double y1 = R*Math.sin(t1)*Math.cos(f1);
  double z1 = R*Math.cos(t1);
  double x2 = R*Math.sin(t2)*Math.sin(f2);
  double y2 = R*Math.sin(t2)*Math.cos(f2);
  double z2 = R*Math.cos(t2);
  double d = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)+(z1-z2)*(z1-z2));
  d = R*Math.asin(d/(2*R));
  out.printf(Locale.US,"The distance to the iceberg: %1.2f miles.\n",d);
  if (100.00-d>0.005) out.println("DANGER!");
  in.close(); out.close();
}

}
