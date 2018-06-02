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

double v1, v2;

double go(int n, int k, bool united) {
    if (united) return v2;
    if (k == 0) {
        return v1;
    }

    ll V = n * (n - 1ll) / 2;

    return (go(n - 1, k - 1, true) + go(n - 1, k - 1, false) * (V - 1)) / V;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, k;
    cin >> n >> k;
    forn(i, n) {
        int x;
        cin >> x;
        v1 += x * x;
        v2 += x;
    }
    v2 *= v2;

    printf("%0.9f", M_PI * go(n, k, false));
}
