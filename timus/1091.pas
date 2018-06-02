{$APPTYPE CONSOLE}
var a:array[0..50] of integer;
n,m,res:integer;
function gcd(a,b:integer):integer;
begin
  if b = 0 then Result:=a else Result:=gcd(b, a mod b); 
end;
function norm(x,k:integer):boolean;
begin
  Result:=false; dec(k);
  while k>0 do
  begin
    x:=gcd(x,a[k]);
    if x=1 then exit else dec(k);
  end;
  Result:=true;
end;
procedure gen(k:integer);
var i:integer;
begin
  if k>m then
  begin
 //   for i:=1 to m do Write(a[i],' '); Writeln;
    if res=10000 then
    begin
      Writeln(res);
 //     Close(input); Close(output);
      halt(0);
    end else inc(res);
    exit;
  end;
  for i:=a[k-1]+1 to n-m+k do
    if norm(i,k) then
    begin
      a[k]:=i;
      gen(k+1);
    end;
end;


begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);     }
  Read(m,n); a[0]:=1; res:=0;
  gen(1);
  Writeln(res);
//  Close(input);Close(output);
end.
