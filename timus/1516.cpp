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
int a[16][16];
int x[24],y[24],c[24];
int n = 0;
int dx[] = {1,1,-1,-1};
int dy[] = {1,-1,-1,1};
bool dfs(int px, int py, int k) {
	if (k==0) return true;
	k--;
	forn(i,4) {
		int nx = px+dx[i];
		int ny = py+dy[i];
		if (nx>0 && ny>0 && a[nx][ny]==2 && !a[nx+dx[i]][ny+dy[i]]) {
			a[nx][ny] = 0;
			if (dfs(nx+dx[i],ny+dy[i],k)) return true;
			a[nx][ny] = 2;
		}
	}
	return false;		
}
inline int ed(int x) {
	int res = 0;
	while (x) {
		res++;
		x &= x-1;
	}
	return res;
}
int main(){      
  	
	char s[8];
	int res = 0, R = 0;
	forn(i,8) {
		scanf("%s",&s);
		forn(j,8) 
		if (s[j]=='W') {
			x[n] = i; y[n] = j; c[n] = 1; n++;
		} else
		if (s[j]=='B') {
			if (i==0 || j==0 || i==7 || j==7) {
				R++;
			} else {
				x[n] = i; y[n] = j; c[n] = 2; n++;
				res++;
			}
		}
	}
		
		
	int sz = 1<<n;	
	forn(i,9) a[i][8] = a[8][i] = a[i][9] = a[9][i] = -1;
	forn(msk,sz) {		
		int t = n-ed(msk);
		if (t>=res) continue;	
		
		forn(i,8) forn(j,8) a[i][j] = 0;
		int kw = 0, kb = 0;
		forn(i,n)
			if ((msk>>i)&1) {
				a[x[i]][y[i]] = c[i];
				if (c[i]==1) kw++; else kb++;
			}	
		if (kw==0) continue;		
		forn(i,n)
			if (c[i]==1 && (msk>>i)&1) {
				a[x[i]][y[i]] = 0;
				if (dfs(x[i],y[i],kb)) {
					res = t;
					break;
				}
				a[x[i]][y[i]] = 1;
			}	
	}
	cout << res+R;
    return 0;      
}  
