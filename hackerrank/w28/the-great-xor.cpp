#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int q;
    long long n;
    cin >> q;
    while (q--) {
        cin >> n;       
        long long t = 1;
        while (t<=n) {
            t <<= 1;
        }    
        cout << t-n-1 << endl;
    }
    return 0;
}
