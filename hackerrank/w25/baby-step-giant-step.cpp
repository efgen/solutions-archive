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
    int q;
    cin >> q;
    while (q--) {
        ll a, b, d;
        cin >> a >> b >> d;
        ll res = 0;
        if (d > 0) {
            ll k = d / b;
            if (k == 0) {
                if (d == a) res = 1; else res = 2;
            } else res = k + 1;
            if (k * b == d) res = k;
        }
        cout << res << endl;
    }
    return 0;
}