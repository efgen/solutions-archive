#include <string>      
#include <vector>      
#include <cmath>      
#include <queue>      
#include <set>      
#include <map>      
#include <algorithm>      
#include <iostream>      
#include <cstdio>      
#include <sstream>      
  
#define sz(a) ((int)(a).size())   
#define forn(i, n) for (int i = 0; i < (int)(n); ++i)      
#define forv(i, v) for (int i = 0; i < sz(v); ++i)      
#define fors(i, s) for (int i = 0; i < (int)(s.length()); ++i)      
#define fe(it,a) for(typeof(a.begin()) it = a.begin(); it != a.end(); it++)   
#define all(a) (a).begin(), (a).end()      
#define pb push_back      
#define PII pair<int, int>      
#define mp make_pair      
#define VI vector<int>      
#define VS vector<string>   
#define LL long long 
#define min(a,b) ((a<b):a:b)   
using namespace std;      

double sq(double x) { return x*x; }

int main(){      

	double w,h,x,y,xn,yn;
	cin >> w >> h >> x >> y >> xn >> yn;
	string s;
	cin >> s;
	y = h-y;
	yn = h-yn;
	fors(i,s) {		
		if (s[i]=='F') {
			y = h+h-y;
		} else
		if (s[i]=='L') {
			x *= -1;
		} else
		if (s[i]=='R') {
			x = w+w-x;
		} else {
			y *= -1;
		}
	}
	printf("%1.4f",sqrt(sq(x-xn)+sq(y-yn)));

    return 0;      
}  
