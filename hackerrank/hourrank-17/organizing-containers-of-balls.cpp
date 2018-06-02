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
        int n;
        cin >> n;
        vector<vi> a(n, vi(n, 0));
        vi cnt(n, 0);
        vi cls(n, 0);
        forn(i, n)forn(j, n) {
                cin >> a[i][j];
                cnt[i] += a[i][j];
                cls[j] += a[i][j];
            }
        sort(all(cnt));
        sort(all(cls));
        bool ok = true;
        forn(i, n) {
            ok &= cnt[i] == cls[i];
        }
        if (ok) cout << "Possible"; else cout << "Impossible";
        cout << endl;
    }

}
