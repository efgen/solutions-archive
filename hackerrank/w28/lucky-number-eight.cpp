#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
long long mod = 1000000000+7;
int a[10], b[10];

int main() {
    int n;
    string s;
    cin >> n >> s;
    for (int i=0; i<n; i++) s[i] -= '0';
  
    a[0] = 1;
    for (int i=0; i<n; i++) {
        for (int j=0; j<8; j++) {
            b[j] = (b[j]+a[j])%mod;
            int t = (j*10+s[i])%8;
            b[t] = (b[t]+a[j])%mod;;
        }
        for (int j=0; j<8; j++) {
            a[j] = b[j];          
            b[j] = 0;
        }
    }
    a[0] = (a[0]+mod-1)%mod;
    cout << a[0];
   
    return 0;
}
