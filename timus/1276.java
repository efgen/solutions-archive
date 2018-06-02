import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";
	class Point {
		int[] a = new int[4];
		int pr;
		public Point() {
			
		}
		public Point(int x, int[] a) {
			pr = x;
			this.a = a.clone();
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;						
			for (int i=0; i<a.length; i++) result = prime * result + a[i];
			result = prime * result + pr;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (pr != other.pr)
				return false;
			for (int i=0; i<a.length; i++) if (a[i]!=other.a[i]) 
				return false;			
			return true;
		}	
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(pr);
			sb.append(" (");
			for (int i=0; i<4; i++) {
				sb.append(a[i]);
				sb.append(" ");
			}
			sb.append(")");
			return sb.toString();
		}
	}
	
    void solve() throws IOException {
    	int n = nextInt();
    	int k = nextInt();
    	Point p = new Point();
    	String loc = next();
    	for (int i=0; i<n; i++) {
    		String s = next();
    		int x = 0;
    		if (s.charAt(0)=='B') x += 2;
    		if (s.charAt(1)=='B') x += 1;
    		p.a[x]++;
    	}
    	p.pr = loc.charAt(1)=='A'?0:1;
    	HashMap<Point, Long> map = new HashMap<Point, Long>();
    	map.put(p, 1l);
    	while (k-->0) {
    		HashMap<Point, Long> map2 = new HashMap<Point, Long>();
    		for (Point pos:map.keySet()) 
    			if (pos.pr==0) {
    				for (int i=0; i<2; i++)
    					if (pos.a[i]>0) {
    						Point newpos = new Point(i&1, pos.a);
    						newpos.a[i]--;
    						if (map2.containsKey(newpos)) 
    							map2.put(newpos, map2.get(newpos)+map.get(pos));
    						else
    							map2.put(newpos, map.get(pos));
    					} 
    			} else {
    				for (int i=2; i<4; i++)
    					if (pos.a[i]>0) {
    						Point newpos = new Point(i&1, pos.a);
    						newpos.a[i]--;
    						if (map2.containsKey(newpos)) 
    							map2.put(newpos, map2.get(newpos)+map.get(pos));
    						else
    							map2.put(newpos, map.get(pos));
    					} 
    			}
    		map = map2;
    	//	System.gc();
    	}
    	int req = loc.charAt(0)=='A'?0:1;
    	long res = 0;
    	for (Point pos:map.keySet()) if (pos.pr==req) res += map.get(pos);
    	if (res==0) out.println("NO"); else {
    		out.println("YES");
    		out.println(res);
    	}
    }
    
    


    static final int inf = 1000000000;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
            //br = new BufferedReader(new FileReader(FileName+".in"));
            //out = new PrintWriter(FileName+".out");
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //br = new BufferedReader(new FileReader("input.txt"));
            //out = new PrintWriter("output.txt");
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                    return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
       return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
            return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
            return Long.parseLong(next());
    }

    public static void main(String[] args) {        
            new Task().run();
    
    }
}