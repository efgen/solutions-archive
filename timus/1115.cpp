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
int n,m;
int a[10];
int x[100];
int ans[10][111];
int f[100];
bool solv(int t,int v) {
	if (v==0)  
		if (t==0) return true; else return solv(t-1,a[t-1]);	
	
		for(int i=n-1; i>=0; --i)
			if (!f[i] && x[i]<=v) {
				f[i] = 1;				
				if (solv(t,v-x[i])) {
					ans[t][++ans[t][0]] = x[i];
					return true;
				}
				f[i] = 0;
			}
	return false;
}
int main(){      
 //   freopen("input.txt","r",stdin);      
  //  freopen("output.txt","w",stdout); 
	scanf("%d%d",&n,&m);
	forn(i,n) scanf("%d",&x[i]);
	sort(x,x+n);
	forn(i,m) scanf("%d",&a[i]);
	forn(i,m) ans[i][0] = 0;
	forn(i,n) f[i] = 0;
	solv(m-1,a[m-1]);
	forn(i,m) {
		cout << ans[i][0] << endl;
		forn(j,ans[i][0]) cout << ans[i][j+1] << " ";
		cout << endl;
	}
    return 0;      
}  