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
        cin >> s;
        int n = (int) s.size();
        int balance = 0;
        int len = 0;
        forv(i, s) {
            if (s[i] == '(') {
                balance++;
                len++;
            } else {
                balance--;
                if (balance < 0) {
                    balance = 0;
                    continue;
                }
                len++;
            }
        }
        len -= balance;
        cout << len << endl;


    }
    return 0;
}