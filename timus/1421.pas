program Z;
{$APPTYPE CONSOLE}
type list = ^node;
node = record
x:integer;
p:list;
end;
var f,c:array[1..202,0..202] of integer;
e,h,cur:array[1..202] of integer;
s,t,n,nn:integer;
i,j:integer;
fl:boolean;

function min(a,b:integer):integer;
begin
  if a<b then min:=a else min:=b;
end;
procedure push(u,v:integer);
var p:integer;
begin
  p:=min(c[u,v]-f[u,v],e[u]);
  inc(f[u,v],p);
  dec(f[v,u],p);
  dec(e[u],p);
  inc(e[v],p);
end;
procedure relabel(u:integer);
var v,minh:integer;
begin
  minh:=h[u];
  for v:=1 to n do
    if c[u,v]-f[u,v]>0 then
      if h[v]<minh then minh:=h[v];
  h[u]:=minh+1;
end;
procedure discharge(u:integer);
var v:integer;
begin
  while e[u]>0 do
  begin
    if cur[u]<=n then
    begin
      v:=cur[u];
      if (c[u,v]-f[u,v]>0) and (h[u]>h[v]) then push(u,v) else inc(cur[u]);
    end else
    begin
      cur[u]:=1;
      relabel(u);
    end;
  end;
end;
procedure Init();
var v:integer;
begin
  FillChar(f,SizeOf(f),0);
  FillChar(h,SizeOf(h),0);
  FillChar(e,SizeOf(e),0);
  for v:=1 to n do cur[v]:=1;
  h[s]:=n; e[s]:=2000000000;
  for v:=1 to n do push(s,v);
end;
procedure MaxFlow();
var u,v,oldh:integer;
p,L,pr:list;
begin
  Init();
  L:=nil;
  for v:=n downto 1 do
    if (v<>s) and (v<>t) then
    begin
      p:=new(list);
      p.x:=v;
      p.p:=L;
      L:=p;
    end;
  p:=L; pr:=p;
  while (p<>nil) do
  begin
    u:=p.x;
    oldh:=h[u];
    discharge(u);
    if (h[u]>oldh) and (p.x<>L.x) then
    begin
      pr.p:=p.p;
      p.p:=L;
      L:=p;
      p:=L;
    end;
    pr:=p; p:=p.p;
  end;
end;
begin
  {Assign(input,'test.in');
  Assign(output,'test.out');
  Reset(input); Rewrite(output);}
  FillChar(c,SizeOf(c),0);
  Read(n);
  for i:=1 to n do Read(c[1,1+i]);
  for i:=1 to n do Read(c[n+1+i,2*n+2]);
  for i:=2 to n+1 do
    for j:=n+2 to 2*n+1 do
      c[i,j]:=100;
  nn:=n;
  n:=2*n+2;
  s:=1; t:=n;
  MaxFlow();
  n:=nn;
  fl:=true;
  for i:=1 to n do fl:=fl and (c[1,1+i]=f[1,1+i]);
  for i:=1 to n do fl:=fl and (c[n+1+i,2*n+2]=f[n+1+i,2*n+2]);
  if fl then
  begin
    Writeln('YES');
    for i:=2 to n+1 do
    begin
      for j:=n+2 to 2*n+1 do
        Write(f[i,j],' ');
      Writeln;
    end;
  end else Writeln('NO');
 // Close(input); Close(output);
end.