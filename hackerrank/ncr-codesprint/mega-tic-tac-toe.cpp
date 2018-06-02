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
int n, m;
vector<string> a;

int f(vector<bool> &v) {
    int res = 0, good = 0;
    forv(i, v) {
        if (v[i]) {
            good++;
            if (good > res) {
                res = good;
            }
        } else {
            good = 0;
        }
    }
    return res;
}

int getCnt(const char c) {
    int cnt = 0;
    forn(i, n) {
        vector<bool> v;
        forn(j, m) {
            v.pb(a[i][j] == c);
        }
        cnt = max(cnt, f(v));
    }
    forn(i, m) {
        vector<bool> v;
        forn(j, n) {
            v.pb(a[j][i] == c);
        }
        cnt = max(cnt, f(v));
    }

    vector<vector<bool>> d1(n + m + 2), d2(n + m + 2);
    forn(i, n) {
        forn(j, m) {
            int d1id = i + j;
            int d2id = i - j + m - 1;
            d1[d1id].pb(a[i][j] == c);
            d2[d2id].pb(a[i][j] == c);
        }
    }
    for (auto v:d1)
        cnt = max(cnt, f(v));
    for (auto v:d2)
        cnt = max(cnt, f(v));
    return cnt;
}

int main() {
    int q;
    cin >> q;
    while (q--) {
        int k;
        cin >> n >> m >> k;
        a.clear();
        forn(i, n) {
            string s;
            cin >> s;
            a.pb(s);
        }
        int cntX = getCnt('X');
        int cntO = getCnt('O');
        if ((cntX >= k && cntO >= k) || (cntX < k && cntO < k)) {
            cout << "NONE";
        } else if (cntX >= k) {
            cout << "LOSE";
        } else {
            cout << "WIN";
        }
        cout << endl;


    }
}