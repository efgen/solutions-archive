program Z1470;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var a:array[0..150,0..150,0..150] of integer;
i,j,k,n,m,x1,x2,y1,y2,z1,z2,d,val:integer;
function prev(x:integer):integer;
begin
  Result:=x and (x-1);
end;
function next(x:integer):integer;
begin
  Result:=(x shl 1) - (x and (x-1));
end;

procedure add(i,j,k,val:integer);
var x,y,z:integer;
begin
  x:=i;
  while x<=n do
  begin
    y:=j;
    while y<=n do
    begin
      z:=k;
      while z<=n do
      begin
        a[x][y][z]:=a[x][y][z]+val;
        z:=next(z);
      end;
      y:=next(y);
    end;
    x:=next(x);
  end;
end;
function sum(i,j,k:integer):integer;
var res,x,y,z:integer;
begin
  res:=0;
  x:=i;
  while x>0 do
  begin
    y:=j;
    while y>0 do
    begin
      z:=k;
      while z>0 do
      begin
        res:=res+a[x][y][z];
        z:=prev(z);
      end;
      y:=prev(y);
    end;
    x:=prev(x);
  end;
  Result:=res;
end;
function rmq(x1,y1,z1,x2,y2,z2:integer):integer;
begin
  dec(x1);
  dec(y1);
  dec(z1);
  Result:=sum(x2,y2,z2)-sum(x2,y2,z1)-sum(x2,y1,z2)-sum(x1,y2,z2)
         +sum(x2,y1,z1)+sum(x1,y2,z1)+sum(x1,y1,z2)-sum(x1,y1,z1);
end;

begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } FillChar(a,SizeOf(a),0);
  Read(n);
  repeat
    Read(d);
    if d = 1 then
    begin
      Read(x1,y1,z1,val);
      inc(x1); inc(y1); inc(z1);
      add(x1,y1,z1,val);
    end else
    if d = 2 then
    begin
      Read(x1,y1,z1,x2,y2,z2);
      inc(x1); inc(y1); inc(z1);
      inc(x2); inc(y2); inc(z2);
      Writeln(rmq(x1,y1,z1,x2,y2,z2));
    end else break;
  until false;
//  Close(input); Close(output);
end.