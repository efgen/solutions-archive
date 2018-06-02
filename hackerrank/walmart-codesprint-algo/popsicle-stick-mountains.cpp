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
const int mod = 1000000007;

int main() {
    int N = 2001;
    vl C(N);
    C[0] = 1;
    for (int n = 1; n < N; n++) {
        forn(i, n) C[n] = (C[n] + C[i] * C[n - i - 1]) % mod;
        //cout << C[n] << endl;
    }
    C[0] = 0;
    forn(i, N - 1) C[i + 1] = (C[i + 1] + C[i]) % mod;
    int tests;
    cin >> tests;
    while (tests--) {
        int x;
        cin >> x;
        cout << C[x / 2] << endl;
    }
    return 0;
}