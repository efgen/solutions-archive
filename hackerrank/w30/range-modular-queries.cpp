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
int a[50000];

int main() {
    int n, q;
    scanf("%d%d", &n, &q);
    forn(i, n) {
        scanf("%d", &a[i]);
    }
    
    while (q--) {
        int l, r, x, y;
        scanf("%d%d%d%d", &l, &r, &x, &y);
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (a[i] % x == y) res++;
        }
        cout << res << endl;
    }
}
