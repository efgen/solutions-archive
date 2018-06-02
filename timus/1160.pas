{$APPTYPE CONSOLE}
var rx,ry,rv:array[1..15000] of integer;
p,rank,res:array[1..1000] of integer;
n,m,i,j,k,x,y:integer;
function FindSet(x:integer):integer;
begin
  if x<>p[x] then p[x]:=FindSet(p[x]);
  Result:=p[x];
end;
procedure Union(x,y:integer);
begin
  if rank[x]<rank[y] then p[x]:=y else
  if rank[x]>rank[y] then p[y]:=x else
  begin
    inc(rank[x]);
    p[y]:=x;
  end;
end;
procedure sort(l,r:integer);
var i,j,q,x:integer;
begin
  i:=l; j:=r; x:=rv[(l+r) div 2];
  repeat
    while rv[i]<x do inc(i);
    while rv[j]>x do dec(j);
    if i<=j then
    begin
      q:=rv[i]; rv[i]:=rv[j]; rv[j]:=q;
      q:=rx[i]; rx[i]:=rx[j]; rx[j]:=q;
      q:=ry[i]; ry[i]:=ry[j]; ry[j]:=q;
      inc(i); dec(j);
    end;
  until i>j;
  if l<j then sort(l,j);
  if i<r then sort(i,r);
end;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);     }
  Read(n,m);
  for i:=1 to m do Read(rx[i],ry[i],rv[i]);
  for i:=1 to n do
  begin
    rank[i]:=0;
    p[i]:=i;
  end;
  sort(1,m);
  k:=1; i:=1;
  while k<n do
  begin
    x:=FindSet(rx[i]);
    y:=FindSet(ry[i]);
    if x<>y then
    begin
      Union(x,y); 
      res[k]:=i;
      inc(k);
    end;
    inc(i);
  end;
  k:=n-1;
  Writeln(rv[res[k]]);
  Writeln(k);
  for i:=1 to k do
  Writeln(rx[res[i]],' ',ry[res[i]]);
//  Close(input);Close(output);
end.
