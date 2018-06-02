#include <string>      
#include <vector>      
#include <cmath>      
#include <queue>      
#include <set>      
#include <stack> 
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
 
using namespace std;      
double cab[200];
double rab[200];
int x[200];
int y[200];
double a[100];
int main(){      
   
	int n,m,s;
	double V;
	cin >> n >> m >> s >> V;
	for (int i=1; i<=n; i++) a[i] = 0;
	a[s] = V;
	
	forn(i,m) {
		cin >> x[i] >> y[i] >> rab[i] >> cab[i] >> rab[i+m] >> cab[i+m];
		x[i+m] = y[i];
		y[i+m] = x[i];
	}
	m *= 2;
	n *= 25;
	forn(kk,n)
		forn(i,m) {
			double v = a[x[i]];
			v -= cab[i];
			v *= rab[i];
			if (v>a[y[i]]) a[y[i]] = v;
		}
	if (a[s]>V) cout << "YES"; else cout << "NO";
    return 0;      
}  
