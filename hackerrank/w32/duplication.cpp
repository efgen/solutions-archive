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
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, k;
    string s = "0";
    while (s.size()<1000) {
        string t = "";
        for(auto c:s) t += 1-(c-'0') + '0';
        s += t;
    }
    
    int q;
    cin >> q;
    forn(i, q) {
        int x;
        cin >> x;
        cout << s[x] << endl;
    }   
}
