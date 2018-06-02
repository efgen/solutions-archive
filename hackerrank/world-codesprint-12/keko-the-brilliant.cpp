// @formatter:off
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<pii> vii;
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
const int inf = 1000000000 + 10;
int n;
vvi a;
vi r;


int dfs(int v, int p, int limit) {
    int res = 0, res2 = 0;
    for (int x:a[v])
        if (x != p) {
            res += dfs(x, v, limit);
        }
    if (r[v] >= limit) {
        res2 = 1;
        limit = r[v];
        for (int x:a[v])
            if (x != p) {
                res2 += dfs(x, v, limit);
            }
    }
//    cout << (v+1) << " " << limit << " " << res << " " << res2 << endl;
    return max(res, res2);
}

int dfs(int v, int p) {
    int res = 0;
    int min_ch = inf;
    for (int x:a[v])
        if (x != p) {
            if (r[x] < min_ch) {
                min_ch = r[x];
            }
            res += dfs(x, v);
        }
    if (r[v] > min_ch) res++;
    return res;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n;
    a.assign(n, vi());
    r.assign(n, 0);
//    dp.assign(n, 1);
    forn(i, n) cin >> r[i];
    forn(i, n - 1) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        a[x].pb(y);
        a[y].pb(x);
    }

    if (n < 10000) {
        cout << n - dfs(0, -1, 0);
    } else {
        cout << dfs(0, -1);
    }
    return 0;
}
