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

#define forn(i, n) for (int i = 0; i < (int)(n); i++)
#define forv(i, v) forn(i, v.size())
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
ll mod = 998244353;

ll mpow(ll x, ll n) {
    ll a = 1, b = x;
    while (n) {
        if (n&1) {
            a = a*b%mod;
        }
        b = b*b%mod;
        n >>= 1;
    }
    return a;
}

ll inv(int a) {
    return mpow(a, mod-2);
}

int main() {
    int n,m,k;
    cin >> n >> m >> k;
    vi f(n);
    forn(i, n) {
        cin >> f[i];
        f[i]--;
    }
    vl p(m);
    forn(i, m) cin >> p[i];

        
    ll invN = inv(n);
    vl a(n, invN), b(n);

    vector<bool> good(n);
    vector<bool> inPureCircle(n, true);
    forn(i, n) good[f[i]] = true;
    forn(i, n) 
    if (!good[i])  {
        int x = i;        
        while (inPureCircle[x]) {
            inPureCircle[x] = false;
            x = f[x];
        }
    }

 
    
    // cout << invN << endl;
    while (k--) {
        forn(i, n) 
        if (!inPureCircle[i]){
            int t = i;
            forn(j, m) {
                b[t] = (b[t]+a[i]*p[j])%mod;
                t = f[t];        
            }
        }

        forn(i, n) {
            a[i] = b[i];
            b[i] = 0;
        }        
    }
    forn(i, n) {
        cout << (inPureCircle[i] ? invN : a[i]) << endl;
    }

}
