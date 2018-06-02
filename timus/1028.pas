{$APPTYPE CONSOLE}
const max = 32010;
var i,n,x,y:integer;
a:array[0..max] of integer;
u:array[0..15001] of integer;
function sum(x:integer):integer;
var s:integer;
begin
  s:=0;
  while x>0 do
  begin
    inc(s,a[x]);
    x:=x and (x-1);
  end;
  Result:=s;
end;
procedure modif(x:integer);
begin
  while x<=max do
  begin
    inc(a[x]);
    x:=(x shl 1) -(x and (x-1));
  end;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);       }
  FillChar(u,SizeOf(u),0);
  FillChar(a,SizeOf(a),0);
  Read(n);
  for i:=1 to n do
  begin
    Read(x,y); inc(x);
    inc(u[sum(x)]);
    modif(x);
  end;
  for i:=0 to n-1 do
    Writeln(u[i]);
  //Close(input); Close(output);
end.