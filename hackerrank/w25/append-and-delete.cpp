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
    string a, b;
    int k;
    cin >> a >> b >> k;
    int n = min(a.length(), b.length());
    int common = 0;
    for (int i=0; i<n; i++) if (a[i]!=b[i]) break; else common++;
    int need = a.length()+b.length()-2*common;
    if (need<=k && (((k-need)%2==0) || (common==0))) cout << "Yes"; else cout << "No";
    return 0;
}