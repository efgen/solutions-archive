const hashM = 2000003;
type list = ^node;
node = record
x:integer;
p:list;
end;
var n,i,j,k,l,r,len,hash,d,ri,rj:integer;
s1,s2:string;
f:boolean;
a:array[0..hashM] of list;
procedure add(x:integer; hash:integer);
var p:list;
begin
  p:=new(list);
  p.x:=x;
  p.p:=a[hash];
  a[hash]:=p;
end;
procedure clear;
var i:integer;
p,pp:list;
begin
  for i:=0 to hashM do
  begin
    p:=a[i];
    while p<>nil do
    begin
      pp:=p;
      p:=p.p;
      dispose(pp);
    end;
    a[i]:=nil;
  end;
end;
function pow(x,n,m:integer):integer;
var a,b:Int64;
begin
  a:=1; b:=x;
  while n>0 do
  begin
    if n mod 2 = 1 then a:=a*b mod m;
    b:=b*b mod m;
    n:=n shr 1;
  end;
  Result:=a;
end;
function equal(i,j,len:integer):boolean;
begin
  Result:=true;
  while len>0 do
  begin
    if s1[i]<>s2[j] then begin Result:=false; exit; end;
    dec(len); inc(i); inc(j);
  end;
end;
function check(i,j,len:integer):boolean;
var p:list;
begin
  p:=a[i];
  while p<>nil do
  begin
    if equal(p.x,j,len) then
    begin
      ri:=p.x;
      rj:=j;
      Result:=true;
      exit;
    end;
    p:=p.p;
  end;
  Result:=false;
end;
begin 
  Readln(n);
  Readln(s1);
  Readln(s2);
  ri:=0; rj:=0;
  l:=1; r:=n;
  while l<r do
  begin
    len:=(l+r+1) div 2;
    d:=pow(26,len-1,hashM);
    clear();
    hash:=0;
    for i:=1 to len do
      hash:=(hash*26+ord(s1[i])-ord('A')) mod hashM;

    add(1,hash);
    i:=len+1;
    while i<=n do
    begin
      hash:=(hash-((ord(s1[i-len])-ord('A'))*d mod hashM)+hashM) mod hashM;
      hash:=(hash*26+ord(s1[i])-ord('A')) mod hashM;
      add(i-len+1,hash);
      inc(i);
    end;

    hash:=0;
    for i:=1 to len do
      hash:=(hash*26+ord(s2[i])-ord('A')) mod hashM;

    f:=check(hash,1,len);
    i:=len+1;
    while not f and (i<=n) do
    begin
      hash:=(hash-((ord(s2[i-len])-ord('A'))*d mod hashM)+hashM) mod hashM;
      hash:=(hash*26+ord(s2[i])-ord('A')) mod hashM;
      f:=check(hash,i-len+1,len);
      inc(i);
    end;
    if f then L:=len else R:=len-1;
  end;
  if ri = 0 then  R:=0;
  for i:=1 to R do
    Write(s1[i+ri-1]);
end.