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
vl a;
map<ll, bool> mem;

bool good(ll n) {
    if (mem.count(n)) {
        return mem[n];
    }
    forv(i, a) {
        if (n % a[i] == 0) {
            if (n % 2 == 0) {
                mem[n] = true;
                return true;
            }
            if (!good(n / a[i])) {
                mem[n] = true;
                return true;
            }
        }
    }
    mem[n] = false;
    return false;

}

int main() {
    int m;
    ll n;
    cin >> n >> m;
    forn(i, m) {
        ll x;
        cin >> x;
        a.pb(x);
    }

    if (good(n)) cout << "First"; else cout << "Second";


}