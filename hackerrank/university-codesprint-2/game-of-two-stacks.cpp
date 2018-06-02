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
    int q;
    cin >> q;
    while (q--) {
        int n, m, X;
        cin >> n >> m >> X;
        vl a(n + 1), b(m + 1);
        forn(i, n) {
            cin >> a[i + 1];
            a[i + 1] += a[i];
        }
        forn(i, m) {
            cin >> b[i + 1];
            b[i + 1] += b[i];
        }
        ll res = 0;
        forn(i, n + 1) {
            ll t = a[i];
            if (t > X) break;
            if (i > res) res = i;
            auto p = upper_bound(all(b), X - t);

            ll d = p - b.begin() - 1;
            res = max(res, d + i);

        }
        cout << res << endl;
    }

}
