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


int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n;
    int m = 1000000 + 10;
    cin >> n;
    vector<bool> a(m), b(m);
    forn(i, n) {
        int x;
        cin >> x;
        a[x] = true;
    }
    forn(i, n) {
        int x;
        cin >> x;
        b[x] = true;
    }
    int res = 0;
    for (int d = m - 1; d > 0; d--) {
        int ma = 0, mb = 0;
        for (int t = d; t < m; t += d) {
            if (a[t]) ma = t;
            if (b[t]) mb = t;
        }
        if (ma && mb) {
            res = ma+mb;
            break;
        }

    }
    cout << res;
    return 0;
}

