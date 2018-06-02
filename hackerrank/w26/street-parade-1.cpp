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

int main() {
	int n, h1, h2, m;
	cin >> n;
	vi a(n);
	forn(i, n) cin >> a[i];
	cin >> m >> h1 >> h2;
	if (m >= h1 && m <= h2) {
		cout << a[n - 1];
		return 0;
	}
	int L = n - 1;
	int len = 0;
	for (int i = n - 1; i >= 0; --i) {
		int minx = h1;
		int maxx = h2;
		int miny = h1;
		int maxy = h2;

		if (i > 0) {
			maxx = min(maxx, a[i] - a[i - 1]);
		}
		if (L < n - 1) {
			maxy = min(maxy, a[L + 1] - a[L]);
		}

		int K = m - len;
		minx = max(minx, K - maxy);
		maxx = min(maxx, K - miny);
		if (minx <= maxx && minx >= 0) {
			cout << a[i] - minx;
			return 0;
		}

		if (i == 0) {
			break;
		}

		int curL = a[i] - a[i - 1];
		if (curL >= h1 && curL <= h2) {
			len += curL;
			while (L >= i && len > m) {
				len -= a[L] - a[L - 1];
				L--;
			}
		} else {
			L = i - 1;
			len = 0;
		}
	}

	return 123;
}