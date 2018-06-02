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


long A, B, Sol, Lb;

long elem(long l, long p) {
	return ((l - 1) * (l - 1) + p);
}

long line(long x){
	double sq = Math.sqrt(x);
	return (sq == (long)sq) ? (long)sq : (long)sq + 1;
}

int direction(long x)  
{
	long l, jos;

	l = line(x);
	x -= (l - 1) * (l - 1);
	jos = elem(Lb, x + Lb - l);

	if (jos>B) return 1; else return 0;
}

long left(long x)
{
	double sq = Math.sqrt(x - 1);
	return (sq != (long)sq) ? x - 1 : 0;
}

long right(long x)
	{
	double sq = Math.sqrt(x);
	return (sq == (long)sq) ? 0 : x + 1;
}

long down(long x)
{
	return x + 2 * line(x);
}



public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  long al, d = 0;
  A = in.nextLong();
  B = in.nextLong();

	
	if (A > B) {
		al = B; B = A; A = al;
	}

	Lb = line(B); al = line(A);
	
	boolean s = A%2==1 && al%2==1;
	s |= A % 2 == 0 && al % 2 == 0;
	int S = 0;
	if (s) S = 1;
	if (al == Lb) S = 2;

	for (Sol = 0; A != B; Sol++)
	{
		al = line(A); d = direction(A);
		if (al != Lb && S!=0)
			A = down(A);
		else
		if (S==0 || S == 2)
			A = d!=0 ? left(A) : right(A);

		S = (al != Lb) ? 1 - S : 2;
	}

	out.println(Sol);    
  in.close(); out.close();  
}
}



