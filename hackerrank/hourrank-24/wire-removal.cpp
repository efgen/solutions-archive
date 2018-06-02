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
#define sz(x) x.size()
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on

vvi a;
vi tsz;
double res = 0;
double distSum = 0;
int n;

int dfs(int v, int p, int dist) {
    for (int x:a[v]) {
        if (x != p) {
            tsz[v] += dfs(x, v, dist + 1);
            res += 1.0 * (n - tsz[x]) * dist;
            distSum += dist;
        }
    }
    return ++tsz[v];
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n;
    a.assign(n, vi());
    tsz.assign(n, 0);
    forn(i, n - 1) {
        int x, y;
        cin >> x >> y;
        x--;
        y--;
        a[x].pb(y);
        a[y].pb(x);
    }
    dfs(0, -1, 1);
//    forn(i, n) cout << tsz[i] << endl;
    printf("%0.7f", res / distSum);
    return 0;
}