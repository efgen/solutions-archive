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
    string s;
    cin >> n >> s;
    string sp = "!@#$%^&*()-+";
    vector<bool> f(4);
    for (char c:s) {
        if (c >= 'A' && c <= 'Z') f[0] = 1;
        if (c >= '0' && c <= '9') f[1] = 1;
        if (c >= 'a' && c <= 'z') f[2] = 1;
        for (char cc:sp) if (cc == c) f[3] = 1;
    }
    int res = 4;
    for (bool ff: f) if (ff) res--;
    if (n < 6) {
        if (n + res < 6) res += 6 - (n + res);
    }
    cout << res;
    return 0;
}