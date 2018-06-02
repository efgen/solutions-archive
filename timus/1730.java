import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   

int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}

long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
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
//    	br = new BufferedReader(new FileReader(new File(filename+".in")));
//   	out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
//    	br = new BufferedReader(new FileReader(new File("input.txt")));
//    	out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
    	
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();        
    
    }         
    catch (IOException e) {        
    	throw new IllegalStateException(e);       
    }      
}
int gcd(int a, int b) {
	if (b==0) return a; else return gcd(b, a%b);
}
public void solve() throws IOException {
	String[] names = br.readLine().split("-");
	String[] vals = br.readLine().split(" ");
	int n = vals.length;
	int[] a = new int[n];
	int[] b = new int[n];
	int d = 1;
	for (int i=0; i<n; i++) {
		String[] sss = vals[i].split("/");
		a[i] = Integer.parseInt(sss[0]);
		b[i] = Integer.parseInt(sss[1]);
		int dd = gcd(a[i], b[i]);
		a[i] /= dd;
		b[i] /= dd;
		if ((b[i]&(b[i]-1))!=0) {
			out.println("No solution");
			return;
		}
		d = Math.max(d, b[i]);		
	}
	for (int i=0; i<n; i++) {
		int t = d/b[i];
		b[i] *= t; a[i] *= t;
	}
	Stack<Vector<String>> st = new Stack();
	for (int t=d; t>0; t>>=1) {
		Vector<String> cur = new Vector<String>();
		for (int i=0; i<n; i++)
			if (a[i]>=t) {
				a[i] -= t;
				cur.add(names[i]);
			}
		st.push(cur);		
	}
	Vector<String> res = new Vector<String>();
	int nums = 1;
	TreeSet<Integer> old = new TreeSet<Integer>();
	while (!st.isEmpty()) {
		Vector<String> cur = st.pop();
		for (String ss : cur) res.add(ss);
		for (int i=0; i<cur.size(); i++)
			old.add(nums++);
		TreeSet<Integer> newold = new TreeSet<Integer>();
		while (old.size()>1) {
			res.add(old.pollFirst()+" "+old.pollFirst());
			newold.add(nums++);
		}
		old = newold;		
	}
	out.println(res.size());
	for (String ss:res) out.println(ss);
}
}





