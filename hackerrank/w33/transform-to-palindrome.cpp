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


vvi a;
vi comp;

void dfs(int v, int num) {
    comp[v] = num;
    for (int x:a[v])
        if (comp[x] == 0) dfs(x, num);
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, k, m;
    cin >> n >> k >> m;
    a.assign(n, vi());
    forn(i, k) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        a[x].pb(y);
        a[y].pb(x);
    }
    comp.assign(n, 0);
    int cc = 0;
    forn(i, n) {
        if (!comp[i]) dfs(i, ++cc);
    }

    vi s(m);
    forn(i, m) cin >> s[i];
    forn(i, m) s[i] = comp[s[i] - 1];
    vvi dp(m, vi(m));
    forn(i, m) dp[i][i] = 1;
    for (int len = 2; len <= m; len++) {
        forn(l, m - len + 1) {
            int r = l + len - 1;
            dp[l][r] = max(dp[l + 1][r], dp[l][r - 1]);
            if (s[l] == s[r]) dp[l][r] = max(dp[l][r], 2 + dp[l + 1][r - 1]);
        }
    }
    cout << dp[0][m - 1];
    return 0;
}
