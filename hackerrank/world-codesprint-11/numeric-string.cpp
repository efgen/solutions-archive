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
    string s;
    int k, b, m;
    cin >> s >> k >> b >> m;
    int n = s.size();
    forn(i, n) s[i] -= '0';
    ll p = 1;
    forn(i, k - 1) p = p * b % m;
    ll res = 0, cur = 0;
    forn(i, k) cur = (cur * b + s[i]) % m;
    res += cur;
    for (int i = k; i < n; i++) {
        cur = (cur - s[i - k] * p) % m;
        if (cur < 0) cur += m;
        cur = (cur * b + s[i]) % m;
        res += cur;

    }
    cout << res;


}
