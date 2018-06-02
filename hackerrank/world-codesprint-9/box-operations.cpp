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
    int n, q;
    cin >> n >> q;
    vi a(n);
    forn(i, n) cin >> a[i];
    forn(ii, q) {
        int t, l, r;
        cin >> t >> l >> r;
        if (t == 1) {
            int add;
            cin >> add;
            for (int i = l; i <= r; i++) a[i] += add;
        } else if (t == 2) {
            int d;
            cin >> d;
            for (int i = l; i <= r; i++)
                if (a[i] >= 0) {
                    a[i] /= d;
                } else {
                    a[i] = (a[i] - d + 1) / d;
                }
        } else if (t == 4) {
            ll s = 0;
            for (int i = l; i <= r; i++) {
                s += a[i];
            }
            cout << s << endl;
        } else {
            ll s = 1 << 31 - 1;
            for (int i = l; i <= r; i++) {
                s = min(s, (ll) a[i]);
            }
            cout << s << endl;
        }
    }
}
