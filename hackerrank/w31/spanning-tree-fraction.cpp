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
const int maxn = 100000+10;

int p[maxn], rang[maxn];

int find(int x) {
	if (x==p[x]) return x; else return p[x] = find(p[x]);
}

void merge(int x, int y) {
	if (rang[x]<rang[y]) swap(x, y);
	p[y] = x;
	if (rang[x]==rang[y]) rang[x]++;
}

ll gcd(ll a, ll b) {
	if (!b) return a;
	return gcd(b, a%b);
}

int main() {
	int n, m;
	cin >> n >> m;
	vector<pii> ab(m);
	vector<pii> e(m);
	vector<pair<double, int>> g(m);
	forn(i, m) {
		cin >> e[i].first >> e[i].second;
		cin >> ab[i].first >> ab[i].second;
	}
	double l = 0, r = 101;
	ll BP = 0, BQ = 1;

	while (r-l>1e-9) {
		double x = (l+r)/2;
		forn(i, m) {
			g[i].first = x * ab[i].second - ab[i].first;
			g[i].second = i;
		}
		sort(all(g));
		forn(i, n) {
			rang[i] = 0;
			p[i] = i;
		}
		double res = 0;
		ll P = 0, Q = 0;
		int cnt = n-1;
		for(auto c:g) {
			int id = c.second;
			int x = e[id].first;
			int y = e[id].second;
			x = find(x);
			y = find(y);
			if (x != y) {
				res += c.first;
				P += ab[id].first;
				Q += ab[id].second;
				merge(x, y);
				cnt--;
				if (!cnt) break;
			}
		}
		if (res<=0) {
			if (P*BQ>Q*BP) {
				BQ = Q; BP = P;
			}
			l = x;
		} else {
			r = x;
		}
	}
	ll d = gcd(BP, BQ);
	BP /= d; BQ /= d;
	cout << BP << "/" << BQ;
	
	

}
