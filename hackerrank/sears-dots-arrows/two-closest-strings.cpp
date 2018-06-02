#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>

#define forn(i, n) for (int i=0; i<n; i++)
#define forv(i, v) for (int i=0; i<(int)(v.size()); i++)
#define pb push_back


using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        int k;
        cin >> s >> k;
        vector<int> pos;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != 'a') {
                if (k) {
                    k--;
                    s[i] = 'a';
                }
            } else {
                pos.pb(i);
            }
        }
        reverse(begin(pos), end(pos));
        for (int x:pos) {
            if (k) {
                k--;
                s[x] = 'b';
            }
        }
        cout << s << endl;
    }
    return 0;
}