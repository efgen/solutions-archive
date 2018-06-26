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
const int inf = 10000000000;
vector<vii> a;

int wait_for_green(int x, int k) {
    int t = x % (2 * k);
    if (t < k) return x; else return x + (2 * k - t);
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, k, m;
    cin >> n >> k >> m;
    a.assign(n, vii());
    forn(i, m) {
        int x, y, v;
        cin >> x >> y >> v;
        x--;
        y--;
        a[x].pb({y, v});
        a[y].pb({x, v});
    }
    vi d(n), f(n);
    forn(i, n) d[i] = inf;
    d[0] = 0;
    priority_queue<pii> pq;
    pq.push({0, 0});
    while (!pq.empty()) {
        auto cur = pq.top();
        pq.pop();
        int v = cur.Y;
        int dist = -cur.X;
        if (dist > d[v]) continue;
        for (auto e:a[v]) {
            int nd = wait_for_green(d[v], k) + e.Y;
            if (nd < d[e.X]) {
                d[e.X] = nd;
                pq.push({-d[e.X], e.X});
            }
        }
    }
//    forn(i, n) cout << i << " " << d[i] << endl;
    cout << d[n - 1];
    return 0;
}
