import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
public static void main(String[] args) throws IOException {	new Main().run();}
Scanner in;
PrintWriter out;
int Sum(int x){
	int res = 0;
	while (x>0) {
		res += x % 10;
		x /= 10;
	}
	return res;
}

void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out);
  int n = in.nextInt(), n1 = n+1, n2 = n - 1;
  if (Sum(n1/1000)==Sum(n1%1000) || Sum(n2/1000)==Sum(n2%1000)) out.print("Yes"); else out.print("No");
  out.flush(); 
}


}