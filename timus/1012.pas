const max=1800;
type my=array[1..max] of integer;
var k,n,i:longint;
p,q,t:my;

procedure Sum(var a,b:my);
var i,um,x:integer;
begin
  i:=max; um:=0;
  while i>0 do
  begin
    x:=a[i]+b[i]+um;
    a[i]:=x mod 10;
    um:=x div 10;
    dec(i);
  end;
end;

procedure Mult(var a:my; k:integer);
var i,x,um:integer;
begin
  i:=max; um:=0;
  while i>0 do
  begin
    x:=(a[i]*k)+um;
    a[i]:=x mod 10;
    um:=x div 10;
    dec(i);
  end;
end;

begin
  FillChar(k,ofs(t)-ofs(k)+SizeOf(t),0);
  Readln(n,k);
  p[max]:=1; t[max]:=k-1;
  for i:=2 to n do
  begin
    q:=t;
    Sum(t,p);
    Mult(t,k-1);
    p:=q;
  end;

  i:=1;
  while t[i]=0 do inc(i);
  while i<=max do
  begin Write(t[i]); inc(i); end;  Writeln;
end.