//var h,ht:array[1..2000] of list;
var a:array[1..2000,1..2000] of boolean;
ord,scc:array[1..2000] of integer;
f:array[1..2000] of boolean;
n,i,k,x,y,r:integer;
procedure dfs(v:integer);
var i:integer;
begin
  f[v]:=true;
  for i:=1 to n do
    if a[i,v] and not f[i] then dfs(i);
 { while ht[v]<>nil do
  begin
    if not f[ht[v].x] then dfs(ht[v].x);
    ht[v]:=ht[v].p;
  end;   }
  inc(k);
  ord[k]:=v;
end;
procedure dfs2(v:integer);
var i:integer;
begin
  scc[v]:=k;
  for i:=1 to n do
    if a[v,i] then
      if scc[i] = 0 then dfs2(i) else
        if scc[v]<>scc[i] then f[scc[i]]:=true;
 { while h[v]<>nil do
  begin
    if scc[h[v].x]=0 then dfs2(h[v].x) else
      if scc[v]<>scc[h[v].x] then f[scc[h[v].x]]:=true;
    h[v]:=h[v].p;
  end;       }
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);        }
  Read(n);
{ for i:=1 to n do h[i]:=nil;
  for i:=1 to n do ht[i]:=nil;
  for x:=1 to n do
    repeat
      Read(y);
      if y=0 then break;
      p:=new(list); p.x:=y; p.p:=h[x]; h[x]:=p;
      p:=new(list); p.x:=x; p.p:=ht[y]; ht[y]:=p;
    until false;
  }
  FillChar(a,SizeOf(a),false);
  for x:=1 to n do
    repeat
      Read(y);
      if y = 0 then break;
      a[x,y]:=true;
    until false;

  FillChar(f,SizeOf(f),false);
  k:=0;
  for i:=1 to n do
    if not f[i] then dfs(i);

  FillChar(f,SizeOf(f),false);
  FillChar(scc,SizeOf(scc),0);
  k:=0;
  for i:=n downto 1 do
    if scc[ord[i]]=0 then
    begin
      inc(k);
      dfs2(ord[i]);
    end;
  r:=0;
  for i:=1 to k do
    if not f[i] then
      if r=0 then r:=i else
      begin
        r:=0;
        break;
      end;
 // for i:=1 to n do Write(scc[i],' '); Writeln;
  for i:=1 to n do
    if scc[i]=r then Write(i,' ');
  Writeln(0);
//  Close(input);Close(output);
end.
