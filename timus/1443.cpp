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

int main(){      
  //  freopen("input.txt","r",stdin);      
 //   freopen("output.txt","w",stdout); 
	LL n,S,L;
	long double s,l;
	cin >> n >> s >> l;
	S = floor(10000*s+1e-5);
	L = floor(10000*l+1e-5);
	
	LL ans  = n * (S/L);
	LL ras = n * (S/L);	
	LL res = 0;
	LL Q = S - ans/n*L;
	if (Q==0) ras -= n;
	forn(i,n) {
		
		if (Q>res) {
			ans++;
			res = L;
		}
		res = res-Q;
	}
	
	LL a = S, b = L;
	LL k = a;
	LL best = 1;	
	for (LL p = 1; p*p<=a; p++) 
	if (a%p==0){
		LL pp = a/p;
		if (p<=b && pp<k) {
			k = pp;
			best = p;
		}
		if (pp<=b && p<k) {
			k = p;
			best = pp;
		}
	}
	if (n*(k-1)<ras) {
		ans  = k;
	}
	cout << ans; 
    return 0;      
}  