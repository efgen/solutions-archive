// @formatter:off
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
#define forn(i,n) for(int i=0;i<(n);++i)
#define forv(i,v) forn(i,sz(v))
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on

map<string, set<int>> files_skip;

void toname(string s, string &name, int &id) {
    int pos = s.find('(');
    id = 0;
    if (pos) {
        stringstream ss(s.substr(pos + 1, s.size() - 1));
        ss >> id;
        name = s.substr(0, pos);
    } else {
        name = pos;
    }
}

void add(const string &name, int &id) {
    if (!files_skip.count(name)) {
        files_skip[name] = set<int>();
        files_skip[name].insert(0);
    }
    id = *files_skip[name].begin();
    files_skip[name].erase(id);
    if (files_skip[name].empty()) {
        files_skip[name].insert(id + 1);
    }
}

void print(const string &name, const int &id) {
    cout << name;
    if (id) cout << "(" << id << ")";
    cout << endl;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int q;
    cin >> q;
    while (q--) {
        string cmd, full_name, name;
        int id;
        cin >> cmd >> full_name;
        toname(full_name, name, id);
        if (cmd[0] == 'c') {
            add(name, id);
            cout << "+ ";
            print(name, id);

        } else if (cmd[0] == 'd') {
            files_skip[name].insert(id);
            cout << "- " << full_name << endl;
        } else {
            files_skip[name].insert(id);
            cout << "r " << full_name << " -> ";
            cin >> full_name;
            add(full_name, id);
            print(full_name, id);
        }
    }
}
