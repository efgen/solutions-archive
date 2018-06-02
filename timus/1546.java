import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	class Str implements Comparable<Str>{
		String s;
		int df;
		Vector<String> v = new Vector<String>();
		public Str(String ss) {
			s = ss;
			if (ss.length()==0) return;
			StringBuilder sb = new StringBuilder();
			if (!Character.isDigit(ss.charAt(0))) df = 1;  
			for (int i=0; i<ss.length(); ) {
				int j = i;
				while (j<ss.length() && Character.isLetter(ss.charAt(j))) {
					sb.append(ss.charAt(j));
					j++;
				}
				if (sb.length()>0) {
					v.add(sb.toString());
					sb.setLength(0);
				}
				if (j<ss.length() && ss.charAt(j)=='0') {
					while (j<ss.length() &&ss.charAt(j)=='0') {
						j++;
					}
					while (j<ss.length() && Character.isDigit(ss.charAt(j))) {
						sb.append(ss.charAt(j));
						j++;
					}
					if (sb.length()==0) sb.append("0");
					
				} else {
					while (j<ss.length() && Character.isDigit(ss.charAt(j))) {
						sb.append(ss.charAt(j));
						j++;
					}
				}
				if (sb.length()>0) {
					v.add(sb.toString());
					sb.setLength(0);
				}
				i = j;
			}
		}
		public int compareTo(Str p) {
			if (s.length()==0 && p.s.length()==0) return 0;
			if (s.length()==0) return -1;
			if (p.s.length()==0) return -1;
			if (df==p.df) {
				int n = Math.min(v.size(), p.v.size());
				int type = df;
				for (int i=0; i<n; i++) {
					if (type==0) {
						if (v.get(i).length()==p.v.get(i).length()) {
							int cmp = v.get(i).compareTo(p.v.get(i));
							if (cmp!=0) return cmp;
						} else return v.get(i).length()-p.v.get(i).length();
					} else {
						int cmp = v.get(i).compareTo(p.v.get(i));
						if (cmp!=0) return cmp;
					}
					type = 1-type;
				}
				if (v.size()>n) return 1;
				if (p.v.size()>n) return -1;
				n = Math.min(s.length(), p.s.length());
				for (int i=0; i<n; i++)
					if (s.charAt(i)!=p.s.charAt(i)) return s.charAt(i)-p.s.charAt(i);
				if (s.length()>n && s.charAt(n)=='0') return -1;
				if (p.s.length()>n && p.s.charAt(n)=='0') return 1;
				return 0;
			} return df-p.df;
		}
	}
    void solve() throws IOException {
    	Vector<Str> a = new Vector<Str>();
    	while (true) {
    		String line = br.readLine();
    		if (line==null) break;
    		a.add(new Str(line));
    	}
    	Collections.sort(a);
    	for (int i=0; i<a.size(); i++) out.println(a.get(i).s);
    	
    }
    
    


    static final int inf = 1000000000;
    static final double epd = 1e-8;
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
            new Solution().run();
    
    }
}