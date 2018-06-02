const inf = 1000000000000;
var a:array[0..100,0..501] of Int64;
d,p:array[0..100,0..501] of integer;
path:array[1..50000] of integer;
i,j,h,k,n,m,x:integer;
procedure Show(h,x:integer);
begin
  if h>0 then
  begin
    if d[h,x]=x then Show(h-1,x)
       else Show(h,d[h,x]);
    Writeln(x);
  end;
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);    } 
  Read(n,m);
  for i:=1 to n do
    for j:=1 to m do
    begin
      Read(p[i,j]);
      a[i,j]:=inf;
    end;

  for i:=1 to m do d[1,i]:=i;
  for i:=1 to m do a[1,i]:=p[1,i];
  for h:=2 to n do
  begin
    for i:=1 to m do
    begin
      a[h,i]:=a[h-1,i]+p[h,i];
      d[h,i]:=i;
    end;
    for i:=2 to m do
      if a[h,i]>a[h,i-1]+p[h,i] then
      begin
        a[h,i]:=a[h,i-1]+p[h,i];
        d[h,i]:=i-1;
      end;
    for i:=m-1 downto 1 do
      if a[h,i]>a[h,i+1]+p[h,i] then
      begin
        a[h,i]:=a[h,i+1]+p[h,i];
        d[h,i]:=i+1;
      end;
  end;
  x:=1;
  for i:=1 to m do
    if a[n,i]<a[n,x] then x:=i;
// Writeln(a[n,x]);
//  Show(n,x);
  k:=0;
  while n>0 do
  begin
    inc(k);
    path[k]:=x;
    if d[n,x]=x then dec(n) else x:=d[n,x];
  end;
  while k>0 do
  begin
    Writeln(path[k]);
    dec(k);
  end;
// Close(input);Close(output);
end.
