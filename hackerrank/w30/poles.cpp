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

int main() {
    int n, m;
    cin >> n >> m;
    vector<pair<ll, ll>> a(n);
    forn(i, n) {
        cin >> a[i].first >> a[i].second;
    }
    m = n - m;
    ll res = 0;
    while (m--) {
        int pos = 0;
        ll best = (1LL) << 60;
        for (int i = 1; i < n; i++) {
            ll d = (a[i].first - a[i - 1].first) * a[i].second;
            if (d < best) {
                best = d;
                pos = i;
            }
        }
        res += best;
        n--;
        a[pos - 1].second += a[pos].second;
        for (int i = pos; i < n; i++) {
            a[i] = a[i + 1];
        }
    }
    
    cout << res;
}
