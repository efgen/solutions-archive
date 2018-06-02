#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<string> vs;
typedef vector<vector<int> > vvi;
typedef vector<ll> vl;
typedef vector<vector<ll> > vvl;

#define forn(i, n) for (int i = 0; i < (int)(n); i++)
#define forv(i, v) forn(i, v.size())
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back

int n;
vvi a;
vector<bool> f;

int dfs(int v) {
	f[v] = true;
	int res = 1;
	for (int x:a[v])
		if (!f[x]) {
			res += dfs(x);
		}
	return res;
}

int main() {
	int q;
	cin >> q;
	while (q--) {
		int m;
		ll L, R;
		cin >> n >> m >> L >> R;
		a.assign(n, vi(0));
		forn(i, m) {
			int x, y;
			cin >> x >> y;
			x--;
			y--;
			a[x].pb(y);
			a[y].pb(x);
		}
		f.assign(n, false);
		ll res = 0;
		forn(i, n) {
			if (!f[i]) {
				int sz = dfs(i);
				res += min(L + (sz - 1) * R, L * sz);
			}
		}
		cout << res << endl;

	}
}

