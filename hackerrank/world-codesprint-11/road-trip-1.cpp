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
#define forv(i,v) forn(i,sz(v))
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on



int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, q;
    cin >> n >> q;
    vi d(n), g(n), p(n);
    forn(i, n - 1) cin >> d[i];
    forn(i, n) cin >> g[i] >> p[i];
    vl ans(q);
    vector<pair<pii, int>> queries(q);
    forn(i, q) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        queries[i] = {{x, y}, i};
    }
    sort(all(queries));
    int prevx = -1;
    ll price = 0;
    ll gas = 0;
    ll minPrice = 1e+9;
    int start = -1, end = -1;
    for (auto q:queries) {
        if (q.X.X != prevx) {
            price = 0;
            gas = 0;
            minPrice = 1e+9;
            start = prevx = q.X.X;
        }
        end = q.X.Y;
        for (int i = start; i < end; i++) {
            if (p[i] < minPrice) minPrice = p[i];
            gas += g[i];
            ll req = max(0ll, d[i] - gas);
            price += minPrice * req;
            gas += req;
            gas -= d[i];
        }
        start = end;
        ans[q.Y] = price;
    }
    forn(i, q) cout << ans[i] << endl;
}
