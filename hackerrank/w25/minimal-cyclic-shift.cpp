#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <sstream>
#include <cmath>
#include <ctime>
#include <bitset>

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
const int mod = 998244353;

int main() {
    int n, k;
    cin >> n >> k;
    if (k < n - 1) {
        vi a, b;
        forn(i, n) {
            int x;
            cin >> x;
            a.pb(x);
        }
        forn(i, n) {
            int x;
            cin >> x;
            b.pb(x);
        }
        forn(p, n) {
            int t = ((a[p] - b[0]) % mod + mod) % mod;
            bool ok = true;
            forn(i, n) {
                if ((((a[(i + p) % n] - b[i]) % mod + mod) % mod) != t) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                cout << p;
                exit(0);
            }
        }
        cout << -1;
    } else cout << 0;

}