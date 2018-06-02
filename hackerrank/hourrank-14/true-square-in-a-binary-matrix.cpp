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


int main() {
    int n;
    cin >> n;
    vvi a(n);
    forn(i, n)
        forn(j, n) {
            int x;
            cin >> x;
            a[i].pb(x);
        }
    for (int k = n; k > 0; k--) {
        forn(i, n - k + 1)
            forn(j, n - k + 1) {
                bool f = true;
                forn(x, k)forn(y, k) {
                        f &= a[i + x][j + y];
                    }
                if (f) {
                    cout << k;
                    exit(0);
                }
            }

    }
    cout << 0;
}