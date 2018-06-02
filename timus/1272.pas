type
    pnode = ^node;
    node = record
    x:integer;
    p:pnode;
  end;
  var i,j,k,n,m,x,y:integer;
  a:array[1..10010] of pnode;
  f:array[1..10010] of boolean;
procedure Add(x,y:integer);
var p:pnode;
begin
  p:=new(pnode);
  p.x:=y;
  p.p:=a[x];
  a[x]:=p;
end;
procedure dfs(v:integer);
var w:integer;
begin
  f[v]:=false;
  while (a[v]<>nil) do
  begin
    w:=a[v].x;
    a[v]:=a[v].p;
    if f[w] then dfs(w);
  end;
end;
begin
  FillChar(f,SizeOf(f),true);
  Read(n,m,k); k:=0;
  for i:=1 to n do a[i]:=nil;
  for i:=1 to m do
  begin
    Read(x,y);
    Add(x,y);
    Add(y,x);
  end;
  for i:=1 to n do
    if f[i] then
    begin
      inc(k);
      dfs(i);
    end;
  Writeln(k-1);
end.
