import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

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
    	br = new BufferedReader(new InputStreamReader(System.in));        
    	out = new PrintWriter(System.out);
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

HashMap<String, Integer> names = new HashMap<String, Integer>();
TreeMap<String, Integer> cities = new TreeMap<String, Integer>();
long[] bablo = new long[10000]; 
int[] pos = new int[10000];
long[] babloc = new long[60000];
int[] cntbest = new int[60000];
class Point implements Comparable<Point>{
	long val;
	int id;
	public Point(long v, int i) {
		val = v; id = i;
	}

	public int compareTo(Point p) {
		if (val==p.val) return id-p.id;
		return Long.valueOf(val).compareTo(p.val);
	}
}
TreeSet<Point> t = new TreeSet<Point>();
int getid(String s) {
	Integer id = cities.get(s);
	if (id==null) {
		int k = cities.size();
		cities.put(s, k);
		return k;
	}
	return id;
}
int getBest() {
	Point p1 = t.last();
	if (p1==null) return -1;
	Point p2 = t.lower(p1);
	if (p2==null) return p1.id;
	if (p2.val<p1.val) return p1.id;
	return -1;	
}
public void solve() throws IOException {
	int peoples = Integer.parseInt(br.readLine());
	for (int p=0; p<peoples; p++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		String name = st.nextToken();
		String city = st.nextToken();
		Long val = Long.parseLong(st.nextToken());
		names.put(name, p);
		bablo[p] = val;
		int t = getid(city);
		babloc[t] += val;	
		pos[p] = t;
	}
	for (int i=0; i<cities.size(); i++) if (babloc[i]>0) t.add(new Point(babloc[i], i));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int days = Integer.parseInt(st.nextToken());
	int qq = Integer.parseInt(st.nextToken());
	int lastday = 0; 
	for (int q=0; q<qq; q++) {
		st = new StringTokenizer(br.readLine());
		int day = Integer.parseInt(st.nextToken());
		if (day!=lastday) {
			int v = getBest();
			if (v>=0) {
				cntbest[v] += day-lastday;
			}
			lastday = day;
		}
		int p = names.get(st.nextToken());
		int t1 = pos[p];
		int t2 = getid(st.nextToken());
		Point p1 = new Point(babloc[t1], t1);
		Point p2 = new Point(babloc[t2], t2);
		t.remove(p1);
		t.remove(p2);
		babloc[t1] -= bablo[p];
		babloc[t2] += bablo[p];
		pos[p] = t2;
		p1 = new Point(babloc[t1], t1);
		p2 = new Point(babloc[t2], t2);
		if (p1.val>0) t.add(p1); t.add(p2);		
		
	}
	int day = days;
	if (day!=lastday) {
		int v = getBest();
		if (v>=0) {
			cntbest[v] += day-lastday;
		}
		lastday = day;
	}
	for (String s:cities.keySet()) {
		int i = cities.get(s);
		if (cntbest[i]>0) out.println(s+" "+cntbest[i]);
	}
}
}











