#include <iostream>   
#include <string>  
#include <vector>  
#include <stdio.h>  

#define forn(i, n) for (int i=0; i<n; i++)
#define forv(i, v) for (int i=0; i<(int)(v.size()); i++)
#define pb push_back
#define next huipizda

using namespace std;
struct edge {
	int x, cup, flow;
};
const int maxn = 10000;
const int maxm = maxn*6+10;
edge e[maxm];
int next[maxm];
int head[maxn];
int cur[maxn];
int d[maxn];
int Q[maxn];
int gsz = 0;

inline int min(int x, int y) {
	if (x<y) return x; else return y;
}
void add(int x, int y, int c) {
	edge e1 = {y, c, 0};
	edge e2 = {x, c, 0};
	next[gsz] = head[x];
	e[gsz] = e1;
	head[x] = gsz++;


	next[gsz] = head[y];
	e[gsz] = e2;
	head[y] = gsz++;
}
int n, m, S, T;
int dfs(int v, int df) {
	if (v==T) return df;
	for (int &i=cur[v]; i>=0; i = next[i])
		if (e[i].flow<e[i].cup && d[e[i].x] == d[v]+1) {
			register int val = dfs(e[i].x, min(df, e[i].cup-e[i].flow));
			if (val > 0) {
				e[i].flow += val;
				e[i^1].flow -= val;
				return val;
			}
		}
	return 0;
}
int maxFlow() {
	int res = 0;
	while (true) {
	int qs = 0, qt = 0;
		memset(d, -1, n*sizeof(d[0]));
		d[S] = 1;
		Q[qt++] = S;
		while (qs<qt) {
			int v = Q[qs++];		
			for (int i=head[v]; i>=0; i = next[i])
				if (e[i].flow<e[i].cup)
					if (d[e[i].x]==-1) {
						d[e[i].x] = d[v]+1;
						Q[qt++] = e[i].x;
					}
		}
		if (d[T]==-1) return res;
		forn(i, n) cur[i] = head[i];
		while (true) {
			int t = dfs(S, 100000000);
			if (t>0) res += t; else break;
		}
	}
}
int main()   
{   
   // freopen("input.txt", "rt", stdin);   
  //  freopen("output.txt", "wt", stdout);   
	scanf("%d", &n);
	int xxx, yyy, x, y, c;
	forn(i, n) scanf("%d%d",&xxx, &yyy);
	scanf("%d", &m);
	forn(i, n) head[i] = -1;
	forn(i, m) {
		scanf("%d%d%d", &x, &y, &c);
		x--; y--;
		add(x, y, c);
	}
	S = 0, T = n-1;
	printf("%d\n", maxFlow());
	forn(i, n)
		for (int j=head[i]; j>=0; j = next[j]) 
			if (e[j].flow>0 || (e[j].flow==0 && i<e[j].x)) 
				printf("%d %d %d\n", i+1, e[j].x+1, e[j].flow);
	
    return 0;   
}  