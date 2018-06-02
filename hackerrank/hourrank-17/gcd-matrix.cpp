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

int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

int main() {
    int n, m, q;
    cin >> n >> m >> q;
    vi a(n);
    vi b(m);
    forn(i, n) cin >> a[i];
    forn(i, m) cin >> b[i];
    while (q--) {
        int r1, r2, c1, c2;
        cin >> r1 >> c1 >> r2 >> c2;
        set<int> t;
        for (int i = r1; i <= r2; i++)
            for (int j = c1; j <= c2; j++)
                t.insert(gcd(a[i], b[j]));
        cout << t.size() << endl;
    }


}
