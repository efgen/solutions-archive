#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, t;
    cin >> n >> t;
    int cnt = n;
    int add = 0;
    for(int i=1; i<=t; i++) {
        int x;
        cin >> x;
        cnt -= x;
        if (i<t && cnt<5) {
            add += n-cnt;
            cnt = n;
        }
    }
    cout << add;
    return 0;
}
