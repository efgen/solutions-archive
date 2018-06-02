#include <iostream>
#include <cmath>
void main(){  
double w,l,d,t=6.283185307179586476925286,r=6400;
std::cin>>w>>l>>d;		
w*=t/360;
l*=t/360;
if(l<0)l+=t;
l+=d/r/cos(w+d/r)-d/r/cos(w);
l-=floor(l/t)*t;
if(l<0)l+=t;
if(l>t/2)l-=t;
l*=360/t;
w*=360/t;		
printf("%1.3f\n%1.3f",w,l);	
}