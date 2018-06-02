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


int nextInt(String s, int p) {
	int pp = p;
	int res = 0;
	while (p<s.length() && Character.isDigit(s.charAt(p))) {
		res = 10*res+s.charAt(p)-'0';
		p++;
	}
	if (pp==p) return 1;
	return res;
}
String noSp(String s) {
	String res = "";
	for (char c:s.toCharArray()) 
		if (c!=' ') res += c;
	return res;
}
class Term implements Comparable{
	int[] a;	
	int st,cof;
	Term(Term t1, Term t2) {
		a = new int[26];
		for (int i=0; i<26; i++)
			a[i] = t1.a[i]+t2.a[i];
		cof = t1.cof*t2.cof;
		st = t1.st+t2.st;
	}
	Term(String s,boolean zn) {
		s = s.trim();
		a = new int[26];
		for (char c = 'a'; c<='z'; c++) {
			int p = s.indexOf(c);
			while (p>=0) {
				a[c-'a'] += nextInt(s,p+2);
				p = s.indexOf(c, p+1);
			}
		}
		st = 0;
		for (int i=0; i<26; i++) st += a[i];
		cof = nextInt(s,0);
		if (!zn) cof *= -1;
	}
	public int compareTo(Object arg0) {
		Term t = (Term) arg0;
		if (st!=t.st) return t.st-st;
		for (int i=0; i<26; i++)
			if (a[i]!=t.a[i]) return t.a[i]-a[i];
		return 0;
	}
	public String toString() {
		String res = "";
		if (st==0) return res+Math.abs(cof);
		boolean f = false;
		if (Math.abs(cof)!=1) {res += ""+Math.abs(cof); f = true; }	
		for (int i=0; i<26; i++)
			if (a[i]>0){
				if (f) res += "*"; else f = true;
				res += (char)('a'+i);
				if (a[i]>1) res += "^"+a[i];				
			}
		return res;		
	}
	boolean minus() { return cof<0; }
	
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  String s1 = in.nextLine();
  Vector<Term> v1 = new Vector<Term>();
  String s2 = in.nextLine();
  s1 = noSp(s1); s2 = noSp(s2);
  Vector<Term> v2 = new Vector<Term>();
  if (s1.charAt(0)!='-') s1 = "+"+s1;
  if (s2.charAt(0)!='-') s2 = "+"+s2;
  StringTokenizer st1 = new StringTokenizer(s1,"-+",true);
  while (st1.hasMoreTokens()) {
	  String z = st1.nextToken();
	  String s = st1.nextToken();
	  v1.add(new Term(s,z.equals("+")));
  }
  StringTokenizer st2 = new StringTokenizer(s2,"-+",true);
  while (st2.hasMoreTokens()) {
	  String z = st2.nextToken();
	  String s = st2.nextToken();
	  v2.add(new Term(s,z.equals("+")));
  }
/*  for (Term t:v1) out.print(t+" ");
  out.println();  
 
  for (Term t:v2) out.print(t+" ");*/
  Vector<Term> v = new Vector<Term>();
  for (Term t1:v1)
	  for (Term t2:v2) 
		  v.add(new Term(t1,t2));		  
  Term[] a = v.toArray(new Term[0]);
  v.clear();
  Arrays.sort(a);
  int n = a.length; 
  int p = 0;
  while (p<n) {
	  Term t = a[p];
	  int i = p+1;
	  while (i<n && a[i].compareTo(t)==0) {
		  t.cof += a[i].cof;
		  i++;
	  }
	  if (t.cof!=0) v.add(t); 
	  p = i;
  }
  a = v.toArray(new Term[0]);
  n = a.length;
  if (n==0) out.print(0); else {
	  if (a[0].minus()) out.print("-");
	  out.print(a[0]);
	  for (int i=1; i<n; i++) {
		  if (a[i].minus()) out.print(" - "); else out.print(" + ");
		  out.print(a[i]);
	  }
  }
  in.close(); out.close();  
}
}


