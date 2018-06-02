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

int cmp(ll x, ll y) {
    if (x < y) return -1; else if (x > y) return 1;
    return 0;
}

int main() {
    int n;
    cin >> n;
    vi a(n + 1);
    vl ltma(n + 1);
    vl stma(n + 1);
    forn(i, n) {
        cin >> a[i + 1];
        a[i + 1] += a[i];
    }
    int t1 = 60;
    int t2 = 300;
    for (int i = min(t2, n); i <= n; i++) {
        double v1 = a[i] - a[i - t1];
        double v2 = a[i] - a[i - t2];
        stma[i] = (ll) round(v1 / t1 * 100);
        ltma[i] = (ll) round(v2 / t2 * 100);
    }
    for (int i = min(t2, n) + 1; i <= n; i++) {
        if (cmp(ltma[i], stma[i]) != cmp(ltma[i - 1], stma[i - 1])) {
            printf("%d %0.2f% 0.2f\n", i, stma[i] / 100.0, ltma[i] / 100.0);
        }
    }
}