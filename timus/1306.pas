program Z;
{$APPTYPE CONSOLE}
var a:array[1..125002] of longword;
i,n,sz,max:integer;
x:longword;
r:extended;
procedure add(x:longword;k:integer);
var p:integer;
begin
  a[k]:=x;
  while k>1 do
  begin
    p:=k div 2;
    if a[k]<a[p] then begin x:=a[k]; a[k]:=a[p]; a[p]:=x; end else exit;
    k:=p;
  end;
end;
procedure sift(k:integer);
var i:integer;
q:longword;
begin
  while true do
  begin
    i:=2*k;
    if i>sz then exit;
    if i<sz then if a[i+1]<a[i] then inc(i);
    if a[i]<a[k] then
    begin
      q:=a[i]; a[i]:=a[k]; a[k]:=q;
    end else exit;
    k:=i;
  end;
end;
begin
{  Assign(input,'test.in');
  Assign(output,'test.out');
  Reset(input); Rewrite(output);        }
  Read(n); sz:=n div 2 + 1;
  for i:=1 to sz do Read(a[i]);
  for i:=sz div 2 downto 1 do sift(i);
  for i:=sz+1 to n do
  begin
    Read(x);
    add(x,sz+1);
    a[1]:=a[sz+1];
    sift(1);
  end;
  r:=a[1];
  if n mod 2 = 0 then
  begin
    x:=a[2];
    if sz>2 then
      if a[3]<a[2] then x:=a[3];
    r:=(r+x)/2;
  end;
  Write(r:0:1);
//  Close(input); Close(output);
end.