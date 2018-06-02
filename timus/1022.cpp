#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <stack>
#include <math.h>
#include <stdio.h>
using namespace std;

int k,n,x;
bool a[111][111];
vector<int> res;
bool f[111];
void dfs(int v) 
{
	f[v] = true;
	for (int i=1; i<=n; i++) 
		if (!f[i] && a[v][i]) dfs(i);
	res.push_back(v);	
	return;
}

int main()
{
	#ifndef ONLINE_JUDGE
	freopen("input.txt", "rt", stdin);
	freopen("output.txt", "wt", stdout);
	#endif
	cin >> n;
	for (int i=1; i<=n; i++)
		for (int j=1; j<=n; j++)
			a[i][j] = false;
	for (int i=1; i<=n; i++) f[i] = false;
	for (int i=1; i<=n; i++) 
	{
		do {
			cin >> x;
			a[i][x] = true;
		} while (x>0);
	}
	for (int i=1; i<=n; i++)
		if (!f[i]) dfs(i);
	int k = (int)res.size();
	while (k>0) cout << res[--k] << " ";
	return 0;
}