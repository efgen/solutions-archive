// @formatter:off
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
#define forn(i,n) for(int i=0;i<(n);++i)
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define sz(x) ((int)(x).size())
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
// @formatter:on

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, m, res = 0;
    cin >> n >> m;
    vvi a(n + 2, vi(m + 2, 0));
    forn(i, n) {
        forn(j, m) {
            cin >> a[i + 1][j + 1];
        }
    }
    vector<pii> deltas = {{0,  1},
                          {0,  -1},
                          {1,  0},
                          {-1, 0}};
    res = 2 * n * m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            for (const auto &d:deltas) {
                int ii = i + d.X;
                int jj = j + d.Y;
                res += max(a[i][j] - a[ii][jj], 0);
            }
        }
    }

    cout << res;

    return 0;
}


