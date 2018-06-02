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
class Tokenizer {
	int p;
	char[] a;	
	char token; // A..Z, (,), t - true, f - false, n - NOT, a - AND, o - OR 
	public Tokenizer(String s) {
		s += ".";
		a = s.toCharArray();
		p = 0;		
		next();
	}

	public void next() {
		while (a[p]==' ') p++;
		if (a[p]=='('||a[p]==')'||a[p]=='.') 
			token = a[p++];		
		else {
			int r = 0;
			while (Character.isLetter(a[p])) { p++; r++; }
			if (r==1) token = a[p-1]; else
				if (r==5) token = 'f'; else
					if (r==4) token = 't'; else
						if (a[p-1]=='R') token = 'o'; else
							if (a[p-1]=='T') token = 'n'; else
								if (a[p-1]=='D') token = 'a';// else
								//	System.out.println("ERROR");
		}
	//	System.out.println(token);
		
	}
}
Tokenizer lex;
Vector<Character> polis = new Vector<Character>();
class Val {
	
}
void prime() {
	if (lex.token=='(') {
		lex.next();
		exp();
		lex.next();
	} else 
	if ((lex.token<='Z' && lex.token>='A')||lex.token=='t'||lex.token=='f'){
		polis.add(lex.token);
		lex.next();
	} else 
	if (lex.token=='n') {
		lex.next();
		prime();
		polis.add('n');	
	} //else System.out.print("ERROR");
}
	
// Term = Prime And Prime
void term() {
	prime();
	while (lex.token=='a') {
		lex.next();
		prime();
		polis.add('a');
	}
}
// EXP = Term OR Term;
void exp() {
	term();
	while (lex.token=='o') {
		lex.next();
		term();
		polis.add('o');
	}
}
boolean[] a = new boolean[26];
boolean val(char c) {
	if (c=='t') return true; else
		if (c=='f')  return false; else 
			return a[c-'A'];
}
boolean calc() {
	Stack<Character> S = new Stack();
	boolean r;
	for (char c:polis) {
		if (Character.isUpperCase(c)||c=='t'||c=='f') S.push(c); else {
			if (c=='n') 
				r =!val(S.pop());				
			else
			if (c=='a') 
				r = val(S.pop())&val(S.pop());
			else
				r = val(S.pop())|val(S.pop());
			if (r) S.push('t'); else S.push('f');
		}			
	}		
	return val(S.pop());
	
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  lex = new Tokenizer(in.nextLine());
  exp();
 // out.print(polis);
  

 
  int n = in.nextInt();
  int m = in.nextInt();
  int k = in.nextInt();
  
  int[][] map = new int[2*n+1][2*n+1];
  while (m-->0) {
	  int x = in.nextInt()+n;
	  int y = in.nextInt()+n;
	  map[x][y] = -1;  
  }
  while (k-->0) {
	  int x = in.nextInt()+n;
	  int y = in.nextInt()+n;
	  map[x][y] = in.next().charAt(0)-'A'+1;
  }
  int x = n, y = n, dir = 0;
  int[] dx = {1,0,-1,0};
  int[] dy = {0,-1,0,1};
  while (true) {
	  out.println((x-n)+" "+(y-n));
	  if (map[x][y]>0) a[map[x][y]-1] = !a[map[x][y]-1];
	  if (map[x][y]<0) {
		  if (!calc())
			  dir--; 
		  else 
			  dir++;
		  dir = (4+dir)%4;
	  }
	  x += dx[dir];
	  y += dy[dir];
	  if (x<0 || y<0 || x==2*n+1 || y==2*n+1) break;
  }
  in.close(); out.close();  
}
}
