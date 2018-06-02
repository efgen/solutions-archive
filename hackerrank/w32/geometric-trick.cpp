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


int pd[64];
int pc[64];
int cnt = 0;
int ans = 0;
int N;
vector<bool> v1, v2;
void go(int pos, ll a, ll SX) {
    //cout <<pos << " "<< a << " " << b << " " << a*b << endl;
    if (pos<0) {
        SX /= a;
        if (SX<=N && v1[a] && v2[SX]) ans++;
        return;
    }
    for (int i=2*pc[pos]; i>=0; --i) {
        go(pos-1, a, SX);
        a *= pd[pos];
        if (a>N) return;             
    }
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n;
    string s;
    cin >> n >> s;
    N = n;
    v1.assign(n+1, false);
    v2.assign(n+1, false);
    vi md(n+1);
    vi middle;
    
    forn (i, n) {
        if (s[i]=='a') v1[i+1] = true;
        if (s[i]=='c') v2[i+1] = true;
        if (s[i]=='b') middle.pb(i+1);
    }
    
    for (int p=2; p<=n; p++) 
        if (md[p]==0) {
            for(int x=p; x<=n; x+=p) md[x] = p;
        }
    
    for (int X:middle) {
        cnt = -1;
        int x = X;
        int last = X+1;
        while (x>1) {
            int k = md[x];
            assert(k<=last);
            last = k;
            x /= k;
            if (cnt<0 || pd[cnt]!=k) {
                pd[++cnt] = k;
                pc[cnt] = 0;
            }
            pc[cnt]++;
        }
   
        go(cnt, 1, ((ll)X)*X);
    }
    
    //assert(t2==ans);
    cout << ans;   
    
}
