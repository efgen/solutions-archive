type vert = record
x,y:longint;
end;
var  a,b:array[1..1010] of vert;
i,j,k,min,n:longint;
l:extended;
function Kos(v1,v2,v3:vert):longint;
begin
  Kos:=(v2.x-v1.x)*(v3.y-v1.y)-(v3.x-v1.x)*(v2.y-v1.y);
end;
function d2(v1,v2:vert):longint;
begin
  d2:=sqr(v1.x-v2.x)+sqr(v1.y-v2.y);
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
}  Read(n,l);
  for i:=1 to n do Read(a[i].x,a[i].y);
  min:=1;
  for i:=2 to n do
    if ((a[i].y<a[min].y) or ((a[i].y=a[min].y) and (a[i].x>a[min].x))) then
      min:=i;
  b[1]:=a[min]; a[min]:=a[1]; a[1]:=b[1];
  k:=1; min:=2;
  repeat
    for i:=1 to n do
      if (Kos(b[k],a[min],a[i])<0) or
         ((Kos(b[k],a[min],a[i])=0) and (d2(b[k],a[i]) > d2(b[k],a[min]))) then
           min:=i;
    inc(k);
    b[k]:=a[min];
    min:=1;
  until (b[k].x=b[1].x) and (b[k].y=b[1].y);
  l:=2*pi*l;
  for i:=1 to k-1 do l:=l+sqrt(d2(b[i],b[i+1]));
  Writeln(l:0:0);
//  Close(input); Close(output);
end.