{$APPTYPE CONSOLE}
var a,b,v:array[1..250000] of integer;
n,m,i,j,k,x,y,s,best:integer;
p,rank,mst:array[1..500] of integer;
procedure sort(l,r:integer);
var i,j,x,q:integer;
begin
  i:=l; j:=r; x:=v[(l+r) div 2];
  while i<=j do
  begin
    while v[i]<x do inc(i);
    while v[j]>x do dec(j);
    if i<=j then
    begin
      q:=v[i]; v[i]:=v[j]; v[j]:=q;
      q:=a[i]; a[i]:=a[j]; a[j]:=q;
      q:=b[i]; b[i]:=b[j]; b[j]:=q;
      inc(i); dec(j);
    end;
  end;
  if l<j then sort(l,j);
  if i<r then sort(i,r);
end;
procedure Init(n:integer);
var i:integer;
begin
  for i:=1 to n do
  begin
    p[i]:=i;
    rank[i]:=0;
  end;
end;
function FindSet(x:integer):integer;
begin
  if x<>p[x] then p[x]:=FindSet(p[x]);
  Result:=p[x];
end;
procedure Union(x,y:integer);
begin
  if rank[x]<rank[y] then p[x]:=y else
  begin
    p[y]:=x;
    if rank[x]=rank[y] then inc(rank[x]);
  end;
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);   }
  Read(n,m);
  for i:=1 to m do
    Read(a[i],b[i],v[i]);
  sort(1,m);

  k:=0;
  s:=0;
  Init(n);
  for i:=1 to m do
    if FindSet(a[i])<>FindSet(b[i]) then
    begin
      s:=s+v[i];
      Union(FindSet(a[i]),FindSet(b[i]));
      inc(k);
      mst[k]:=i;
      if k=n-1 then break;
    end;
  if k<n-1 then
  begin
    Writeln('Cost: -1');
    Writeln('Cost: -1');
    halt(0);
  end;
  Writeln('Cost: ',s);
  best:=1000000000;

  for j:=1 to k do
  begin
    Init(n); s:=0;
    for i:=1 to k do
    if i<>j then
    begin
      s:=s+v[mst[i]];
      Union(FindSet(a[mst[i]]),FindSet(b[mst[i]]));
    end;
    for i:=mst[j]+1 to m do
    if FindSet(a[i])<>FindSet(b[i]) then
    begin
      s:=s+v[i];
      if s<best then best:=s;
      break;
    end;
  end;
  Write('Cost: ');
  if best<1000000000 then Writeln(best) else Writeln(-1);
 // Close(input);Close(output);
end.
