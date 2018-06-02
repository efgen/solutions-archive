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
    int n, m, x, k;
    cin >> n >> m >> x >> k;
    vl a(n), b(m);
    forn(i, n) cin >> a[i];
    forn(i, m) cin >> b[i];


    priority_queue<ll> pq;
    int pqsz = 0;
    int t1 = min(n, m - x);
    for (int i = 0; i < t1; i++) {
        for (int j = i + x; j < m; j++) {
            ll val = a[i] * b[j];
            pq.push(val);
            pqsz++;
            if (pqsz > k) {
                pq.pop();
                pqsz--;
            }
        }
    }

    cout << pq.top();
    return 0;
}