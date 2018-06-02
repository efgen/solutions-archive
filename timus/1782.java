import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";  
 
    		
    
    void solve() throws IOException {   
    	Stack<String> res = new Stack<String>();
    	StringBuilder sb = new StringBuilder();
    	String s = br.readLine();
    	while (s.length()>6) {    		
    		int len = s.length();
    		boolean end = false;
    		for (int l=0; !end && l<3; l++)
    			for (int r=len-1; !end && r>=len-3; r--) {    				
    				if ((r-l+1)%2==1) continue;
    				boolean ok = true;
		    		for (int i=l; i<r; i+=2)
		    			if (!(s.charAt(i)=='0' ^ s.charAt(i+1)=='0')){
		    				ok = false;
		    				break;
		    			}
		    		if (ok) {
		    			if (l>=1) res.push("front "+s.charAt(0));
		    			if (l==2) res.push("front "+s.charAt(1));
		    			
		    			if (r<=s.length()-2) res.push("back "+s.charAt(s.length()-1));
		    			if (r==s.length()-3) res.push("back "+s.charAt(s.length()-2));
		    			
		    			res.add("double");
		    			for (int i=l; i<r; i+=2) if (s.charAt(i)=='0') sb.append('0'); else sb.append('1');
		    			s = sb.toString(); sb.setLength(0);
		    			end = true;
		    		} 
    			}
    	}
   		for (int i=0; i<s.length(); i++) res.push("front "+s.charAt(i));
    	if (res.size()>100) System.exit(123);
    	out.println(res.size());
    	while (!res.isEmpty()) out.println(res.pop());
    	
    	
    	
    }
   
    


    static final int inf = 1000000000;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
           // br = new BufferedReader(new FileReader(FileName+".in"));
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