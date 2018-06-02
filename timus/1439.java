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
boolean Find;
class Tree {
	int x,y, sz = 0;
	Tree L,R;
	void update() {		
		if (L!=null) sz = 1+L.sz+R.sz;
	}
	Tree[] split(int key) {
		Tree[] res;
		if (sz==0) {
			res = new Tree[2];
			res[0] = new Tree();
			res[1] = new Tree();
			return res;
		} else
		if (key<x) {
			res = L.split(key);
			L = res[1];
			res[1] = this;
		} else {
			res = R.split(key);
			R = res[0];
			res[0] = this;
		}
		res[0].update();
		res[1].update();		
		return res;
	}
	Tree merge(Tree t) {
		if (sz==0) return t;
		if (t.sz==0) return this;
		if (y>t.y) {
			R = R.merge(t);
			update();
			return this;
		}
		t.L = this.merge(t.L);
		t.update();
		return t;
	}
	void add(int key, int pr) {		
		if (pr>y || sz==0) {
			Tree tmp = new Tree();
			tmp.x = x;	tmp.y = y;	tmp.sz = sz;
			tmp.L = L; tmp.R = R;			
			Tree[] tt = tmp.split(key);
			L = tt[0]; R = tt[1];
			x = key; y = pr; sz = 1;		
		} else
		if (key<x) L.add(key, pr); else R.add(key, pr);
		update();		
	}
	void del(int key) {
		if (x==key) {
			Tree tmp =  L.merge(R);		
			x = tmp.x;
			y = tmp.y;
			sz = tmp.sz;
			L = tmp.L;
			R = tmp.R;			
		} else 
		if (key<x) L.del(key); else R.del(key);
		update();
	}
	int find(int k) {
		if (k==L.sz+1) return x;
		if (k<=L.sz) return L.find(k); else return R.find(k-L.sz-1);
	}
	int find2(int k){      
		if (R.sz>=k)return R.find2(k);else      
		if (R.sz==k-1) return x;      
		return L.find(k-R.sz-1);      
	} 
	void show() {
		if (sz==0) return;
		L.show();
		out.print(x+" ");
		R.show();
	}
	int less(int key) {
		if (sz==0) return 0;
		if (key==x) { Find=true; return L.sz;}else
			if (key<x) return L.less(key); else return L.sz+1+R.less(key);
	}
}
Tree t = new Tree(); 
int N;

int fac(int x){
	int L = x, R = Math.min(N,x+t.sz);
	while (L<R) {
		int mid = (L+R)>>1;
		Find = false;
		int r = mid-t.less(mid);
		if (r==x) {
			if (Find) L = mid+1; else return mid;
		} else
		if (r>x) R = mid-1; else L = mid+1;
	}
	return R;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out); 
  Random R = new Random(100);

  N = nextInt();
  int com = nextInt();
  while (com-->0) {
	  char c = next().charAt(0);
	  int x = nextInt();
	  x = fac(x);
	  if (c=='L') out.println(x); else t.add(x, R.nextInt()); //out.println("d" +x); }
  }
  out.close();    
}   
  
}




