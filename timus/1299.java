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
long energy, ammo, enemy, enemyenergy,angle,frend,frendenergy,P,X;
char behavor;
void left() {
	out.print("LEFT "+X);
}
void right() {
	 out.print("RIGHT "+X);
}
void front() {
	out.print("FRONT "+X);	
}
void backward() {
	out.print("BACKWARD "+X);	
}
void fire() {
	out.print("FIRE "+P);	  
}
void guard() {
	 if (enemy==0) 
		  out.print("STOP");
	  else {	  
		  if (Math.abs(angle)<5) fire();
		  if (angle>=5) left();
		  if (angle<=-5) right();
	  }	
}
void defence() {
	if (enemy*20>=ammo) otstup(); else guard();
}
void otstup() {
	if (Math.abs(angle)<5 && enemy>0) fire(); else backward();	
}
void nastup() {
	if (Math.abs(angle)<10 && enemy>0) fire(); else front();	
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  energy = in.nextInt();
  ammo = in.nextInt();
  X = Math.min(100, energy);
  P = Math.min(20, ammo);
  behavor = in.next().charAt(0);
  enemy = in.nextInt();
  enemyenergy = in.nextInt();
  angle = in.nextInt(); 
  if (behavor=='A') {
	  frend = in.nextInt();
	  frendenergy = in.nextInt();
  }
  long angleP = 0;
  if (behavor=='P') angleP = in.nextInt();
  if (behavor=='G') guard();
  if (behavor=='D') defence();	
  if (behavor=='A')
	  if (frend*frendenergy>enemy*enemyenergy*3) nastup(); else otstup();
  if (behavor=='P') 
	  if (enemy>0) defence(); else {
		  if (angleP<0) angleP += 360;
		  if (angleP<=20) front(); else
			  if (angleP<=90) left(); else
				  if (angleP<160) right(); else
					  if (angleP<=200) backward(); else
						  if (angleP<270) left(); else
							  if (angleP<340) right(); else front();
	  }  
  in.close(); out.close();  
}
}


