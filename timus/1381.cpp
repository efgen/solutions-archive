#include <iostream>      
#include <cmath>
#include <string>
#include <vector>
using namespace std;
#define forn(i,n) for(int i=0;i<n;++i)
#define pb push_back
#define iinf 1000000000

int n;
int func[31][31][31];
int maxd[31][31];
int mind[31][31];

int main(){    
#ifdef ___FILES
	freopen("input.txt","r",stdin);      
	freopen("output.txt","w",stdout);
#endif

	cin>>n;
	++n;
	forn(i,n)
		forn(j,n)
			forn(k,n){
				cin>>func[i][j][k];
				func[i][j][k]-=k;
			}

	if(func[0][0][0]>0){
		cout<<'>';
		return 0;
	}
	if(func[0][0][0]<0){
		cout<<'<';
		return 0;
	}

	forn(i,n)
		forn(j,n){
			maxd[i][j]=-iinf;
			mind[i][j]=iinf;
		}
	mind[0][0]=0;
	maxd[0][0]=0;

	forn(q,n*n){
		forn(i,n){
			forn(j,n){
				forn(k,n){
					maxd[j][k]=max(maxd[j][k],maxd[i][j]+func[j][i][k]);
					mind[j][k]=min(mind[j][k],mind[i][j]+func[j][i][k]);
				}
			}
		}
	}
	int d1=mind[0][0];
	int d2=maxd[0][0];
	forn(q,n*n){
		forn(i,n){
			forn(j,n){
				forn(k,n){
					if(maxd[i][j]+func[j][i][k]>maxd[j][k])
						maxd[j][k]=iinf;
					if(mind[i][j]+func[j][i][k]<mind[j][k])
						mind[j][k]=-iinf;
				}
			}
		}
	}

	if(mind[0][0]<d1)
		cout<<'<';
	if(maxd[0][0]>d2)
		cout<<'>';
	if(mind[0][0]>=d1&&maxd[0][0]<=d2)
		cout<<'=';

	return 0;
}
 