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
    	//out = new PrintWriter(new File("output.txt"));
    //	br = new BufferedReader(new FileReader("input.txt"));      
     //  out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}


HashMap<String,TreeSet<Integer>> map = new HashMap<String,TreeSet<Integer>>();
HashMap<String, Integer> codes = new HashMap<String, Integer>();
Vector<String> names = new Vector<String>();
int code(String s) {
	if (!codes.containsKey(s)){
		codes.put(s, codes.size());
		names.add(s);
	}
	return codes.get(s);	
}
public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	while (n-->0) {
		StringTokenizer st = new StringTokenizer(br.readLine(),": ");
		String key = st.nextToken();
		TreeSet<Integer> t = new TreeSet<Integer>();
		while (st.hasMoreTokens()) t.add(code(st.nextToken()));
		if (map.containsKey(key)) map.get(key).addAll(t); else 
			map.put(key, t);
	}
	n = Integer.parseInt(br.readLine());
	while (n-->0) {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		String s = st.nextToken();
		t = map.get(s);
		while (t.size()>0 && st.hasMoreTokens()) {
			TreeSet<Integer> tt = map.get(st.nextToken());
			TreeSet<Integer> t2 = new TreeSet<Integer>();
			for (int x:tt)
				if (t.contains(x)) t2.add(x);
			t = t2; 
		}
		TreeSet<String> res = new TreeSet<String>();
		for (int x:t) res.add(names.elementAt(x));
		for (String ss:res) out.print(ss+" ");
		if (t.size()==0) out.print("No solution.");
		out.println();
	}
	
	
}
	
} 



















