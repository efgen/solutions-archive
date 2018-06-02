{$APPTYPE CONSOLE}
const inf = 1000000000;
type list = ^node;
node = record
  x,v:integer;
  p:list;
end;
var a:array[0..100,0..100] of integer;
sz,l,r,v:array[1..100] of integer;
h:array[1..100] of list;
f:array[1..100] of boolean;
i,j,k,n,x,y,q,w:integer;
p:list;
function max(a,b:integer):integer;
begin
  if a>b then max:=a else max:=b;
end;
function solv(x,q:integer):integer;
var i,m:integer;
begin
  if a[x,q]>=0 then
  begin
    Result:=a[x,q];
    exit;
  end;
  if q>sz[x] then
    a[x,q]:=-inf
  else
  if q = 0 then
    a[x,q]:=0
  else
  if q = 1 then
    a[x,q]:=v[x]
  else
  begin
    m:=-inf;     
    for i:=0 to q-1 do
      m:=max(m,solv(l[x],i)+solv(r[x],q-i-1));
    a[x,q]:=m+v[x];
  end;
  Result:=a[x,q];
end;
procedure norm(x:integer);
begin
  f[x]:=true;
  sz[x]:=1; l[x]:=0; r[x]:=0;
  while h[x]<>nil do
  begin
    if not f[h[x].x] then
    begin
      if l[x]=0 then
      begin
        l[x]:=h[x].x;
        norm(l[x]);
        inc(sz[x],sz[l[x]]);
      end else
      begin
        r[x]:=h[x].x;
        norm(r[x]);
        inc(sz[x],sz[r[x]]);
      end;
    end else v[x]:=h[x].v;
    h[x]:=h[x].p;
  end;
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);       }
  FillChar(f,SizeOf(f),false);
  Read(n,q);
  for i:=1 to n-1 do
  begin
    Read(x,y,w);
    p:=new(list);
    p.v:=w; p.x:=y; p.p:=h[x]; h[x]:=p;
    p:=new(list);
    p.v:=w; p.x:=x; p.p:=h[y]; h[y]:=p;
  end;
  norm(1); v[1]:=0;
  for i:=0 to 100 do
    for j:=0 to 100 do
      a[i,j]:=-inf;
  Writeln(solv(1,q+1));
//  Close(input);Close(output);
end.
