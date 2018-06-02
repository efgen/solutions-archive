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
    if (m == 2) {
        if (n < 16) {
            cout << n / 2 << endl;
            forn(i, n) {
                cout << (i + n - 1) % n << " " << (i + 1) % n << endl;
            }
        } else {
            int sq = (int) round(sqrt(n));
            int res = n / sq + sq - 2;\
            cout << res << endl;   
            forn(i, n) {
                cout << (i + 1) % n << " " << (i + sq) % n << endl;
            }
        }

    } else return 123;

}
