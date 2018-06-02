import java.io.*;         
import java.util.*;         
import java.math.*;         
        
public class Main implements Runnable  {   


StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
    new Thread(new Main()).start();      
}      
public void run()  {      
    try {      
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
    //	br = new BufferedReader(new FileReader("input.txt"));      
     //  out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
  //  	out = new PrintWriter(System.out);    	
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Rec implements Comparable {
	int x, y, p;

	Rec(int xx, int yy ,int pp) {
		x = xx; p = pp; y = yy;
	}
	public int compareTo(Object arg0) {
		Rec r = (Rec) arg0;
		if (x==r.x) return p-r.p;
		return x-r.x;
	}
	public String toString() {
		return x+" "+p;
	}
}
class Data implements Comparable {
	int x, p;

	Data(int xx, int pp) {
		x = xx; p = pp;
	}
	public int compareTo(Object arg0) {
		Data r = (Data) arg0;
		if (x==r.x) return p-r.p;
		return x-r.x;
	}
	public String toString() {
		return x+" "+p;
	}
}
public void solve() throws IOException {
	nextInt();
	int m = nextInt();
	int k = nextInt();
	int P = nextInt();
	Rec[] a = new Rec[2*k];
	for (int i=0; i<k; i++) {
		int x = nextInt();
		int y = nextInt();
		a[i] = new Rec(x,y,i+1);
		a[i+k] = new Rec(y,x,-i-1);
	}
	Arrays.sort(a);
	TreeSet<Data> t = new TreeSet<Data>(); 
	Vector<Integer> res = new Vector<Integer>();
	for (Rec r:a) {
		
		while (!t.isEmpty() && t.first().x==r.x) {
			Data d = t.first();
			res.add(d.p);
			t.remove(d);
			//res.add(t.pollFirst().p);
		}
		if (r.p>0) {		
			if (t.size()<m) t.add(new Data(r.y,r.p)); else
				if (!t.isEmpty() && t.last().x>r.y) {
					Data d = t.last();
					t.remove(d);
				//	t.pollLast();
					t.add(new Data(r.y,r.p));
				}
		} 
	}
	out.println(res.size()*P);
	for (int x:res) out.print(x+" ");
	
	
}      
} 



















