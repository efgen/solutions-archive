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
int res, all;
char last = '#';

void upd(char c) {
    if (c != '#' && last == '#') {
        res++;
    }
    all--;
    last = c;

    if (!all) {
        cout << res << endl;
        exit(0);
    }
}

int main() {
    vector<string> a;
    int n, m;
    cin >> n >> m;
    forn(i, n) {
        string s;
        cin >> s;
        a.pb(s);
    }
    all = n * m;
    int r = n - 1, c = 0, b = 0;
    int res = 0;
    while (all) {
        r = n - 1 - b, c = b;
        while (r >= b) {
            upd(a[r][c]);
            r--;
        }
        r = b;
        c++;
        while (c < m - b) {
            upd(a[r][c]);
            c++;
        }
        c = m - b - 1;
        r = b + 1;
        while (r < n - b) {
            upd(a[r][c]);
            r++;
        }
        r = n - b - 1;
        c = m - b - 2;
        while (c > b) {
            upd(a[r][c]);
            c--;
        }
        b++;
    }
}