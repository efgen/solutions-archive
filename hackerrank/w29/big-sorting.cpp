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
    int n;
    cin >> n;
    map<int, vector<string>> a;
    forn(i, n) {
        string s;
        cin >> s;
        int len = s.length();
        if (a.count(len)) {
            a[len].pb(s);
        } else {
            vector<string> v;
            v.pb(s);
            a[len] = v;
        }
    }

    for (auto kv:a) {
        sort(all(kv.second));
        for (auto s:kv.second) {
            cout << s << endl;
        }
    }
}
